package com.example.lilei;

import android.os.SystemClock;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;

import com.example.lilei.UserInfo;
import com.example.lilei.databinding.ActivityMainBinding;

public class LoginViewModel {
    public UserInfo userInfo;
    public LoginViewModel(ActivityMainBinding binding) {
        userInfo = new UserInfo();
        // 将ViewModel和View进行绑定，通过DataBinding工具
        binding.setLoginViewModel(this);
    }
    public TextWatcher nameInputListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            // View层接收到用户的输入，改变Model层的javabean属性
            userInfo.setName(String.valueOf(s));
        }
        @Override
        public void afterTextChanged(Editable s) {
        }
    };

    public TextWatcher pwdInputListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            // View层接收到用户的输入，改变Model层的javabean属性
            userInfo.pwd=(String.valueOf(s));
        }
        @Override
        public void afterTextChanged(Editable s) {
        }
    };

    public View.OnClickListener loginClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // 模拟网络请求
            new Thread(new Runnable() {
                @Override
                public void run() {
                    // Model层属性的变更，改变View层的显示
                    //userInfo.name.set("yesterday");

                    Log.e("TAG", userInfo.toString());
                    SystemClock.sleep(2000);
//                    if ("migill".equals(userInfo.name.get()) && "123".equals(userInfo.pwd.get())) {
//                        Log.e("TAG", "登录成功!");
//                    } else {
//                        Log.e("TAG", "登录失败!");
//                    }
                }
            }).start();
        }
    };
}