package com.miguelbrmfreitas.data.datasources.remote

import com.miguelbrmfreitas.domain.entities.McDonaldsResponse
import com.miguelbrmfreitas.domain.repositories.McDonaldsRepository
import com.miguelbrmfreitas.domain.repositories.ApiResult

class McDonaldsRepositoryImpl(private val mcDonaldsApi: McDonaldsApi) : McDonaldsRepository
{
    override suspend fun getMenus(): ApiResult<McDonaldsResponse> {
        return mcDonaldsApi.getMenus()
    }

}