package com.example.base_lib;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.Utils;
import com.dylanc.loadinghelper.LoadingHelper;
import com.dylanc.loadinghelper.ViewType;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/**
 * 作者 : LiLei
 * 时间 : 2020/06/27.
 * 邮箱 :416587959@qq.com
 * 描述 :BaseActivity
 */
public abstract class  BaseActivity extends AppCompatActivity implements BasePermissions {
    private ViewDataBinding viewDataBinding;//数据绑定
    private RelativeLayout rlTitleBar;//标题栏
    private ImageView action_esc;//标题栏返回按钮
    private TextView action_title;//标题栏标题
    private ImageView action_more;//标题栏更多图标
    private TextView action_more_tv;//标题栏更多文字
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Android 状态栏(status bar), 标题栏(action bar, toolbar), 导航栏 (navigation bar)，系统栏 (system bar): 等于状态栏 + 导航栏 ，应用栏(app bar)：应用栏也称操作栏一般是把标题栏(Toolbar) 设置为应用栏
        //设置无标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (getSupportActionBar() != null)
            getSupportActionBar().hide();
        if (getActionBar() != null)
            getActionBar().hide();
        //初始化DataBinding
        viewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
        ActivityUtils.addActivityLifecycleCallbacks(this,new Utils.ActivityLifecycleCallbacks());
        init(savedInstanceState);
        //初始化TitleBar初始化LoadingDialog
        initTitleBarLoadingDialog();
    }

    /**
     * 获取布局id
     * @return
     */
    public abstract int getLayoutId();

    /**
     * 初始化方法
     * @param savedInstanceState
     */
    public abstract void init(Bundle savedInstanceState);



    /**
     * 初始化标题栏
     */
    private void initTitleBarLoadingDialog() {
        LoadingHelper loadingHelper = new LoadingHelper(this);
        loadingHelper.register(ViewType.LOADING, new LoadingAdapter());
        loadingHelper.register(ViewType.TITLE, new TitleAdapter(this.getClass().getSimpleName(),this));
        loadingHelper.setDecorHeader(ViewType.TITLE);
        LoadingHelper.setDefaultAdapterPool(new Function1<LoadingHelper.AdapterPool, Unit>() {
            @Override
            public Unit invoke(LoadingHelper.AdapterPool adapterPool) {
                adapterPool.register(ViewType.LOADING, new LoadingAdapter());
                return Unit.INSTANCE;
            }
        });
        loadingHelper.showLoadingView();
    }

}
