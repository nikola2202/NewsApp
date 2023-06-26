package com.example.newsapp.newsfeed

import androidx.lifecycle.MutableLiveData
import com.example.newsapp.model.NewsFeedItem
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class NewsFeedRepository {

    val database = Firebase.database
    val newsFeedReference = database.getReference("news feed")

    fun fetchNewsFeed(liveData: MutableLiveData<List<NewsFeedItem>>) {
        newsFeedReference
            .orderByChild("_rank")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val newsFeedItems: List<NewsFeedItem> = snapshot.children.map { dataSnapshot ->
                        dataSnapshot.getValue(NewsFeedItem::class.java)!!
                }

                liveData.postValue(newsFeedItems)

            }

            override fun onCancelled(error: DatabaseError) {
                // Nothing to do
            }
        })
    }

}