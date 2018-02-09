package com.hongcheng.fruitmall.common.exception;

public class BizException extends RuntimeException {

    private static final int DEFAULT_ERROR_CODE = 26;

    private int code;

    public BizException(String msg) {
        super(msg);
        this.code = DEFAULT_ERROR_CODE;
    }

    public BizException(int code, String msg) {
        super(msg);
        this.code = code;
    }

    public BizException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public BizException(int code, Throwable cause) {
        super(cause);
        this.code = code;
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
        this.code = DEFAULT_ERROR_CODE;
    }

    public int getCode() {
        return this.code;
    }

}
