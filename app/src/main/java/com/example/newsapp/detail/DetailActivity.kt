package com.example.newsapp.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.newsapp.R
import com.example.newsapp.databinding.ActivityDetailBinding

class DetailActivity: AppCompatActivity() {

    companion object {
        const val ARG_URL = "_url"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityDetailBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_detail)

        binding.url = intent.getStringExtra(ARG_URL) ?: ""
    }
}