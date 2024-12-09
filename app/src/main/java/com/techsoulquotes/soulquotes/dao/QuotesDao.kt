package com.techsoulquotes.soulquotes.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.techsoulquotes.soulquotes.model.Quotes

@Dao
interface QuotesDao {

    @Insert
    fun insertFavoriteQuotes(quotes: Quotes)

    @Delete
    fun deleteFavoriteQuotes(quotes: Quotes)

    @Query("Select * from tbl_quotes")
    fun getAllFavoriteQuotes(): LiveData<List<Quotes>>
}