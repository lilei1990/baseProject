package com.example.dome_a

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.billy.cc.core.component.CC
import kotlinx.android.synthetic.main.activity_dome__a_.*

class Dome_A_Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dome__a_)
        bt.setOnClickListener {
            val result = CC.obtainBuilder("ComponentB").setActionName("showActivity").build().call()
        }
    }
}
