package com.pinterestimageload.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResponseModel(

    val id: String,
    val created_at: String,
    val width: Int,
    val height: Int,
    val color: String,
    val likes: Int,
    val liked_by_user: Boolean,
    val user: User,
    val current_user_collections: List<String>,
    val urls: Urls,
    val categories: List<Categories>,
    val links: Links
) : Parcelable