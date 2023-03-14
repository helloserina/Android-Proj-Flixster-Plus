package com.example.flixster

import com.google.gson.annotations.SerializedName

class Movie {
    @SerializedName("title")
    var title: String? = null

    @JvmField
    @SerializedName("image")
    var image: String? = null

    @JvmField
    @SerializedName("description")
    var description: String? = null


}