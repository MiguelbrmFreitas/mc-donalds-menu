package com.miguelbrmfreitas.mcdonaldsmenu.ui.menu.viewmodel

import android.graphics.drawable.Drawable
import android.view.View
import androidx.databinding.ObservableField
import com.miguelbrmfreitas.mcdonaldsmenu.ui.utils.components.RecyclerComponent

data class ItemDetailData
(
    val imageUrl: ObservableField<String> = ObservableField(""),
    val itemName: ObservableField<String> = ObservableField(""),
    val itemPrice: ObservableField<String> = ObservableField(""),
    val itemDescription: ObservableField<String> = ObservableField("")
)