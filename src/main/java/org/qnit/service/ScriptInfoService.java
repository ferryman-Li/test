package org.qnit.service;

import com.baomidou.mybatisplus.service.IService;
import org.qnit.entity.ScriptInfo;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author zhuxianyu
 * @since 2020-10-07
 */
public interface ScriptInfoService extends IService<ScriptInfo> {
    ScriptInfo echo(String id);
    ScriptInfo findByScriptInfoName(String scriptName);
    List<ScriptInfo> findAll();
    void add(String moduleName, String scriptName, String path, int status, String remarks);
    void update(String id, String scriptName, String path, int status);
    void delete(String id);
}
