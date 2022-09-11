package com.miguelbrmfreitas.data.datasources.remote

import com.miguelbrmfreitas.domain.entities.MenuEntity

data class McDonaldsResponse(
    val menus: List<MenuEntity>
)