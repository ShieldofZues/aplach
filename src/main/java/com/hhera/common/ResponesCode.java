package com.hhera.common;

/**
 * Created with IntelliJ IDEA.
 * User: zhanglirun
 * Date: 2017/9/10
 * Time: 下午8:33
 * To change this template use File | Settings | File Templates.
 */
public enum ResponesCode {
    //这是一个枚举类
    SUCCESS(0,"SUCCESS"),

    ERROR(1,"ERROR"),

    NEED_LOGIN(10,"NEED_LOGIN"),

    ILLEGAL_ARGUMENT(2,"ILLEGAL_ARGUMENT");
    //以后要扩展错误，继续往下编辑他就可以，想要什么错误就添加就OK

    private final int code;
    private final String desc;

    //类的构造器
    ResponesCode(int code, String desc) {
        this.code = code;
        this.desc = desc;

    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}

