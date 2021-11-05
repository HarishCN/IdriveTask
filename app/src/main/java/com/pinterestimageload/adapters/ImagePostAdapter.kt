package com.pinterestimageload.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.imageloader.ImageLoader
import com.pinterestimageload.R
import com.pinterestimageload.databinding.EachRowBinding
import com.pinterestimageload.interfaces.ItemClickListner
import com.pinterestimageload.models.ResponseModel

class ImagePostAdapter(private var postList: List<ResponseModel>,
                       private val context: Context,
                       private val view: ItemClickListner)
    : RecyclerView.Adapter<ImagePostAdapter.PostViewHolder>() {
    private lateinit var binding: EachRowBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        binding = EachRowBinding.inflate(LayoutInflater.from(parent.context),
        parent,false)
        return PostViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        binding.tvUserName.text=postList[position].user.username
        if (postList[position].liked_by_user == true) {
            binding.tvLikes?.setCompoundDrawablesWithIntrinsicBounds(R.drawable.favourite, 0, 0, 0)
        } else {
            binding.tvLikes?.setCompoundDrawablesWithIntrinsicBounds(R.drawable.un_favoutite, 0, 0, 0)
        }
        ImageLoader.with(context).load(binding.ivImagethumbnail, postList[position].urls.thumb)
        holder.itemView.setOnClickListener {
            view.onItemClickListener(postList[position])
        }
    }

    override fun getItemCount(): Int = postList.size

    class PostViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){

    }

    fun setData(postList: List<ResponseModel>)
    {
        this.postList=postList
        notifyDataSetChanged()
    }

}