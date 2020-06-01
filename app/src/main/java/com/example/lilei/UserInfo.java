package com.example.lilei;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;

/**
 * 作者 : LiLei
 * 时间 : 2020/06/01.
 * 邮箱 :416587959@qq.com
 * 描述 :
 */
public class UserInfo extends BaseObservable {
    // 被观察的属性（切记：必须是public修饰符，因为是DataBinding的规范）
    public String name;
    public String pwd;

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "name=" + name +
                ", pwd=" + pwd +
                '}';
    }
}
