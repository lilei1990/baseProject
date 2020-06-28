package com.example.base_lib;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dylanc.loadinghelper.LoadingHelper;

import org.jetbrains.annotations.NotNull;

/**
 * 作者 : LiLei
 * 时间 : 2020/06/28.
 * 邮箱 :416587959@qq.com
 * 描述 :
 */
class TitleAdapter extends LoadingHelper.Adapter<LoadingHelper.ViewHolder> {

    private final BaseActivity baseActivity;
    private final String title;

    public TitleAdapter(String title, BaseActivity baseActivity) {
        this.baseActivity = baseActivity;
        this.title = title;

    }

    @Override
    public void onBindViewHolder(@NotNull LoadingHelper.ViewHolder viewHolder) {

    }

    @NotNull
    @Override
    public LoadingHelper.ViewHolder onCreateViewHolder(@NotNull LayoutInflater layoutInflater, @NotNull ViewGroup viewGroup) {
        View contentView = LayoutInflater.from(baseActivity).inflate(R.layout.common_title_bar, null);
        TextView action_title = contentView.findViewById(R.id.action_title);
        action_title.setText(title);
        return new LoadingHelper.ViewHolder(contentView);
    }
}
