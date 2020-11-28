package com.muhammaduzaer.newsapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.muhammaduzaer.newsapp.models.News
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getNews()
    }

    private fun getNews() {
        val news = NewsService.newsInstance.getHeadLines("in", 1)
        news.enqueue(object: retrofit2.Callback<News>{

            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("CheezyCode", "Error in Fetching News", t)
            }

            override fun onResponse(call: Call<News>, response: Response<News>) {
                val news = response.body()
                if (news != null) {
                    Log.d("CheezyCode", news.toString())
                }

            }



        })
    }
}