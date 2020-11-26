package org.qnit.service;

import com.baomidou.mybatisplus.service.IService;
import org.qnit.entity.Template;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhuxianyu
 * @since 2020-10-08
 */
public interface TemplateService extends IService<Template> {
    Template echo(String id);
    List<Template> findAll();
    Template findByTemplateName(String templateName);
    void add(String templateName, String content, String remarks);
    void update(String id, String templateName, String content, String remarks);
    void delete(String id);
}
