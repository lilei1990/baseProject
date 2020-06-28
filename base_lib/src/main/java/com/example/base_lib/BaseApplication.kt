package com.example.base_lib

import com.dylanc.loadinghelper.LoadingHelper
import com.dylanc.loadinghelper.ViewType
import com.example.baselibrary.CoreApplication

/**
 * 作者 : LiLei
 * 时间 : 2020/06/23.
 * 邮箱 :416587959@qq.com
 * 描述 :BaseApplication
 */
class BaseApplication : CoreApplication(){

    override fun onCreate() {
        super.onCreate()
        LoadingHelper.setDefaultAdapterPool {
            this.register(ViewType.LOADING, LoadingAdapter())
        }
    }

}