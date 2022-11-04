package com.resurrection.app.ui.main

import android.os.Bundle
import android.view.View
import coil.loadAny
import com.resurrection.app.R
import com.resurrection.app.databinding.ActivityMainBinding
import com.resurrection.base.core.activity.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(
    R.layout.activity_main, MainViewModel::class.java
) {

    private var lastShowedDogImageUrl = ""

    override fun init(savedInstanceState: Bundle?) {

        viewModel.getDog()

        viewModel.dog.observeData(
            success = {
                binding.imageView.visibility = View.VISIBLE
                binding.textView.visibility = View.GONE
                binding.imageView.loadAny(it?.message)
                lastShowedDogImageUrl = it?.message.toString()
            }, error = {
                binding.imageView.visibility = View.GONE
                binding.textView.visibility = View.VISIBLE
                binding.textView.text = "Error"
            }
        )

    }

    override fun onBackPressed() {
        viewModel.cancelDogJob()
        alertDialogManager.show {
            it.setTitle("Çıkmak istediğinize eminisiniz?")
            it.setPositiveButton("Tamam") { p0, p1 ->
                viewModel.saveLastShownDog(lastShowedDogImageUrl)
                super.onBackPressed()
            }
            it.setNegativeButton("İptal") { p0,p1->
                viewModel.getDog()
            }
        }


    }

}