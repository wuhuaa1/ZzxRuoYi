package com.ruoyi.framework.web.exception;
/**
 * 自定义业务异常
 * @author shengwu ni
 */
public class BusinessErrorException extends RuntimeException {

    private static final long serialVersionUID = -7480022450501760611L;

    /**
     * 异常码
     */
    private int code;

    /**
     * 异常提示信息
     */
    private String message;

    public BusinessErrorException(BusinessMsgEnum businessMsgEnum) {
        this.code = businessMsgEnum.code();
        this.message = businessMsgEnum.msg();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}