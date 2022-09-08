package com.miguelbrmfreitas.mcdonaldsmenu.di

import com.miguelbrmfreitas.data.datasources.remote.createGetMenusUseCase
import com.miguelbrmfreitas.data.datasources.remote.createMcDonaldsRepository
import org.koin.dsl.module

val appModule = module {
    single { createMcDonaldsRepository(get()) }

    single { createGetMenusUseCase(get()) }
}