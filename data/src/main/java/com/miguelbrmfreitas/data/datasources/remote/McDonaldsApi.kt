package com.miguelbrmfreitas.data.datasources.remote

import retrofit2.Response
import retrofit2.http.GET

interface McDonaldsApi
{
    @GET("menu")
    suspend fun getMenus(): Response<McDonaldsResponse>
}