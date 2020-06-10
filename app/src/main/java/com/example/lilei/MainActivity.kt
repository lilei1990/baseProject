package com.example.lilei

import androidx.databinding.ViewDataBinding
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.baselibrary.ui.BaseActivity
import com.example.lilei.databinding.ActivityMainBinding

@Route(path = "/test/activity")
class MainActivity : BaseActivity() {
    override fun initData() {
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView(ViewDataBinding: ViewDataBinding?) {
        val loginViewModel = LoginViewModel(ViewDataBinding as ActivityMainBinding?)
        loginViewModel.userInfo.name="ssssss"

    }







}
