package org.qnit.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhuxianyu
 * @since 2020-10-06
 */
@Configuration
@Data
@TableName("cluster_master")
public class ClusterMaster implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 集群名称
     */
    @TableField("cluster_name")
    private String clusterName;

    /**
     * 管理节点IP
     */
    @TableField("master_ip")
    private String masterIp;

    /**
     * 用户名
     */
    @TableField("user_name")
    private String userName;

    /**
     * 密码
     */
    @TableField("user_pwd")
    private String userPwd;

}
