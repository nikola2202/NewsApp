package com.example.newsapp.newsfeed

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.R
import com.example.newsapp.databinding.ViewHolderNewsFeedItemBinding
import com.example.newsapp.model.NewsFeedItem

class NewsFeedRecyclerViewAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val newsFeedItems = mutableListOf<NewsFeedItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return NewsFeedItemViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as NewsFeedItemViewHolder).onBind(newsFeedItems[position])
    }

    override fun getItemCount(): Int {
        return newsFeedItems.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(newsFeedItems: List<NewsFeedItem>?) {
        this.newsFeedItems.clear()
        this.newsFeedItems.addAll(newsFeedItems?: emptyList())
        notifyDataSetChanged()
    }

    inner class NewsFeedItemViewHolder(parent: ViewGroup): RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.view_holder_news_feed_item,parent,false)
    ) {
        private val binding = ViewHolderNewsFeedItemBinding.bind(itemView)
        fun onBind(newsFeedItem: NewsFeedItem) {
            binding.title = newsFeedItem.title
            binding.description = newsFeedItem.description
        }

    }

}