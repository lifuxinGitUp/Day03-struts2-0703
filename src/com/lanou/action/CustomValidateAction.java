package com.lanou.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.validation.SkipValidation;


/**
 * Created by dllo on 17/10/12.
 */
public class CustomValidateAction extends ActionSupport {

    private String username;
    private String password;


    public String login() {
        System.out.println("进入了登录方法");
        return SUCCESS;
    }

    public String register(){
        System.out.println("注册验证");
        return SUCCESS;
    }
    /**
     * 针对某个特有的方法进行输入验证
     * 规则是: public void validate方法名();
     * 其中方法名的首字母大写
     **/
    public void validateRegister(){
        if (StringUtils.isBlank(username)){
            addActionError("用户名不能为空");
        }
    }


    //    默认情况下覆写了validate方法之后, 该动作类的所有动作方法访问时都会先进validate
    //    验证方法, 如果某个方法向跳过验证,则在方法前加@SkipValidation的注解
    @SkipValidation
    public String findAll() {
        System.out.println("进入了findAll方法");
        return SUCCESS;
    }


    /**
     * 输入验证方法, 在动作执行前执行
     */
    @Override
    public void validate() {
        System.out.println("进入了验证方法");
//          定义自己的输入验证规则
        if (StringUtils.isBlank(username)) {
//          输入空白则加入输入验证失败的错误信息
            addFieldError("username_error", "用户名不能为空");
        }
        if (StringUtils.isBlank(password)) {
            addFieldError("password_error", "密码不能为空");
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
