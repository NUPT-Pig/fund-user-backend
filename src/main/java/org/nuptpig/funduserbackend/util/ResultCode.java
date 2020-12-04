package org.nuptpig.funduserbackend.util;


public enum ResultCode {
    SUCCESS(200, "成功"),
    FAIL(400, "失败"),
    USEREXISTS(1001, "用户已存在");
    private long code;
    private String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public long getCode(){
        return this.code;
    }

    public String getMessage(){
        return this.message;
    }
}
