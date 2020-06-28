package com.example.baselibrary.ui;

import android.os.Bundle;
import android.view.Window;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.Utils;


/**
 * 作者 : LiLei
 * 时间 : 2020/06/01.
 * 邮箱 :416587959@qq.com
 * 描述 :
 */

public abstract class CoreActivity extends AppCompatActivity implements IBaseView{
    private ViewDataBinding viewDataBinding;//数据绑定
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Android 状态栏(status bar), 标题栏(action bar, toolbar), 导航栏 (navigation bar)，系统栏 (system bar): 等于状态栏 + 导航栏 ，应用栏(app bar)：应用栏也称操作栏一般是把标题栏(Toolbar) 设置为应用栏
        //设置无标题,标题自定义
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (getSupportActionBar() != null)
            getSupportActionBar().hide();
        if (getActionBar() != null)
            getActionBar().hide();
        //初始化DataBinding
        viewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
        ActivityUtils.addActivityLifecycleCallbacks(this, new Utils.ActivityLifecycleCallbacks());
        init(savedInstanceState);
        //初始化TitleBar初始化LoadingDialog
        initTitleBarLoadingDialog();
    }


}
