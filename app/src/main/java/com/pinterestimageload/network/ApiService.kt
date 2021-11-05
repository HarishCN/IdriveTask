package com.pinterestimageload.network

import com.pinterestimageload.models.ResponseModel
import retrofit2.http.GET

interface ApiService {

    @GET("raw/wgkJgazE")
   suspend fun getPost():List<ResponseModel>
}