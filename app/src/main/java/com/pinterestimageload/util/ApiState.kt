package com.pinterestimageload.util

import com.pinterestimageload.models.ResponseModel


sealed class ApiState{
    object Loading : ApiState()
    class Failure(val msg:Throwable) : ApiState()
    class Success(val data:List<ResponseModel>) : ApiState()
    object Empty : ApiState()
}
