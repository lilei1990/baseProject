package com.example.on_the_way

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ValueAnimator
import androidx.databinding.ViewDataBinding
import com.blankj.utilcode.util.ActivityUtils
import com.example.baselibrary.ui.BaseActivity
import com.lilei.on_the_way.R

class SplashActivity : BaseActivity() {
    /**
     * 动画时长
     */
    private val DURATION: Long = 800
    private var mAnimator: ValueAnimator? = null
    override fun initData() {
    }

    override fun getLayoutId(): Int {
       return R.layout.activity_splash
    }

    override fun initView(view: ViewDataBinding?) {

        // 没有需要重新授予权限,直接进入主页
        initAnimator()
    }

    private fun initAnimator() {
        mAnimator = ValueAnimator.ofFloat(0f, 80f)
        mAnimator?.setDuration(DURATION)
        mAnimator?.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationStart(animation: Animator) {}

            /**
             * 动画结束,进入主页MapActivity
             *
             * @param animation
             */
            override fun onAnimationEnd(animation: Animator) {
                ActivityUtils.startActivity(OnTheWayMainActivity::class.java)
            }
        })
        mAnimator?.start()
    }
}
