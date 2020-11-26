package org.qnit.service;

import com.baomidou.mybatisplus.service.IService;
import org.qnit.entity.ClusterMaster;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhuxianyu
 * @since 2020-10-06
 */
public interface ClusterMasterService extends IService<ClusterMaster> {
    ClusterMaster echo(String id);
    List<ClusterMaster> findAll();
    ClusterMaster findByClusterName(String clusterName);
    ClusterMaster findByMasterIp(String masterIp);
    void add(String clusterName, String masterIp, String userName, String userPwd);
    void update(String id, String clusterName, String masterIp, String userName, String userPwd);
    void delete(String id);
}
