package com.lanou.interceptor;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by dllo on 17/10/12.
 */
public class TestInterceptorAction extends ActionSupport{

    public String register(){
        System.out.println("进入了注册的方法");
        return SUCCESS;
    }

    public String login(){
        System.out.println("进入了登陆的方法");
        return SUCCESS;
    }

    @Override
    public String execute() throws Exception {

        System.out.println("进入了动作方法");

        return SUCCESS;
    }
}
