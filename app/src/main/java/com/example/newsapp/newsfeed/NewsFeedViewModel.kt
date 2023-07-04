package com.example.newsapp.newsfeed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsapp.model.NewsFeedItem

class NewsFeedViewModel: ViewModel() {

    private val repository = NewsFeedRepository()

    private val _newsFeedLiveData = MutableLiveData<List<NewsFeedItem>>()
    val newsFeedLiveData: LiveData<List<NewsFeedItem>> = _newsFeedLiveData

    fun fetchNewsFeed() {
        repository.fetchNewsFeed(_newsFeedLiveData)
    }

    fun updateFavouriteStatus(id:String,isFavourite:Boolean) {
        repository.updateFavouriteStatus(id,isFavourite)
    }

}