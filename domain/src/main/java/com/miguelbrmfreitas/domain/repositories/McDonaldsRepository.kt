package com.miguelbrmfreitas.domain.repositories

import com.miguelbrmfreitas.domain.entities.McDonaldsResponse


interface McDonaldsRepository
{
    suspend fun getMenus(): ApiResult<McDonaldsResponse>
}