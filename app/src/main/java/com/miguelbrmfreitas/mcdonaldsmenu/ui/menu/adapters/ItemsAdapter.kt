package com.miguelbrmfreitas.mcdonaldsmenu.ui.menu.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.miguelbrmfreitas.domain.entities.ItemEntity
import com.miguelbrmfreitas.mcdonaldsmenu.R
import com.miguelbrmfreitas.mcdonaldsmenu.databinding.AdapterItemBinding

class ItemsAdapter : RecyclerView.Adapter<ItemsViewHolder>()
{
    private val items: ArrayList<ItemEntity> = arrayListOf()
    private var listener: ItemAdapterListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        val view = DataBindingUtil.inflate<AdapterItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.adapter_item,
            parent,
            false
        )

        return ItemsViewHolder(
            view = view,
            items = items,
            listener = listener
        )
    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun getItemCount() = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun addAll(items: List<ItemEntity>, listener: ItemAdapterListener?) {
        this.items.addAll(items)
        this.listener = listener
        notifyDataSetChanged()
    }

    fun clear() {
        while (itemCount > 0) {
            remove(items[0])
        }
    }

    fun remove(menu: ItemEntity) {
        val index = items.indexOf(menu)
        if (index > -1) {
            items.removeAt(index)
            notifyItemChanged(index)
        }
    }

}