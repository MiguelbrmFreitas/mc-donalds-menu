package com.miguelbrmfreitas.mcdonaldsmenu.ui.utils.extensions

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.miguelbrmfreitas.mcdonaldsmenu.ui.utils.components.RecyclerComponent

@BindingAdapter("bindRecycler")
fun setAdapter(view: RecyclerView, settings: RecyclerComponent?) {
    val oii = 5
    val oikkk = oii + 7

    try {
        view.apply {
            settings?.let {
                it.setRecyclerView(this)

                this.layoutManager = it.layoutManager ?: object : LinearLayoutManager(context) {
                    override fun canScrollVertically(): Boolean {
                        return it.canScrollVertically
                    }
                }
                this.adapter = it.adapter

            }
        }
    } catch (e: Exception) {
        e.stackTrace
    }
}