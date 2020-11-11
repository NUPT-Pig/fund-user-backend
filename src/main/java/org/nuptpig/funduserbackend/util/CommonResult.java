package org.nuptpig.funduserbackend.util;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Data
public class CommonResult<T> {
    private long code;
    private String message;
    private T data;

    private CommonResult(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    static <T> CommonResult<T> success(T data){
        return new CommonResult<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    static <T> CommonResult<T> success(T data, ResultCode resultCode){
        return new CommonResult<>(resultCode.getCode(), resultCode.getMessage(), data);
    }

    static <T> CommonResult<T> fail(T data){
        return new CommonResult<>(ResultCode.FAIL.getCode(), ResultCode.FAIL.getMessage(), data);
    }

    static <T> CommonResult<T> fail(T data, ResultCode resultCode){
        return new CommonResult<>(resultCode.getCode(), resultCode.getMessage(), data);
    }
}
