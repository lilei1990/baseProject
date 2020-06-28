package com.example.base_lib;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.dylanc.loadinghelper.LoadingHelper;

/**
 * 作者 : LiLei
 * 时间 : 2020/06/28.
 * 邮箱 :416587959@qq.com
 * 描述 :
 */
public class LoadingAdapter extends LoadingHelper.Adapter<LoadingHelper.ViewHolder> {

    @NonNull
    @Override
    public LoadingHelper.ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new LoadingHelper.ViewHolder(inflater.inflate(R.layout.layout_progress_dialog, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LoadingHelper.ViewHolder holder) {

    }
}