package com.ruoyi.framework.web.exception;


public enum BusinessMsgEnum {
    /**
     * 参数异常
     */
    PARMETER_EXCEPTION(100, "参数异常!"),
    /**
     * 等待超时
     */
    SERVICE_TIME_OUT(103, "服务调用超时！"),
    /**
     * 参数过大
     */
    PARMETER_BIG_EXCEPTION(102, "输入的图片数量不能超过50张!"),
    /**
     * 500 : 发生异常
     */
    UNEXPECTED_EXCEPTION(500, "系统发生异常，请联系管理员！");
    /**
     * 消息码
     */
    private int code;
    /**
     * 消息内容
     */
    private String msg;

    private BusinessMsgEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int code() {
        return code;
    }

    public String msg() {
        return msg;
    }
}