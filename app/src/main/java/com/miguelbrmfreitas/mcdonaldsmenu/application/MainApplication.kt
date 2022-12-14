package com.miguelbrmfreitas.mcdonaldsmenu.application

import android.app.Application
import androidx.multidex.MultiDex
import com.miguelbrmfreitas.data.datasources.remote.remoteDataModule
import com.miguelbrmfreitas.mcdonaldsmenu.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this)

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@MainApplication)
            modules(listOf(remoteDataModule, appModule))
        }

    }
}