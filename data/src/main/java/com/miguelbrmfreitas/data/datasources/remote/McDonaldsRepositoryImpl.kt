package com.miguelbrmfreitas.data.datasources.remote

import com.miguelbrmfreitas.domain.repositories.McDonaldsRepository
import com.miguelbrmfreitas.domain.repositories.ApiResult
import com.miguelbrmfreitas.domain.entities.MenuEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class McDonaldsRepositoryImpl(private val mcDonaldsApi: McDonaldsApi) : McDonaldsRepository
{
    override suspend fun getMenus(): ApiResult<List<MenuEntity>> =
        withContext(Dispatchers.IO) {
            val response = mcDonaldsApi.getMenus()
            if (response.isSuccessful) {
                response.body()?.menus?.let { menus ->
                    return@withContext ApiResult.Success(menus)
                } ?: kotlin.run {
                    return@withContext ApiResult.Failure(Exception(response.message()))
                }
            } else {
                return@withContext ApiResult.Failure(Exception(response.message()))
            }
        }
}