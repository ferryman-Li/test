package org.qnit.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.qnit.common.exception.NativeException;
import org.qnit.common.util.UUIDUtils;
import org.qnit.entity.ClusterMaster;
import org.qnit.mapper.ClusterMasterMapper;
import org.qnit.service.ClusterMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zhuxianyu
 * @since 2020-10-06
 */
@Service
@Transactional
public class ClusterMasterServiceImpl extends ServiceImpl<ClusterMasterMapper, ClusterMaster> implements ClusterMasterService {

    @Autowired
    private ClusterMasterMapper clusterMasterMapper;

    @Override
    public ClusterMaster echo(String id) {
        return this.selectOne((new EntityWrapper<ClusterMaster>()
                .eq("id", id)));
    }

    @Override
    public List<ClusterMaster> findAll() {
        EntityWrapper<ClusterMaster> wrapper = new EntityWrapper<>();
        List<ClusterMaster> list = this.selectList(wrapper);
        return list;
    }

    @Override
    public ClusterMaster findByClusterName(String clusterName) {
        EntityWrapper<ClusterMaster> wrapper = new EntityWrapper<>();
        wrapper.eq("cluster_name", clusterName);
        return this.selectOne(wrapper);
    }

    @Override
    public ClusterMaster findByMasterIp(String masterIp) {
        ClusterMaster clusterMaster = new ClusterMaster();
        clusterMaster.setMasterIp(masterIp);
        return clusterMasterMapper.selectOne(clusterMaster);
    }

    @Override
    public void add(String clusterName, String masterIp, String userName, String userPwd) {
        ClusterMaster clusterMaster = new ClusterMaster();
        clusterMaster.setId(UUIDUtils.getUuid());
        clusterMaster.setClusterName(clusterName);
        clusterMaster.setMasterIp(masterIp);
        clusterMaster.setUserName(userName);
        clusterMaster.setUserPwd(userPwd);
        clusterMasterMapper.insert(clusterMaster);
    }

    @Override
    public void update(String id, String clusterName, String masterIp, String userName, String userPwd) {
        ClusterMaster clusterMaster = echo(id);
        if (clusterMaster == null) {
            throw new NativeException("更新失败，该集群id不存在");
        }
        clusterMaster.setClusterName(clusterName);
        clusterMaster.setMasterIp(masterIp);
        clusterMaster.setUserName(userName);
        clusterMaster.setUserPwd(userPwd);
        this.updateById(clusterMaster);
    }

    @Override
    public void delete(String id) {
        if (echo(id) == null)
            throw new NativeException("删除失败，该集群id不存在");
        clusterMasterMapper.deleteById(id);
    }

}
