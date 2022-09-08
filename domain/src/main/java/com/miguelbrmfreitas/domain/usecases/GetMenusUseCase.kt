package com.miguelbrmfreitas.domain.usecases

import com.miguelbrmfreitas.domain.repositories.McDonaldsRepository

class GetMenusUseCase (
    private val mcDonaldsRepository: McDonaldsRepository
)
{
    suspend operator fun invoke() = mcDonaldsRepository.getMenus()
}