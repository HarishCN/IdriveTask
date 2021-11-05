package com.pinterestimageload.interfaces

import com.pinterestimageload.models.ResponseModel


interface ItemClickListner {
    fun onItemClickListener(responseModel: ResponseModel)
}