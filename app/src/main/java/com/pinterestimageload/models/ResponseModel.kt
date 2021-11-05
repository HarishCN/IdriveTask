package com.pinterestimageload.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResponseModel(

    @SerializedName("id") val id: String,
    @SerializedName("created_at") val created_at: String,
    @SerializedName("width") val width: Int,
    @SerializedName("height") val height: Int,
    @SerializedName("color") val color: String,
    @SerializedName("likes") val likes: Int,
    @SerializedName("liked_by_user") val liked_by_user: Boolean,
    @SerializedName("user") val user: User,
    @SerializedName("current_user_collections") val current_user_collections: List<String>,
    @SerializedName("urls") val urls: Urls,
    @SerializedName("categories") val categories: List<Categories>,
    @SerializedName("links") val links: Links
) : Parcelable