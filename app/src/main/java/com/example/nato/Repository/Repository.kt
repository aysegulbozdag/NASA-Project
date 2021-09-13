package com.example.simpleretrofitexample.Repository

import com.example.nato.Model.RetrofitModel.CameraModel
import com.example.nato.Model.RetrofitModel.PhotoModel
import com.example.nato.Model.RetrofitModel.PhotosModel
import com.example.nato.Model.RetrofitModel.Post
import com.example.nato.Object.RetrofitInstance
import retrofit2.Response

class Repository {

//    suspend fun getPost(): Response<Post> {
//        //return RetrofitInstance.api.getPost()
//    }


    suspend fun getCuriosity(): Response<PhotosModel> {
        return RetrofitInstance.api.getCuriosity()
    }

    suspend fun getOpportunity(): Response<PhotosModel> {
        return RetrofitInstance.api.getOpportunity()
    }

    suspend fun getSprit(): Response<PhotosModel> {
        return RetrofitInstance.api.getSprit()
    }
}