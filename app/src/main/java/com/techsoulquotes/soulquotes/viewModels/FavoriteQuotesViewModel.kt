package com.techsoulquotes.soulquotes.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.techsoulquotes.soulquotes.db.FavoriteQuotesDatabase
import com.techsoulquotes.soulquotes.model.Quotes
import com.techsoulquotes.soulquotes.repositorys.FavoriteQuotesRepository
import kotlinx.coroutines.launch

class FavoriteQuotesViewModel(application: Application): AndroidViewModel(application) {

    private lateinit var repository: FavoriteQuotesRepository
    init {
        val dao = FavoriteQuotesDatabase.getDB(application).getQuotesDao()
        repository= FavoriteQuotesRepository(dao)
    }

    fun insertFavoriteQuotes(quotes: Quotes)= repository.insertFavoriteQuotes(quotes)

    fun deleteFavoriteQuotes(quotes: Quotes){
        viewModelScope.launch {
            repository.deleteFavoriteQuotes(quotes)
        }

    }

    fun getAllFavoriteQuotes(): LiveData<List<Quotes>> =repository.getAllFavoriteQuotes()


}