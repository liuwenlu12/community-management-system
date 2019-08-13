package com.oaec.cms.util;

public enum ExceptionCode {
    INVALID_PASSWORD(101,"密码错误"),
    USERNAME_NOT_EXISTS(102,"用户名不存在"),
    USERNAME_ALREADY_EXISTS(103,"用户名已存在"),
    TEL_NUMBER_ALREADY_EXISTS(104,"电话号码已存在"),
    EMAIL_ALREADT_EXISTS(105,"邮箱已存在"),
    AREA_ALREADT_EXISTS(106,"区域已存在"),
    OLD_PASS_ERROR(107,"原密码输入错误");
    private int code;
    private String msg;

    ExceptionCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
