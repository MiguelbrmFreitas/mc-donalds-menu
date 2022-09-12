package com.miguelbrmfreitas.mcdonaldsmenu.di

import com.miguelbrmfreitas.data.datasources.remote.createGetMenusUseCase
import com.miguelbrmfreitas.data.datasources.remote.createMcDonaldsRepository
import com.miguelbrmfreitas.mcdonaldsmenu.ui.menu.viewmodel.MenuListData
import com.miguelbrmfreitas.mcdonaldsmenu.ui.menu.viewmodel.MenuListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel { MenuListViewModel(get(), get()) }

    factory { MenuListData() }

    single { createMcDonaldsRepository(get()) }

    single { createGetMenusUseCase(get()) }
}