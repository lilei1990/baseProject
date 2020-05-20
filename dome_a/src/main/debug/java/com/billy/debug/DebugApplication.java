package java.com.billy.debug;

import android.app.Application;

import com.billy.cc.core.component.BuildConfig;
import com.billy.cc.core.component.CC;

/**
 * 作者 : LiLei
 * 时间 : 2020/05/20.
 * 邮箱 :416587959@qq.com
 * 描述 :
 */
public class DebugApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CC.enableDebug(BuildConfig.DEBUG);
        CC.enableVerboseLog(BuildConfig.DEBUG);
        CC.enableRemoteCC(BuildConfig.DEBUG);
    }
}