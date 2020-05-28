package com.example.dihomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.lifecycle.Observer
import com.example.dihomework.apiService.ApiService
import com.example.dihomework.apiService.XRepo
import com.example.dihomework.di.AdviceModule
import com.example.dihomework.di.DaggerAdviceComponent
import com.example.dihomework.model.AdviceViewModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: AdviceViewModel

    //private var repo = XRepo(AdviceModule().providesAdviceApiService())

    //private var viewModel = AdviceViewModel(repo)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DaggerAdviceComponent.create().inject(this)
        refresh.setOnClickListener {
            viewModel.load()
        }

        viewModel.result.observe(this, Observer {
            text_advice.text = it
        })
    }
}
