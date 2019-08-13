package com.oaec.cms.exception;


import com.oaec.cms.util.ExceptionCode;

public class HelloException extends RuntimeException{

    private int code;

    public HelloException(int code, String msg){
        super(msg);
        this.code = code;
    }
    public HelloException(ExceptionCode exceptionCode){
        super(exceptionCode.getMsg());
        this.code = exceptionCode.getCode();
    }
    public int getCode() {
        return code;
    }
}
