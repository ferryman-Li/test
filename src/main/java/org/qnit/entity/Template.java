package org.qnit.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author zhuxianyu
 * @since 2020-10-08
 */
@Data
@TableName("template")
public class Template implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 模板名
     */
    @TableField("template_name")
    private String templateName;

    /**
     * 模板内容
     */
    private String content;

    /**
     * 备注
     */
    private String remarks;


}
