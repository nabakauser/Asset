package com.example.asset

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import org.json.JSONObject
import java.io.FileReader
import java.io.IOException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getJsonFromAsset(this)
        val news = getNews()
        Log.d("getNews", "onCreate: "+ news)
    }

    private fun getJsonFromAsset(context: Context): News {

        var jsonString: String? = null
        val fileName = "newsApi.json"
        try {
            jsonString = context.assets.open(fileName)
                .bufferedReader()
                .use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
        }
        val newsType = object : TypeToken<News>() {}.type
        val stringFromGson: News =  Gson().fromJson(jsonString,newsType)
        Log.d("gsonString", "getJsonFromAsset: " +stringFromGson)
        return stringFromGson
    }

    private fun getNews() : News {
        return Gson().fromJson(
            assets.open("newsApi.json").bufferedReader(),
            object : TypeToken<News>() {}.type
        )
    }

//        val jsonObject = JSONObject(data)
//
//        val author = jsonObject.getString("articles")
//        val title = jsonObject.getInt("totalResults")
//
//        Log.d("readSampleJSON", "author : $author || title : $title")

    }