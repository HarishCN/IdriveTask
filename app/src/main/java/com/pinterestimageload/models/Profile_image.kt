package com.pinterestimageload.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Profile_image(

    val small: String,
    val medium: String,
    val large: String
) : Parcelable