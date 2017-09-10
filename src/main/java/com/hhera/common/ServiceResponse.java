package com.hhera.common;

import com.sun.net.httpserver.Authenticator;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: shieldofzues
 * Date: 2017/9/5
 * Time: 下午9:31
 * To change this template use File | Settings | File Templates.
 */
//不要为空 不需要data的时候 不显示 很管用的注解
//保证序列化json的时候，如果是null的对象，key也会消失
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ServiceResponse<T> implements Serializable {
    private int status;
    private String msg;
    //用范型的好处是不用指定返回类型，提高通用性
    private T data;

    //私有构造方法，然后外放出public调用的方法
    private ServiceResponse(int status) {
        this.status = status;
    }

    private ServiceResponse(int status, T data) {
        this.status = status;
        this.data = data;
    }

    private ServiceResponse(int status, T data, String msg) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    private ServiceResponse(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }
//之前报错没有 新家的
    private ServiceResponse(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }
//加一个JsonIngore注解 序列化后不会显示在json里
    @JsonIgnore
    public boolean isSuccess() {
        return this.status == ResponesCode.SUCCESS.getCode();
    }

    public int getStatus() {
        return status;
    }

    public T getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }
//下边的需要用静态的外方出去 构造器 调用我会返回status 成功的时候
    public static <T> ServiceResponse<T> createBySuccess(){
        return new ServiceResponse<T>(ResponesCode.SUCCESS.getCode());

    }
    //返回数据给前端
    public static <T> ServiceResponse<T> createBySuccessMessage(String msg){
        return new ServiceResponse<T>(ResponesCode.SUCCESS.getCode(),msg);

    }
    public static <T> ServiceResponse<T> createBySuccess(T data){
        return new ServiceResponse<T>(ResponesCode.SUCCESS.getCode(),data);

    }
    //消息和数据都穿过去 调用构造器
    public static <T> ServiceResponse<T> createBySuccess(String msg,T data){
        return new ServiceResponse<T>(ResponesCode.SUCCESS.getCode(),msg,data);

    }

//失败的话 返回的结果
    public static  <T>ServiceResponse<T> createByError(){
        return new ServiceResponse<T>(ResponesCode.ERROR.getCode(),ResponesCode.ERROR.getDesc());
    }
    //提示用户名错误的调用的
    public static  <T>ServiceResponse<T> createByErrorMessage(String errorMessage){
        return new ServiceResponse<T>(ResponesCode.ERROR.getCode(),errorMessage);
    }
//服务端错误调用
    public static  <T>ServiceResponse<T> createByErrorCodeMessage(int errorCode,String errorMessage){
        return new ServiceResponse<T>(errorCode,errorMessage);
    }








}
