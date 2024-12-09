package com.techsoulquotes.soulquotes.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.techsoulquotes.soulquotes.dao.QuotesDao
import com.techsoulquotes.soulquotes.model.Quotes

@Database(
    entities = [Quotes::class],
    version = 1
)
abstract class FavoriteQuotesDatabase : RoomDatabase(){
    abstract fun getQuotesDao():QuotesDao

    companion object{
        private var db:FavoriteQuotesDatabase? = null
        fun getDB(context: Context):FavoriteQuotesDatabase{
            if (db==null){
                db= Room.databaseBuilder(
                    context.applicationContext,
                    FavoriteQuotesDatabase::class.java,
                    "quotes_db"
                ).allowMainThreadQueries().build()

                return db!!
            }
            return db!!
        }
    }
}