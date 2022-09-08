package com.miguelbrmfreitas.data.datasources.remote

import android.app.appsearch.GetByDocumentIdRequest
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.miguelbrmfreitas.domain.entities.McDonaldsResponse
import com.miguelbrmfreitas.domain.repositories.McDonaldsRepository
import com.miguelbrmfreitas.domain.usecases.GetMenusUseCase
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

private const val TIME_OUT = 30L
private const val BASE_URL = "https://mcdonalds.trio.dev"

val remoteDataModule = module {
    single { createService(get()) }

    single { createRetrofit(get(), get(), BASE_URL) }

    single { createOkHttpClient(get()) }

    single { createLoggingInterceptor() }

    single { createMoshiBuilder() }

}

fun createMoshiBuilder(): Moshi {
    return Moshi.Builder()
        .add(KotlinJsonAdapterFactory()).build()
}

fun createLoggingInterceptor(): HttpLoggingInterceptor {
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    return loggingInterceptor
}

fun createOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
    return OkHttpClient.Builder()
        .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
        .readTimeout(TIME_OUT, TimeUnit.SECONDS)
        .addInterceptor(loggingInterceptor).build()
}

fun createRetrofit(okHttpClient: OkHttpClient, moshi: Moshi, url: String): Retrofit {
    return Retrofit.Builder()
        .baseUrl(url)
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addConverterFactory(ScalarsConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()
}

fun createService(retrofit: Retrofit): McDonaldsApi {
    return retrofit.create(McDonaldsApi::class.java)
}

fun createMcDonaldsRepository(mcDonaldsApi: McDonaldsApi): McDonaldsRepository {
    return McDonaldsRepositoryImpl(mcDonaldsApi)
}

fun createGetMenusUseCase(mcDonaldsRepository: McDonaldsRepository): GetMenusUseCase {
    return GetMenusUseCase(mcDonaldsRepository)
}
