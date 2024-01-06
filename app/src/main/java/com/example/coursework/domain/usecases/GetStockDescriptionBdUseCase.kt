package com.example.coursework.domain.usecases

import com.example.coursework.data.entity.StockDescription
import com.example.coursework.domain.repository.Repository
import com.example.coursework.domain.utils.Rezult
class GetStockDescriptionBdUseCase(private val repository: Repository) {
    suspend operator fun invoke(ticket: String): Rezult<StockDescription?> {
        return repository.getStockDescriptionBd(ticket)
    }
}