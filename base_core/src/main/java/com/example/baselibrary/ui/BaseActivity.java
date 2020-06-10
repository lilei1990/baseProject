package com.example.baselibrary.ui;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.example.baselibrary.ViewManager;


/**
 * 作者 : LiLei
 * 时间 : 2020/06/01.
 * 邮箱 :416587959@qq.com
 * 描述 :
 */

public abstract class BaseActivity extends AppCompatActivity {
    /** 是否沉浸状态栏 **/
    private boolean isSetStatusBar = false;
    /** 是否允许全屏 **/
    private boolean mAllowFullScreen = true;
    /** 是否禁止旋转屏幕 **/
    private boolean isAllowScreenRoate = false;

    /**
     * 日志输出标志
     **/



    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //管理类
        ViewManager.getInstance().addActivity(this);
        //是否全屏
        if (mAllowFullScreen) {
            requestWindowFeature(Window.FEATURE_NO_TITLE);
        }
        //是否沉浸状态栏
        if (isSetStatusBar) {
            steepStatusBar();
        }

        //是否禁止旋转屏幕
        if (!isAllowScreenRoate) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
        ViewDataBinding viewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
        initView(viewDataBinding);
        initData();

    }

    /**
     * [沉浸状态栏]
     */
    private void steepStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // 透明状态栏
            getWindow().addFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // 透明导航栏
            getWindow().addFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }




    /**
     * [绑定布局]
     *
     * @return
     */
    public abstract int getLayoutId();

    /**
     * [初始化控件]
     *
     * @param view
     */
    public abstract void initView( ViewDataBinding view);
    /**
     * [初始化数据]
     *
     */
    public abstract void initData();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ViewManager.getInstance().finishActivity(this);
    }


}
