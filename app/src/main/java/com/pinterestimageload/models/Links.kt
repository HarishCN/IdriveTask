package com.pinterestimageload.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Links(

	val self: String,
	val html: String,
	val download: String
) : Parcelable