package org.qnit.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.qnit.common.bean.ResponseCode;
import org.qnit.common.response.ResponseResult;
import org.qnit.entity.Template;
import org.qnit.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zhuxianyu
 * @since 2020-10-08
 */
@RestController
@RequestMapping("/template")
@Api(tags = {"应用模板管理"})
public class TemplateController {

    @Autowired
    private TemplateService templateService;

    @PostMapping(value = {"/findall"})
    @ApiOperation(value = "查询全部")
    public ResponseResult findAll() {
        return ResponseResult.e(ResponseCode.OK, templateService.selectList(new EntityWrapper<>()));
    }

    @PostMapping(value = {"/findByName"})
    @ApiOperation(value = "按模板名称查询")
    public ResponseResult findByName(@RequestParam @ApiParam(value = "模板名称") String templateName) {
        EntityWrapper<Template> wrapper = new EntityWrapper<>();
        wrapper.eq("template_name", templateName);
        return ResponseResult.e(ResponseCode.OK, templateService.selectList(wrapper));
    }

    @PostMapping(value = {"/add"})
    @ApiOperation(value = "新增模板")
    public ResponseResult add(@RequestParam @ApiParam(value = "模板名") String templateName,
                              @RequestParam @ApiParam(value = "模板内容") String content,
                              @RequestParam @ApiParam(value = "备注") String remarks) {
        // ===此处数据效验===
        templateService.add(templateName, content, remarks);
        return ResponseResult.e(ResponseCode.OK);
    }

    @PostMapping(value = {"/update"})
    @ApiOperation(value = "更新数据")
    public ResponseResult update(@RequestParam @ApiParam(value = "id") String id,
                                 @RequestParam @ApiParam(value = "模板名") String templateName,
                                 @RequestParam @ApiParam(value = "模板内容") String content,
                                 @RequestParam @ApiParam(value = "备注") String remarks) {
        // ===此处数据效验===
        templateService.update(id, templateName, content, remarks);
        return ResponseResult.e(ResponseCode.OK);
    }

    @PostMapping(value = {"/delete"})
    @ApiOperation(value = "删除模板")
    public ResponseResult delete(@RequestParam @ApiParam(value = "id") String id) {
        templateService.delete(new EntityWrapper<Template>().eq("id", id));
        return ResponseResult.e(ResponseCode.OK);
    }
}
