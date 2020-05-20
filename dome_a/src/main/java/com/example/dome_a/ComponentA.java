package com.example.dome_a;

import com.billy.cc.core.component.CC;
import com.billy.cc.core.component.CCResult;
import com.billy.cc.core.component.CCUtil;
import com.billy.cc.core.component.IComponent;

/**
 * 作者 : LiLei
 * 时间 : 2020/05/20.
 * 邮箱 :416587959@qq.com
 * 描述 :
 */
public class ComponentA implements IComponent {
    @Override
    public String getName() {
        //指定组件的名称
        return "ComponentA";
    }
    @Override
    public boolean onCall(CC cc) {
        String actionName = cc.getActionName();
        switch (actionName) {
            case "showActivity": //响应actionName为"showActivity"的组件调用
                //跳转到页面：ActivityA
                CCUtil.navigateTo(cc, Dome_A_Activity.class);
                //返回处理结果给调用方
                CC.sendCCResult(cc.getCallId(), CCResult.success());
                //同步方式实现（在return之前听过CC.sendCCResult()返回组件调用结果），return false
                return false;
            default:
                //其它actionName当前组件暂时不能响应，可以通过如下方式返回状态码为-12的CCResult给调用方
                CC.sendCCResult(cc.getCallId(), CCResult.errorUnsupportedActionName());
                return false;
        }
    }
}