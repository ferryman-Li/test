package org.qnit.common.bean;

/**
 * 返回码枚举
 */
public enum ResultCode {

    // 请求成功
    SUCCESS(200, "success"),

    TRIGGER_WILL_NEVER_FIRE(202, "定时任务将不会被执行"),

    //没有权限
    HAVE_NO_PERMISSION(403, "You don't have permission to access this website!"),

    //可以申请权限
    NEEDED_APPLICATION_PERMISSION(402, "需要申请权限!"),

    //自定义异常
    Native(302, "Custom Exception"),

    //服务器内部错误
    INTERNAL_SERVER_ERROR(500, "服务器内部异常"),

    //主键参数校验异常
    NO_ID_FOUND(500, "主键参数校验异常"),

    //参数传入异常
    NO_PARAMETER_FOUND(500, "参数传入异常"),

    //用户不存在
    NO_USER(303, "用户不存在"),

    //用户密码错误
    NO_PASSWORD(304, "密码错误");

    private int code;
    private String msg;
    private Object data;

    ResultCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return code + " : " + msg;
    }

}
