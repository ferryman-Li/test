package org.qnit.common.dto;

import lombok.Data;

/**
 * @author zhuxianyu
 * @version 2020/9/15
 */
@Data
public abstract class SplitPageDTO {

    private Integer page = 1;

    private Integer pageSize = 10;

    private Boolean asc = false;

}
