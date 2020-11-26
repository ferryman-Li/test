package org.qnit.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.qnit.common.bean.ResponseCode;
import org.qnit.common.response.ResponseResult;
import org.qnit.common.util.RemoteConnection;
import org.qnit.entity.ClusterMaster;
import org.qnit.entity.ScriptInfo;
import org.qnit.entity.Template;
import org.qnit.service.ClusterMasterService;
import org.qnit.service.ScriptInfoService;
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
 * @since 2020-10-06
 */
@RestController
@RequestMapping("/main")
@Api(tags = {"主页面"})
public class MainController {

    @Autowired
    private ClusterMasterService clusterMasterService;

    @Autowired
    private ScriptInfoService scriptInfoService;

    @Autowired
    private TemplateService templateService;

    @PostMapping(value = {"/submitcmd"})
    @ApiOperation(value = "提交命令")
    public ResponseResult submitCmd(@RequestParam @ApiParam(value = "管理节点IP") String masterIp,
                                    @RequestParam @ApiParam(value = "命令") String cmd) {
        // ===此处数据效验===
        if (masterIp == null)
            return ResponseResult.e(ResponseCode.FAIL, "管理节点IP不能为空");
        ClusterMaster clusterMaster = clusterMasterService.findByMasterIp(masterIp);
        String userName = clusterMaster.getUserName();
        String userPwd = clusterMaster.getUserPwd();
        RemoteConnection rec = new RemoteConnection(masterIp, userName, userPwd);
        String execute = rec.execute(cmd);
        return ResponseResult.e(ResponseCode.OK, execute);
    }

    @PostMapping(value = {"/executescript"})
    @ApiOperation(value = "执行脚本")
    public ResponseResult executeScript(@RequestParam @ApiParam(value = "管理节点IP") String masterIp,
                                        @RequestParam @ApiParam(value = "脚本id") String id) {
        // ===此处数据效验===
        if (masterIp == null || id == null)
            return ResponseResult.e(ResponseCode.FAIL, "管理节点IP或脚本id不能为空");
        ClusterMaster clusterMaster = clusterMasterService.findByMasterIp(masterIp);
        String userName = clusterMaster.getUserName();
        String userPwd = clusterMaster.getUserPwd();
        ScriptInfo scriptInfo = scriptInfoService.echo(id);
        if (scriptInfo.getStatus() == 0)
            return ResponseResult.e(ResponseCode.FAIL, "该脚本已被禁用");
        RemoteConnection rec = new RemoteConnection(masterIp, userName, userPwd);
        String execute = rec.execute("sh " + scriptInfo.getPath());
        return ResponseResult.e(ResponseCode.OK, execute);
    }

    @PostMapping(value = {"/executetemplate"})
    @ApiOperation(value = "执行模板")
    public ResponseResult executeTemplate(@RequestParam @ApiParam(value = "管理节点IP") String masterIp,
                                          @RequestParam @ApiParam(value = "脚本id") String id) {
        // ===此处数据效验===
        if (masterIp == null || id == null)
            return ResponseResult.e(ResponseCode.FAIL, "管理节点IP或脚本id不能为空");
        ClusterMaster clusterMaster = clusterMasterService.findByMasterIp(masterIp);
        String userName = clusterMaster.getUserName();
        String userPwd = clusterMaster.getUserPwd();
        Template template = templateService.echo(id);
        RemoteConnection rec = new RemoteConnection(masterIp, userName, userPwd);
        String execute = rec.execute(template.getContent());
        return ResponseResult.e(ResponseCode.OK, execute);
    }

}
