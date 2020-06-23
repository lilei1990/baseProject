package com.example.lilei.impl

import android.app.Application
import android.content.Context

/**
 * 作者 : LiLei
 * 时间 : 2020/06/23.
 * 邮箱 :416587959@qq.com
 * 描述 :BaseApplication
 */
class BaseApplication : Application(), App {
    private var mAppDelegate: AppLifecycles? = null

    /**
     * 这里会在 [BaseApplication.onCreate] 之前被调用,可以做一些较早的初始化
     * 常用于 MultiDex 以及插件化框架的初始化
     *
     * @param base
     */
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        if (mAppDelegate == null) {
            mAppDelegate = AppDelegate(base)
        }
        mAppDelegate!!.attachBaseContext(base!!)
    }

    override fun onCreate() {
        super.onCreate()
        if (mAppDelegate != null) {
            mAppDelegate!!.onCreate(this)
        }
    }

    /**
     * 在模拟环境中程序终止时会被调用
     */
    override fun onTerminate() {
        super.onTerminate()
        if (mAppDelegate != null) {
            mAppDelegate!!.onTerminate(this)
        }
    }
    /**
     * 将 {@link AppComponent} 返回出去, 供其它地方使用, {@link AppComponent} 接口中声明的方法所返回的实例, 在 {@link #getAppComponent()} 拿到对象后都可以直接使用
     *
     * @return AppComponent
     * @see ArmsUtils#obtainAppComponentFromContext(Context) 可直接获取 {@link AppComponent}
     */
    override fun getAppComponent(): AppComponent? {
        TODO("Not yet implemented")
    }

}