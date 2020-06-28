package com.example.lilei

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.lilei.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewDataBinding =
            DataBindingUtil.setContentView<ViewDataBinding>(this, R.layout.activity_main)
        val loginViewModel = LoginViewModel(viewDataBinding as ActivityMainBinding?)
        loginViewModel.userInfo.name="ssssss"
    }




}
