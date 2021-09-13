package com.example.nato.Model.RetrofitModel

import com.google.gson.annotations.SerializedName

data class CameraModel(
    var id: Int? = 0,
    var name: String? = null,
    var rover_id: Int? = 0,
    var full_name: String? = null
)