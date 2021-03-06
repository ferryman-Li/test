package org.qnit.common.exception;

import lombok.*;
import org.qnit.common.bean.ResponseCode;

import java.io.Serializable;

/**
 * @author zhuxianyu
 * @version 2020/9/15
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestException extends RuntimeException implements Serializable {
    private Integer status;
    private String msg;
    private Exception e;

    public RequestException(ResponseCode statusEnum, Exception e) {
        this.status = statusEnum.code;
        this.msg = statusEnum.msg;
        this.e = e;
    }

    public RequestException(ResponseCode statusEnum) {
        this.status = statusEnum.code;
        this.msg = statusEnum.msg;
    }

    public synchronized static RequestException fail(String msg) {
        return RequestException.builder()
                .status(ResponseCode.FAIL.code)
                .msg(msg)
                .build();
    }

    public synchronized static RequestException fail(String msg, Exception e) {
        return RequestException.builder()
                .status(ResponseCode.FAIL.code)
                .msg(msg)
                .e(e)
                .build();
    }

    public synchronized static RequestException fail(Integer code, String msg, Exception e) {
        return RequestException.builder()
                .status(code)
                .msg(msg)
                .e(e)
                .build();
    }

}
