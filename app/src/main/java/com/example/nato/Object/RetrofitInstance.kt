package com.example.nato.Object

import com.example.nato.Interface.GetApiInterface
import com.example.nato.Interface.getCuriosityInterface
import com.example.simpleretrofitexample.Util.Constants.Companion.baseUrl
import com.example.simpleretrofitexample.Util.Constants.Companion.baseUrlCuriosity
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(baseUrlCuriosity)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api : getCuriosityInterface by lazy {
        retrofit.create(getCuriosityInterface::class.java)
    }
}