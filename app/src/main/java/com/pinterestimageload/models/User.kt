package com.pinterestimageload.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(

    val id: String,
    val username: String,
    val name: String,
    val profile_image: Profile_image,
    val links: Links
) : Parcelable