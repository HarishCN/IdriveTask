package com.pinterestimageload.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.imageloader.ImageLoader
import com.pinterestimageload.R
import com.pinterestimageload.util.Constant
import com.pinterestimageload.databinding.ActivityImageDetailsBinding


class ImageDetails : AppCompatActivity() {
    private lateinit var binding: ActivityImageDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val actionBar: ActionBar? = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.title ="Image Details"
        initRecyclerview()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initRecyclerview() {
        intent?.let {
            ImageLoader.with(this).load(binding.ivFullView, intent.getStringExtra(Constant.IMAGE_URL)!!)
            binding.tvTitle.text = intent.getStringExtra(Constant.USER_NAME)
            binding.tvLikes.text = intent.getIntExtra("likes",1).toString()
            if (intent.getBooleanExtra(Constant.LIKES_BY_USER, false)) {
                binding.tvLikes.setCompoundDrawablesWithIntrinsicBounds(
                    R.drawable.favourite,
                    0,
                    0,
                    0
                )
            } else {
                binding.tvLikes.setCompoundDrawablesWithIntrinsicBounds(
                    R.drawable.un_favoutite,
                    0,
                    0,
                    0
                )
            }
        }
    }
}