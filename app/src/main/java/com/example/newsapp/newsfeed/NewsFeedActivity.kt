package com.example.newsapp.newsfeed

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.R
import com.example.newsapp.databinding.ActivityNewsFeedBinding
import com.example.newsapp.detail.DetailActivity
import com.example.newsapp.model.NewsFeedItem
import java.lang.ref.WeakReference

class NewsFeedActivity : AppCompatActivity(), NewsFeedRecyclerViewAdapter.NewsFeedItemInterface {

    private val viewModel: NewsFeedViewModel by lazy {
        ViewModelProvider(this)[NewsFeedViewModel::class.java]
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityNewsFeedBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_news_feed)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        val newsFeedAdapter = NewsFeedRecyclerViewAdapter(WeakReference(this))
        binding.recyclerView.adapter = newsFeedAdapter

        viewModel.fetchNewsFeed()
    }

    // region NewsFeedRecyclerViewAdapter.NewsFeedItemInterface
    override fun onNewsFeedItemClicked(url: String) {
        val intent = Intent(this,DetailActivity::class.java).apply {
            putExtra(DetailActivity.ARG_URL,url)
        }
        startActivity(intent)
    }

    override fun onFavouriteStatusChanged(newsFeedItemId:String,newStatus:Boolean) {
        viewModel.updateFavouriteStatus(newsFeedItemId,newStatus)
    }

    // endregion NewsFeedRecyclerViewAdapter.NewsFeedItemInterface

}

