package com.example.nato.Interface

import com.example.nato.Model.RetrofitModel.CameraModel
import com.example.nato.Model.RetrofitModel.PhotoModel
import com.example.nato.Model.RetrofitModel.PhotosModel
import com.example.nato.Model.RetrofitModel.Post
import retrofit2.Response
import retrofit2.http.GET

interface GetApiInterface {
    @GET("posts/1")
    suspend fun getPost(): Response<Post>

}

interface getCuriosityInterface {
    @GET("mars-photos/api/v1/rovers/Curiosity/photos?sol=1000&api_key=DEMO_KEY&page=1")
    suspend fun getCuriosity(): Response<PhotosModel>

    @GET("mars-photos/api/v1/rovers/Opportunity/photos?sol=1000&api_key=DEMO_KEY&page=1")
    suspend fun getOpportunity(): Response<PhotosModel>

    @GET("mars-photos/api/v1/rovers/Spirit/photos?sol=1000&api_key=DEMO_KEY&page=1")
    suspend fun getSprit(): Response<PhotosModel>
}



