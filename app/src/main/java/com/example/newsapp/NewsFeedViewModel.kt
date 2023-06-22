package com.example.newsapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.delay

class NewsFeedViewModel: ViewModel() {

    private var number = 0
    val liveData: LiveData<Int> = liveData {
        while (true) {
            delay(200)
            emit(number)
            number++
        }
    }
}