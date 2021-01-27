package com.example.demo.util;

public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;
    public CommonResult(){

    }

    public CommonResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    @Override
    public String toString() {
        return "CommonResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
    public CommonResult<T>success(T data){
        return new CommonResult<>(1,"操作成功",data);
    }
    public CommonResult<T> failed(String message){
        return new CommonResult<T>(0,message,null);
    }

}
