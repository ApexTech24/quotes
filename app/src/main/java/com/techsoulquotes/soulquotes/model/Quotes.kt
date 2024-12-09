package com.techsoulquotes.soulquotes.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_quotes")
data class Quotes(
    @PrimaryKey(autoGenerate = true)
    val id:Long,
    val mQuote: String,
    var isFavorite : Boolean=false
)
