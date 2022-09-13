package com.miguelbrmfreitas.mcdonaldsmenu.ui.menu.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.miguelbrmfreitas.domain.entities.MenuEntity
import com.miguelbrmfreitas.mcdonaldsmenu.R
import com.miguelbrmfreitas.mcdonaldsmenu.databinding.AdapterMenuBinding

class MenusAdapter : RecyclerView.Adapter<MenusViewHolder>()
{
    private val menus: ArrayList<MenuEntity> = arrayListOf()
    private var listener: ItemAdapterListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenusViewHolder {
        val view = DataBindingUtil.inflate<AdapterMenuBinding>(
            LayoutInflater.from(parent.context),
            R.layout.adapter_menu,
            parent,
            false
        )

        return MenusViewHolder(
            view = view,
            menus = this.menus,
            listener = listener
        )
    }

    override fun onBindViewHolder(holder: MenusViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun getItemCount() = menus.size

    fun addAll(menus: List<MenuEntity>, listener: ItemAdapterListener) {
        this.menus.addAll(menus)
        this.listener = listener
        notifyDataSetChanged()
    }

    fun clear() {
        while (itemCount > 0) {
            remove(menus[0])
        }
    }

    private fun remove(menu: MenuEntity) {
        val index = menus.indexOf(menu)
        if (index > -1) {
            menus.removeAt(index)
            notifyItemChanged(index)
        }
    }

}