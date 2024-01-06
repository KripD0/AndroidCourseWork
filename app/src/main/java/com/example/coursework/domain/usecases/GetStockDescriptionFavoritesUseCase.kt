package com.example.coursework.domain.usecases

import com.example.coursework.data.entity.StockDescription
import com.example.coursework.domain.repository.Repository
import com.example.coursework.domain.utils.Rezult
class GetStockDescriptionFavoritesUseCase(private val repository: Repository) {
    suspend operator fun invoke(): Rezult<List<StockDescription>> {
        return repository.getFavoriteStockDescription()
    }
}