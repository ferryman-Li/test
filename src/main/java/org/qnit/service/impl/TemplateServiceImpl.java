package org.qnit.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.qnit.common.exception.NativeException;
import org.qnit.common.util.UUIDUtils;
import org.qnit.entity.ClusterMaster;
import org.qnit.entity.Template;
import org.qnit.mapper.TemplateMapper;
import org.qnit.service.TemplateService;
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
 * @since 2020-10-08
 */
@Service
@Transactional
public class TemplateServiceImpl extends ServiceImpl<TemplateMapper, Template> implements TemplateService {

    @Autowired
    private TemplateMapper templateMapper;

    @Override
    public Template echo(String id) {
        return this.selectOne((new EntityWrapper<Template>()
                .eq("id", id)));
    }

    @Override
    public List<Template> findAll() {
        EntityWrapper<Template> wrapper = new EntityWrapper<>();
        List<Template> list = this.selectList(wrapper);
        return list;
    }

    @Override
    public void add(String templateName, String content, String remarks) {
        Template template = new Template();
        template.setId(UUIDUtils.getUuid());
        template.setTemplateName(templateName);
        template.setContent(content);
        template.setRemarks(remarks);
        templateMapper.insert(template);
    }

    @Override
    public void update(String id, String templateName, String content, String remarks) {
        Template template = echo(id);
        if (template == null)
            throw new NativeException("更新失败，该模板id不存在");
        template.setTemplateName(templateName);
        template.setContent(content);
        template.setRemarks(remarks);
        this.updateById(template);
    }
    @Override
    public Template findByTemplateName(String templateName) {
        EntityWrapper<Template> wrapper = new EntityWrapper<>();
        wrapper.eq("template_name", templateName);
        return this.selectOne(wrapper);
    }

    @Override
    public void delete(String id) {
        if (echo(id) == null)
            throw new NativeException("删除失败，该集群id不存在");
        templateMapper.deleteById(id);
    }

}
