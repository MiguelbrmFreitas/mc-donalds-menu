package com.miguelbrmfreitas.mcdonaldsmenu.ui.menu.adapters

import com.miguelbrmfreitas.domain.entities.ItemEntity

interface ItemAdapterListener
{
    fun onItemClicked(item: ItemEntity)
}