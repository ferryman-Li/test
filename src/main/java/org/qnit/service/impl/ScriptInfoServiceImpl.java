package org.qnit.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.qnit.common.exception.NativeException;
import org.qnit.common.util.UUIDUtils;
import org.qnit.entity.ScriptInfo;
import org.qnit.entity.Template;
import org.qnit.mapper.ScriptInfoMapper;
import org.qnit.service.ScriptInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhuxianyu
 * @since 2020-10-07
 */
@Service
@Transactional
public class ScriptInfoServiceImpl extends ServiceImpl<ScriptInfoMapper, ScriptInfo> implements ScriptInfoService {

    @Autowired
    private ScriptInfoMapper scriptInfoMapper;

    @Override
    public ScriptInfo echo(String id) {
        return this.selectOne((new EntityWrapper<ScriptInfo>()
                .eq("id", id)));
    }

    @Override
    public List<ScriptInfo> findAll() {
        EntityWrapper<ScriptInfo> wrapper = new EntityWrapper<>();
        List<ScriptInfo> list = this.selectList(wrapper);
        return list;
    }

    @Override
    public void add(String moduleName, String scriptName, String path, int status, String remarks) {
        ScriptInfo scriptInfo = new ScriptInfo();
        scriptInfo.setId(UUIDUtils.getUuid());
        scriptInfo.setModuleName(moduleName);
        scriptInfo.setScriptName(scriptName);
        scriptInfo.setPath(path);
        scriptInfo.setCreateTime(new Date());
        scriptInfo.setStatus(status);
        scriptInfo.setRemarks(remarks);
        scriptInfoMapper.insert(scriptInfo);
    }

    @Override
    public void update(String id, String scriptName, String path, int status) {
        ScriptInfo scriptInfo = echo(id);
        if (scriptInfo == null)
            throw new NativeException("更新失败，该脚本id不存在");
        scriptInfo.setScriptName(scriptName);
        scriptInfo.setPath(path);
        scriptInfo.setModifyTime(new Date());
        scriptInfo.setStatus(status);
        this.updateById(scriptInfo);
    }

    @Override
    public ScriptInfo findByScriptInfoName(String scriptName) {
        EntityWrapper<ScriptInfo> wrapper = new EntityWrapper<>();
        wrapper.eq("script_name", scriptName);
        return this.selectOne(wrapper);
    }

    @Override
    public void delete(String id) {
        if (echo(id) == null)
            throw new NativeException("删除失败，该集群id不存在");
        scriptInfoMapper.deleteById(id);
    }

}
