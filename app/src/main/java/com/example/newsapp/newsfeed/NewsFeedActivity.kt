package com.example.newsapp.newsfeed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.newsapp.R
import com.example.newsapp.databinding.ActivityNewsFeedBinding

class NewsFeedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityNewsFeedBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_news_feed)

        val viewModel: NewsFeedViewModel =
            ViewModelProvider(this)[NewsFeedViewModel::class.java]

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        viewModel.fetchNewsFeed()


    }
}