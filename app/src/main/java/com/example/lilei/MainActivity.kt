package com.example.lilei

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.billy.cc.core.component.CC
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //同步调用，直接返回结果
        //同步调用，直接返回结果
        bt.setOnClickListener {
            val result = CC.obtainBuilder("ComponentA").setActionName("showActivity").build().call()
        }
    }



}
