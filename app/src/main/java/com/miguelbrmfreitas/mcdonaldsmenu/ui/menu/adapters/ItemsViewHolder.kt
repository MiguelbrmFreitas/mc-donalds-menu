package com.miguelbrmfreitas.mcdonaldsmenu.ui.menu.adapters

import androidx.recyclerview.widget.RecyclerView
import com.miguelbrmfreitas.domain.entities.ItemEntity
import com.miguelbrmfreitas.mcdonaldsmenu.databinding.AdapterItemBinding

class ItemsViewHolder (
    private val items: ArrayList<ItemEntity>,
    val view: AdapterItemBinding
) : RecyclerView.ViewHolder(view.root)
{
    fun onBind(position: Int) {
        view.apply {
            itemName = items[position].name

        }
    }
}