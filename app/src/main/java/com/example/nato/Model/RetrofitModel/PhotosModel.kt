package com.example.nato.Model.RetrofitModel

import com.google.gson.annotations.SerializedName

data class PhotosModel(
    @SerializedName("photos")
    var photoList: ArrayList<PhotoModel>
)