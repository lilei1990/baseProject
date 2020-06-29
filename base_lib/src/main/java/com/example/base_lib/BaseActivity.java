package com.example.base_lib;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.databinding.ViewDataBinding;

import com.dylanc.loadinghelper.LoadingHelper;
import com.dylanc.loadinghelper.ViewType;
import com.example.baselibrary.ui.CoreActivity;

/**
 * 作者 : LiLei
 * 时间 : 2020/06/27.
 * 邮箱 :416587959@qq.com
 * 描述 :BaseActivity
 */
public abstract class BaseActivity extends CoreActivity {
    private ViewDataBinding viewDataBinding;//数据绑定
    private RelativeLayout rlTitleBar;//标题栏
    private ImageView action_esc;//标题栏返回按钮
    private TextView action_title;//标题栏标题
    private ImageView action_more;//标题栏更多图标
    private TextView action_more_tv;//标题栏更多文字
    private LoadingHelper loadingHelper;


    /**
     * 初始化标题栏
     */
    @Override
    public void initTitleBarLoadingDialog() {
        loadingHelper = new LoadingHelper(this);
//        loadingHelper.register(ViewType.LOADING, new LoadingAdapter());
        loadingHelper.register(ViewType.TITLE, getTitleAdapter());
        loadingHelper.setDecorHeader(ViewType.TITLE);
//        loadingHelper.showLoadingView();
    }

    /**
     * 获取title布局填充
     *
     * @return
     */
    protected LoadingHelper.Adapter<?> getTitleAdapter() {
        return new TitleAdapter(this.getClass().getSimpleName(), this);
    }


    /**
     * 显示模态框
     */
    @Override
    public void showLoadingView() {
        loadingHelper.showLoadingView();
        ;
    }

    /**
     * 关闭模态框
     */
    @Override
    public void showContentView() {
        loadingHelper.showContentView();
    }
}
