package com.example.nato.Model.RetrofitModel

import com.google.gson.annotations.SerializedName

data class RoverModel(
    var id: Int? = 0,
    var name: String? = null,
    var landing_date: String? = null,
    var launch_date: String? = null,
    var status: String? = null
)


/**
 * "rover": {
"id": 6,
"name": "Opportunity",
"landing_date": "2004-01-25",
"launch_date": "2003-07-07",
"status": "complete"
}
 *
 * */