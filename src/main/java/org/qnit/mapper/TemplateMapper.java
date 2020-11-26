package org.qnit.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.qnit.entity.Template;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhuxianyu
 * @since 2020-10-08
 */
@Mapper
@Repository
public interface TemplateMapper extends BaseMapper<Template> {

}
