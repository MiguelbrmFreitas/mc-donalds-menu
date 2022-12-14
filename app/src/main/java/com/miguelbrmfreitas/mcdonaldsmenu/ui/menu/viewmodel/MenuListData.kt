package com.miguelbrmfreitas.mcdonaldsmenu.ui.menu.viewmodel

import android.view.View
import androidx.databinding.ObservableField
import com.miguelbrmfreitas.mcdonaldsmenu.ui.utils.components.RecyclerComponent

data class MenuListData
(
    val recyclerMenus: ObservableField<RecyclerComponent> = ObservableField(),
    val progressVisibility: ObservableField<Int> = ObservableField(View.VISIBLE),
    val bottomSheetVisibility: ObservableField<Boolean> = ObservableField(false)
)