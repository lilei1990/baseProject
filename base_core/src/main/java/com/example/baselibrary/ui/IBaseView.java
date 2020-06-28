package com.example.baselibrary.ui;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


public interface IBaseView {

    int getLayoutId();

    void init(Bundle savedInstanceState);

    void initTitleBarLoadingDialog();

    void showLoadingView();

    void showContentView();

}
