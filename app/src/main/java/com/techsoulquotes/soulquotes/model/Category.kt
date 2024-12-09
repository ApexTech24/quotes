package com.techsoulquotes.soulquotes.model

import com.techsoulquotes.soulquotes.R

data class Category(
    var id: Int,
    val title :String,
    val image :Int
)

val categoryList= mutableListOf<Category>(
    Category(1, "A", R.drawable.favorite_gray),
    Category(2, "A", R.drawable.favorite_gray),
    Category(3, "A", R.drawable.favorite_gray),
    Category(4, "A", R.drawable.favorite_gray),
    Category(5, "A", R.drawable.favorite_gray),
    Category(6, "A", R.drawable.favorite_gray),
    Category(7, "A", R.drawable.favorite_gray),
    Category(8, "A", R.drawable.favorite_gray),
)
