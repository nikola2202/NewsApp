package com.example.newsapp.model

data class NewsFeedItem(
    val id: String = "",
    val title: String = "",
    val description: String = "",
    val source: String = "",
    val published: String = "",
    val url: String = "",
    val image_url: String = "",
    val favourite: Boolean = false
)