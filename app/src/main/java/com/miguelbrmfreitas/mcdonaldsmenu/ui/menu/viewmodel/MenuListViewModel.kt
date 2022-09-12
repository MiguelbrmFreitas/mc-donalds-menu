package com.miguelbrmfreitas.mcdonaldsmenu.ui.menu.viewmodel

import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.miguelbrmfreitas.domain.repositories.ApiResult
import com.miguelbrmfreitas.domain.usecases.GetMenusUseCase
import com.miguelbrmfreitas.mcdonaldsmenu.ui.base.BaseViewModel
import com.miguelbrmfreitas.mcdonaldsmenu.ui.menu.adapters.MenusAdapter
import com.miguelbrmfreitas.mcdonaldsmenu.ui.utils.components.RecyclerComponent
import kotlinx.coroutines.launch

class MenuListViewModel(private val getMenusUseCase: GetMenusUseCase, val menuListData: MenuListData) : BaseViewModel()
{

    private val menusAdapter by lazy { MenusAdapter() }

    override fun setupView() {
        getMenus()
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

                            textTest.set(menuList[0].name)
                        }

                        menusAdapter.clear()
                        menusAdapter.addAll(menuList)
                    }
                }
                is ApiResult.Failure -> {

                }
            }
        }
    }

}