package com.community.entity;

/**
 * Created by yyc on 2020/2/18.
 */
/**
* @Description: 统一json响应类
* @Param:
* @Return:
* @Author: yyc
*/
public class Result<T> {
    private T data;

    private String message;

    private String code;

    private boolean token;

    public Result() {
    }

    public Result(T data, String message, String code) {
        this.data = data;
        this.message = message;
        this.code = code;
    }

    public Result(T data, String message, boolean token) {
        this.data = data;
        this.message = message;
        this.token = token;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isToken() {
        return token;
    }

    public void setToken(boolean token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Result{" +
                "data=" + data +
                ", message='" + message + '\'' +
                ", code='" + code + '\'' +
                ", token=" + token +
                '}';
    }
}
