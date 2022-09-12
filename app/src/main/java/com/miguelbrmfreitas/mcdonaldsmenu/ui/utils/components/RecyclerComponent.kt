package com.miguelbrmfreitas.mcdonaldsmenu.ui.utils.components

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView

data class RecyclerComponent(
    val adapter: RecyclerView.Adapter<*>,
    val layoutManager: LinearLayoutManager? = null,
    val snapOneByOne: LinearSnapHelper? = null,
    val canScrollVertically: Boolean = false,
    val onScrollListener: RecyclerView.OnScrollListener? = null
){
    private var view: RecyclerView? = null

    fun setRecyclerView(view: RecyclerView?){
        this.view = view
    }
}