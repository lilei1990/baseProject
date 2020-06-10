package com.example.on_the_way

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import com.amap.api.maps.AMap
import com.amap.api.maps.model.MyLocationStyle
import com.example.baselibrary.ui.BaseActivity
import com.lilei.on_the_way.R
import kotlinx.android.synthetic.main.activity_on_the_way_main.*


class OnTheWayMainActivity : BaseActivity() {
    private var aMap: AMap? = null
    override fun initData() {



    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        aMap = mv_map.map
        mv_map.onCreate(savedInstanceState)
        var myLocationStyle =
            MyLocationStyle() //初始化定位蓝点样式类
        myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATION_ROTATE);//连续定位、且将视角移动到地图中心点，定位点依照设备方向旋转，并且会跟随设备移动。（1秒1次定位）如果不设置myLocationType，默认也会执行此种模式。
        myLocationStyle.interval(2000) //设置连续定位模式下的定位间隔，只在连续定位模式下生效，单次定位模式下不会生效。单位为毫秒。
        aMap?.myLocationStyle = myLocationStyle //设置定位蓝点的Style
//aMap.getUiSettings().setMyLocationButtonEnabled(true);设置默认定位按钮是否显示，非必需设置。
//aMap.getUiSettings().setMyLocationButtonEnabled(true);设置默认定位按钮是否显示，非必需设置。
        aMap?.isMyLocationEnabled = true // 设置为true表示启动显示定位蓝点，false表示隐藏定位蓝点并不进行定位，默认是false。
        aMap?.uiSettings?.isMyLocationButtonEnabled=true

        aMap?.setTrafficEnabled(true);// 显示实时交通状况
        //地图模式可选类型：MAP_TYPE_NORMAL,MAP_TYPE_SATELLITE,MAP_TYPE_NIGHT
        aMap?.setMapType(AMap.MAP_TYPE_SATELLITE);// 卫星地图模式
    }

    override fun getLayoutId(): Int {
        this.closeContextMenu()
        return R.layout.activity_on_the_way_main
    }

    override fun initView(view: ViewDataBinding?) {
    }

    override fun onResume() {
        super.onResume()
        mv_map.onResume();
    }

    override fun onDestroy() {
        super.onDestroy()
        mv_map.onDestroy();
    }

    override fun onPause() {
        super.onPause()
        mv_map.onResume();
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mv_map.onSaveInstanceState(outState);
    }

}
