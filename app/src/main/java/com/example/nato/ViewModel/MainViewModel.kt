package com.example.simpleretrofitexample.MainViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nato.Model.RetrofitModel.CameraModel
import com.example.nato.Model.RetrofitModel.PhotoModel
import com.example.nato.Model.RetrofitModel.PhotosModel
import com.example.nato.Model.RetrofitModel.Post
import com.example.simpleretrofitexample.Repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {

    val myResponse: MutableLiveData<Response<Post>> = MutableLiveData();
    val responseCameraModel: MutableLiveData<Response<PhotosModel>> = MutableLiveData();
//    fun getPost(){
//        viewModelScope.launch {
//            val  response : Response<Post> = repository.getPost()
//            myResponse.value = response
//        }
//    }
    fun getCuriosity(){
        viewModelScope.launch {
            val  response : Response<PhotosModel> = repository.getCuriosity()
            responseCameraModel.value = response
        }
    }
    fun getOpportunity(){
        viewModelScope.launch {
            val  response : Response<PhotosModel> = repository.getOpportunity()
            responseCameraModel.value = response
        }
    }
    fun getSplit(){
        viewModelScope.launch {
            val  response : Response<PhotosModel> = repository.getSprit()
            responseCameraModel.value = response
        }
    }
}