package com.techsoulquotes.soulquotes.repositorys

import androidx.lifecycle.LiveData
import com.techsoulquotes.soulquotes.dao.QuotesDao
import com.techsoulquotes.soulquotes.model.Quotes

class FavoriteQuotesRepository(private val dao: QuotesDao) {
    fun insertFavoriteQuotes(quotes: Quotes)= dao.insertFavoriteQuotes(quotes)

    fun deleteFavoriteQuotes(quotes: Quotes)=dao.deleteFavoriteQuotes(quotes)

    fun getAllFavoriteQuotes(): LiveData<List<Quotes>> =dao.getAllFavoriteQuotes()
}