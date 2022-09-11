package com.miguelbrmfreitas.domain.repositories

import com.miguelbrmfreitas.domain.entities.MenuEntity


interface McDonaldsRepository
{
    suspend fun getMenus(): ApiResult<List<MenuEntity>>
}