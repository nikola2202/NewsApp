package com.example.newsapp

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.model.NewsFeedItem
import com.example.newsapp.newsfeed.NewsFeedRecyclerViewAdapter

//region RecyclerView
@BindingAdapter("setItems")
fun setItems(recyclerView: RecyclerView, list: List<NewsFeedItem>?) {
    (recyclerView.adapter as NewsFeedRecyclerViewAdapter).setItems(list)
}
//endregion RecyclerView