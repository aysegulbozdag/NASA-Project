package com.example.nato.Model.RetrofitModel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PhotoModel(
    var id: Int? = 0,
    var sol: Int? = 0,
    var camera: CameraModel? = null,
    var earth_date: String? = null,
    var img_src: String? = null,
    var rover: RoverModel? = null
)

