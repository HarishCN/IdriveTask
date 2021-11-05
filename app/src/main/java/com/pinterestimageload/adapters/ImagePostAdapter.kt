package com.pinterestimageload.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.imageloader.ImageLoader
import com.pinterestimageload.R
import com.pinterestimageload.databinding.EachRowBinding
import com.pinterestimageload.interfaces.ItemClickListner
import com.pinterestimageload.models.ResponseModel

class ImagePostAdapter(
    private var postList: List<ResponseModel>,
    private val context: Context,
    private val view: ItemClickListner
) : RecyclerView.Adapter<ImagePostAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: EachRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = EachRowBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            binding.tvUserName.text = postList[position].user.username
            if (postList[position].liked_by_user == true) {
                binding.tvLikes?.setCompoundDrawablesWithIntrinsicBounds(
                    R.drawable.favourite,
                    0,
                    0,
                    0
                )
            } else {
                binding.tvLikes?.setCompoundDrawablesWithIntrinsicBounds(
                    R.drawable.un_favoutite,
                    0,
                    0,
                    0
                )
            }
            ImageLoader.with(context).load(binding.ivImagethumbnail, postList[position].urls.thumb)
            holder.itemView.setOnClickListener {
                view.onItemClickListener(postList[position])
            }
        }
    }

    override fun getItemCount(): Int = postList.size
    fun setData(postList: List<ResponseModel>) {
        this.postList = postList
        notifyDataSetChanged()
    }

}