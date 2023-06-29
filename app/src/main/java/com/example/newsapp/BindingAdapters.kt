package com.example.newsapp

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.model.NewsFeedItem
import com.example.newsapp.newsfeed.NewsFeedRecyclerViewAdapter
import com.squareup.picasso.Picasso

//region RecyclerView
@BindingAdapter("setItems")
fun setItems(recyclerView: RecyclerView, list: List<NewsFeedItem>?) {
    (recyclerView.adapter as NewsFeedRecyclerViewAdapter).setItems(list)
}
//endregion RecyclerView

//region ImageView
@BindingAdapter("loadWithPicasso")
fun loadWithPicasso(imageView: ImageView,imageUrl: String) {
    Picasso.get().load(imageUrl).into(imageView)
}
//endregion ImageView