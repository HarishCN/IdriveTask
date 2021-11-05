package com.pinterestimageload.network

import com.pinterestimageload.models.ResponseModel
import javax.inject.Inject

class ApiServiceImpl @Inject constructor(private val apiService: ApiService) {

    suspend fun getPost():List<ResponseModel> = apiService.getPost()
}