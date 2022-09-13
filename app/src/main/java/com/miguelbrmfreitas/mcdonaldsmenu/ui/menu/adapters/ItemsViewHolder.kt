package com.miguelbrmfreitas.mcdonaldsmenu.ui.menu.adapters

import androidx.recyclerview.widget.RecyclerView
import com.miguelbrmfreitas.domain.entities.ItemEntity
import com.miguelbrmfreitas.mcdonaldsmenu.databinding.AdapterItemBinding
import com.miguelbrmfreitas.mcdonaldsmenu.ui.utils.extensions.setImageUrl

class ItemsViewHolder (
    private val items: ArrayList<ItemEntity>,
    val view: AdapterItemBinding
) : RecyclerView.ViewHolder(view.root)
{
    fun onBind(position: Int) {
        val context = view.root.context

        view.apply {
            itemName = items[position].name
            ivItem.setImageUrl(context, items[position].url)
        }
    }
}