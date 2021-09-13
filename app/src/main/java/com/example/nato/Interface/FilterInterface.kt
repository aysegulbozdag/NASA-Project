package com.example.nato.Interface

import com.example.nato.Model.RetrofitModel.PhotosModel
import retrofit2.Response

interface FilterInterface {
     fun getFilter(list: ArrayList<String>)

}