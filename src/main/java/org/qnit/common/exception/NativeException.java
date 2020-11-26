package org.qnit.common.exception;

import org.qnit.common.bean.ResultCode;

/**
 * 本地自定义异常
 */
public class NativeException extends RuntimeException {

    private ResultCode resultCode;

    public NativeException(ResultCode resultCode) {
        super(resultCode.getMsg());
        this.resultCode = resultCode;
    }

    public NativeException(String msg){
        super(msg);
        this.resultCode = ResultCode.Native;
        this.resultCode.setMsg(msg);
    }

    public NativeException(ResultCode resultCode, String msg) {
        super(msg);
        resultCode.setMsg(msg);
        this.resultCode = resultCode;
    }

    public NativeException(ResultCode resultCode, String msg, Object data) {
        super(msg);
        resultCode.setMsg(msg);
        resultCode.setData(data);
        this.resultCode = resultCode;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }

    public void setResultCode(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

}
