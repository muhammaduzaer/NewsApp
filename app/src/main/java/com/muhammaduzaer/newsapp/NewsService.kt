package com.muhammaduzaer.newsapp

import com.muhammaduzaer.newsapp.models.News
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//http://newsapi.org/v2/everything?q=apple&from=2020-11-27&to=2020-11-27&sortBy=popularity&apiKey=00d2c5c7539745c6a8d84e53a6f5e616
//http://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=00d2c5c7539745c6a8d84e53a6f5e616

const val BASE_URL = "http://newsapi.org/"
const val API_KEY = "00d2c5c7539745c6a8d84e53a6f5e616"

interface NewsInterface {

    @GET("v2/top-headlines?apikey=$API_KEY")
    fun getHeadLines(@Query("country") country: String, @Query("page") page: Int) : retrofit2.Call<News>

    //http://newsapi.org/v2/top-headlines?apikey=$API_KEY&country=in&page=1


}

object NewsService {
    val newsInstance: NewsInterface
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInstance = retrofit.create(NewsInterface::class.java)
        }
    }
