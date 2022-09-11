package com.miguelbrmfreitas.mcdonaldsmenu.ui.menu

import androidx.lifecycle.viewModelScope
import com.miguelbrmfreitas.domain.repositories.ApiResult
import com.miguelbrmfreitas.domain.entities.MenuEntity
import com.miguelbrmfreitas.domain.usecases.GetMenusUseCase
import com.miguelbrmfreitas.mcdonaldsmenu.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class MenuListViewModel(private val getMenusUseCase: GetMenusUseCase, private val menuListData: MenuListData) : BaseViewModel()
{
    private var menuList: ArrayList<MenuEntity> = arrayListOf()

    override fun setupView() {
        getMenus()
    }

    private fun getMenus() {
        viewModelScope.launch {
            when (val response = getMenusUseCase.invoke()) {
                is ApiResult.Success -> {
                    response.data.let { mcDonaldsResponse ->
                        menuList.addAll(mcDonaldsResponse)
                        val menu = mcDonaldsResponse[0]
                    }
                }
                is ApiResult.Failure -> {

                }
            }
        }
    }

}