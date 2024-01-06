package com.example.coursework.data.database.entity

import com.example.coursework.data.entity.StockDescription
import com.example.coursework.domain.utils.Rezult
import com.example.coursework.domain.utils.safeResult
class StockDescriptionSource(private val dao: StockDescriptionDao) {
    private val id: Long = 0
    suspend fun save(entity: StockDescription) =
        safeResult { dao.save(entity.toEntity(entity.ticket)) }
    suspend fun delete(ticket: String) = safeResult { dao.delete(ticket) }
    suspend fun get(ticket: String) = safeResult { dao.get(ticket)?.toDomain() }
    suspend fun getAll(): Rezult<List<StockDescription>> =
        safeResult { dao.getAll().map { it.toDomain() } }
}