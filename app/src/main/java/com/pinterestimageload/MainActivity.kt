package com.pinterestimageload

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.pinterestimageload.UI.ImageDetails
import com.pinterestimageload.Util.ApiState
import com.pinterestimageload.ViewModel.MainViewModel
import com.pinterestimageload.adapters.ImagePostAdapter
import com.pinterestimageload.databinding.ActivityMainBinding
import com.pinterestimageload.interfaces.ItemClickListner
import com.pinterestimageload.models.Post
import com.pinterestimageload.models.ResponseModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class MainActivity : AppCompatActivity(),ItemClickListner, SwipeRefreshLayout.OnRefreshListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var postAdapter: ImagePostAdapter
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerview()

        mainViewModel.getPostImage()

        lifecycleScope.launchWhenStarted {
            mainViewModel._postStateFlow.collect {it->
                when(it){
                    is ApiState.Loading->{
                        binding.recyclerview.isVisible=false
                        binding.progressBar.isVisible=true
                    }
                    is ApiState.Failure -> {
                        binding.recyclerview.isVisible = false
                        binding.progressBar.isVisible = false
                        //Log.d("main", "onCreate: ${it.msg}")
                    }
                    is ApiState.Success->{
                        binding.recyclerview.isVisible = true
                        binding.progressBar.isVisible = false
                        postAdapter.setData(it.data)
                        postAdapter.notifyDataSetChanged()
                        if (binding.swiperefresh.isRefreshing() == true) binding.swiperefresh.setRefreshing(false)
                        binding.swiperefresh.setEnabled(true)
                    }
                    is ApiState.Empty->{

                    }
                }
            }
        }

    }

    private fun initRecyclerview() {
        binding.swiperefresh.setOnRefreshListener(this)
        binding.swiperefresh.setEnabled(false)
        postAdapter= ImagePostAdapter(ArrayList(),this,this)
        binding.recyclerview.apply {
            setHasFixedSize(true)
            layoutManager=LinearLayoutManager(this@MainActivity)
            adapter=postAdapter
        }
    }

    override fun onItemClickListener(responseModel: ResponseModel) {
        val intent = Intent(this, ImageDetails::class.java).apply {
            putExtra("imageUrl", responseModel.urls.thumb)
            putExtra("userName", responseModel.user.name)
            putExtra("likes", responseModel.likes)
            putExtra("likesByUser", responseModel.liked_by_user)
        }
        startActivity(intent)
    }

    override fun onRefresh() {
        mainViewModel.getPostImage()
    }
}