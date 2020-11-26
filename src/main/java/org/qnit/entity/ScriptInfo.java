package org.qnit.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhuxianyu
 * @since 2020-10-07
 */
@Data
@TableName("script_info")
public class ScriptInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 所属模块
     */
    @TableField("module_name")
    private String moduleName;

    /**
     * 脚本名
     */
    @TableField("script_name")
    private String scriptName;

    /**
     * 路径
     */
    private String path;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 修改时间（最后一次）
     */
    @TableField("modify_time")
    private Date modifyTime;

    /**
     * 状态：0-禁用，1-可用
     */
    private Integer status;

    /**
     * 备注
     */
    private String remarks;


}
