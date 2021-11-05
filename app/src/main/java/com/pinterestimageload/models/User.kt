package com.pinterestimageload.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(

    @SerializedName("id") val id: String,
    @SerializedName("username") val username: String,
    @SerializedName("name") val name: String,
    @SerializedName("profile_image") val profile_image: Profile_image,
    @SerializedName("links") val links: Links
) : Parcelable