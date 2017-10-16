package com.lanou.util;

import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.validators.FieldValidatorSupport;

/**
 * Created by dllo on 17/10/12.
 */
public class IDCardVaildator extends FieldValidatorSupport {


    private String regexExpression;

    /**
     * 自定义验证类型,即扩展原来struts支持的几种常见的验证类型,仿照RequiredStringValidator的实现方式
     */
//    由大小写字母和数字组成的正则表达式
//    [0-9]*(([a-zA-Z]+[0-9]+)|([0-9]+[a-zA-Z]+))+[a-zA-Z]*

    @Override
    public void validate(Object o) throws ValidationException {
        String fileName = getFieldName(); // 获得要验证的属性名称

        // 根据属性名称获得该属性对应的值
        String value = (String) getFieldValue(fileName,o);

        System.out.println("属性值: " + value);

        IDCard idCard = new IDCard();
        boolean result = idCard.Verify(value); // 调用身份证号码验证
        if (!result){
            addFieldError(fileName,o);
        }

    }

    public void setRegexExpression(String regexExpression) {
        this.regexExpression = regexExpression;
    }

    public String getRegexExpression() {
        return regexExpression;
    }
}
