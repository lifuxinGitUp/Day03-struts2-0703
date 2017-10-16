package com.lanou.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

/**
 * Created by dllo on 17/10/12.
 */
public class LoginInterceptor extends MethodFilterInterceptor {
    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {

        /*
        *  如果想指定拦截的动作方法则拦截器继承MethodFilterInterceptor
        *  该类有两个集合
        *  excludeMethods: 包含排除拦截的方法, 即那些方法不拦截
        *  includeMethods: 包含拦截的方法,指定那些方法进行拦截
        * */
        // 获取登录用户名
        String username = (String) ServletActionContext.getServletContext().getAttribute("user");
        // 如果没登录则返回到登录界面
        if (StringUtils.isBlank(username)){
            return "login";
        }
//        执行放行的动作
        return actionInvocation.invoke();
    }
}
