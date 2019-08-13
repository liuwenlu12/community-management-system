package com.oaec.cms.controller;


import com.oaec.cms.exception.HelloException;
import com.oaec.cms.util.Result;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {
    /**
     * 101密码错误
     * 102用户名不存在
     * 103用户名已存在
     * 104电话号码已存在
     * @param e
     * @return
     */
    @ExceptionHandler
    @ResponseBody
    public Result exception(Exception e){
        if(e instanceof HelloException){
            HelloException helloException = (HelloException)e;
            int code = helloException.getCode();
            String message = helloException.getMessage();
            return new Result(code,message);
        }
        String message = e.getMessage();
        if(StringUtils.isEmpty(message)){
            message="未知错误";
        }

        return new Result(-1,message);
    }


}
