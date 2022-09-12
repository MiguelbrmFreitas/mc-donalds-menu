package com.miguelbrmfreitas.mcdonaldsmenu.ui.menu.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.miguelbrmfreitas.domain.entities.MenuEntity
import com.miguelbrmfreitas.mcdonaldsmenu.databinding.AdapterMenuBinding

class MenusViewHolder(
    private val menus: ArrayList<MenuEntity>,
    val view: AdapterMenuBinding
) : RecyclerView.ViewHolder(view.root)
{
    private val itemsAdapter by lazy { ItemsAdapter() }

    fun onBind(position: Int) {
        view.apply {
            menuName = menus[position].name
            itemsAdapter.addAll(menus[position].items)
            recyclerViewItems.adapter = itemsAdapter
        }
    }
}