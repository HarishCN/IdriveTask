package com.pinterestimageload.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Categories(
    val id: Int, val title: String, val photo_count: Int, val links: Links
) : Parcelable