package org.qnit.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.qnit.common.bean.ResponseCode;
import org.qnit.common.response.ResponseResult;
import org.qnit.entity.ScriptInfo;
import org.qnit.service.ScriptInfoService;
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
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/script")
@Api(tags = {"任务脚本管理"})
public class ScriptInfoController {

    @Autowired
    private ScriptInfoService scriptInfoService;

    @PostMapping(value = {"/findall"})
    @ApiOperation(value = "查询全部")
    public ResponseResult findAll() {
        return ResponseResult.e(ResponseCode.OK, scriptInfoService.findAll());
    }

    @PostMapping(value = {"/add"})
    @ApiOperation(value = "新增脚本")
    public ResponseResult add(@RequestParam @ApiParam(value = "所属模块") String moduleName,
                              @RequestParam @ApiParam(value = "脚本名") String scriptName,
                              @RequestParam @ApiParam(value = "路径") String path,
                              @RequestParam @ApiParam(value = "状态") int status,
                              @RequestParam @ApiParam(value = "备注") String remarks) {
        // ===此处数据效验===
        scriptInfoService.add(moduleName, scriptName, path, status, remarks);
        return ResponseResult.e(ResponseCode.OK);
    }

    @PostMapping(value = {"/update"})
    @ApiOperation(value = "更新数据")
    public ResponseResult update(@RequestParam @ApiParam(value = "id") String id,
                                 @RequestParam @ApiParam(value = "脚本名") String scriptName,
                                 @RequestParam @ApiParam(value = "路径") String path,
                                 @RequestParam @ApiParam(value = "状态") int status) {
        // ===此处数据效验===
        scriptInfoService.update(id, scriptName, path, status);
        return ResponseResult.e(ResponseCode.OK);
    }

    @PostMapping(value = {"/delete"})
    @ApiOperation(value = "删除脚本")
    public ResponseResult delete(@RequestParam @ApiParam(value = "id") String id) {
        scriptInfoService.delete(new EntityWrapper<ScriptInfo>().eq("id", id));
        return ResponseResult.e(ResponseCode.OK);
    }

}
