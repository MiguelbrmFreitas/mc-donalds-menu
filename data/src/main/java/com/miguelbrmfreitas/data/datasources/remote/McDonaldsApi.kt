package com.miguelbrmfreitas.data.datasources.remote

import com.miguelbrmfreitas.domain.entities.McDonaldsResponse
import com.miguelbrmfreitas.domain.repositories.ApiResult
import retrofit2.http.GET

interface McDonaldsApi
{
    @GET("/menu")
    suspend fun getMenus(): ApiResult<McDonaldsResponse>
}