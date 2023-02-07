package com.example.asset

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.asset.model.News
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val news = getNews()
        Log.d("getNews", "onCreate: $news")
    }

    private fun getNews() : News {
        return Gson().fromJson(
            assets.open("newsApi.json").bufferedReader(),
            object : TypeToken<News>() {}.type
        )
    }
}