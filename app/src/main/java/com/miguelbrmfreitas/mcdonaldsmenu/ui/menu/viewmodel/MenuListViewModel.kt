package com.miguelbrmfreitas.mcdonaldsmenu.ui.menu.viewmodel

import android.view.View
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.miguelbrmfreitas.domain.entities.ItemEntity
import com.miguelbrmfreitas.domain.repositories.ApiResult
import com.miguelbrmfreitas.domain.usecases.GetMenusUseCase
import com.miguelbrmfreitas.mcdonaldsmenu.ui.base.BaseViewModel
import com.miguelbrmfreitas.mcdonaldsmenu.ui.menu.adapters.ItemAdapterListener
import com.miguelbrmfreitas.mcdonaldsmenu.ui.menu.adapters.MenusAdapter
import com.miguelbrmfreitas.mcdonaldsmenu.ui.utils.components.RecyclerComponent
import com.miguelbrmfreitas.mcdonaldsmenu.ui.utils.extensions.toPrice
import kotlinx.coroutines.launch

class MenuListViewModel(private val getMenusUseCase: GetMenusUseCase, val menuListData: MenuListData, val itemDetailData: ItemDetailData) : BaseViewModel(), ItemAdapterListener
{

    private val menusAdapter by lazy { MenusAdapter() }

    private var selectedItem: ItemEntity? = null

    override fun startView() {
        getMenus()
    }

    fun setBottomSheetData() {
        selectedItem?.let { item ->
            itemDetailData.apply {
                itemName.set(item.name)
                itemPrice.set(item.price.toPrice())
                itemDescription.set(item.description)
                imageUrl.set(item.url)
            }
        }
    }

    private fun getMenus() {
        viewModelScope.launch {
            when (val response = getMenusUseCase.invoke()) {
                is ApiResult.Success -> {
                    response.data.let { menuList ->
                        menuListData.apply {
                            recyclerMenus.set(
                                RecyclerComponent(
                                    adapter = menusAdapter
                                )
                            )

                            menusAdapter.clear()
                            menusAdapter.addAll(menuList, this@MenuListViewModel)

                            progressVisibility.set(View.GONE)
                        }
                    }
                }
                is ApiResult.Failure -> {

                }
            }
        }
    }

    override fun onItemClicked(item: ItemEntity) {
        selectedItem = item
        menuListData.bottomSheetVisibility.set(true)
    }

}