package org.qnit.common.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.qnit.common.bean.ResponseCode;

import java.io.Serializable;

/**
 * @author zhuxianyu
 * @version 2020/9/15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value = "请求结果响应体")
public class ResponseResult<T> implements Serializable {

    private static final long serialVersionUID = 8992436576262574064L;

    @ApiModelProperty(value = "响应状态回执码")
    private Integer status;

    @ApiModelProperty(value = "数据体")
    private T data;

    @ApiModelProperty(value = "响应回执消息")
    private String msg;

    @ApiModelProperty(value = "响应时间戳")
    private final long timestamps = System.currentTimeMillis();

    public synchronized static <T> ResponseResult<T> e(ResponseCode statusEnum) {
        return e(statusEnum,null);
    }

    public synchronized static <T> ResponseResult<T> e(ResponseCode statusEnum, T data) {
        ResponseResult<T> res = new ResponseResult<>();
        res.setStatus(statusEnum.code);
        res.setMsg(statusEnum.msg);
        res.setData(data);
        return res;
    }

}
