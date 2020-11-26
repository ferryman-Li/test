package org.qnit.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.qnit.common.bean.ResponseCode;
import org.qnit.common.response.ResponseResult;
import org.qnit.entity.ClusterMaster;
import org.qnit.service.ClusterMasterService;
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
@RequestMapping("/clustermaster")
@Api(tags = {"集群管理节点"})
public class ClusterMasterController {

    @Autowired
    private ClusterMasterService clusterMasterService;

    @PostMapping(value = {"/findall"})
    @ApiOperation(value = "查询全部")
    public ResponseResult findAll() {
        return ResponseResult.e(ResponseCode.OK, clusterMasterService.findAll());
    }

    @PostMapping(value = {"/findByClusterName"})
    @ApiOperation(value = "按集群名称查询")
    public ResponseResult findByClusterName(@RequestParam @ApiParam(value = "集群名称") String clusterName) {
        ClusterMaster clusterMaster = clusterMasterService.findByClusterName(clusterName);
        return ResponseResult.e(ResponseCode.OK, clusterMaster);
    }

    @PostMapping(value = {"/findByMasterIp"})
    @ApiOperation(value = "按管理节点IP查询")
    public ResponseResult findByMasterIp(@RequestParam @ApiParam(value = "管理节点IP") String masterIp) {
        ClusterMaster clusterMaster = clusterMasterService.findByMasterIp(masterIp);
        return ResponseResult.e(ResponseCode.OK, clusterMaster);
    }

    @PostMapping(value = {"/add"})
    @ApiOperation(value = "新增集群")
    public ResponseResult add(@RequestParam @ApiParam(value = "集群名称") String clusterName, @RequestParam @ApiParam(value = "管理节点IP") String masterIp,
                              @RequestParam @ApiParam(value = "用户名") String userName, @RequestParam @ApiParam(value = "密码") String userPwd) {
        if (StringUtils.isBlank(clusterName) || StringUtils.isBlank(masterIp))
            return ResponseResult.e(ResponseCode.FAIL, "添加失败，集群名称和管理节点IP不能为空");
        if (clusterMasterService.findByClusterName(clusterName) != null || clusterMasterService.findByMasterIp(masterIp) != null)
            return ResponseResult.e(ResponseCode.FAIL, "添加失败，集群名称或管理节点IP已存在");
        clusterMasterService.add(clusterName, masterIp, userName, userPwd);
        return ResponseResult.e(ResponseCode.OK);
    }

    @PostMapping(value = {"/update"})
    @ApiOperation(value = "更新数据")
    public ResponseResult update(@RequestParam @ApiParam(value = "id") String id, @RequestParam @ApiParam(value = "集群名称") String clusterName, @RequestParam @ApiParam(value = "管理节点IP") String masterIp,
                                 @RequestParam @ApiParam(value = "用户名") String userName, @RequestParam @ApiParam(value = "密码") String userPwd) {
        if (StringUtils.isBlank(clusterName) || StringUtils.isBlank(masterIp))
            return ResponseResult.e(ResponseCode.FAIL, "更新失败，集群名称和管理节点IP不能为空");
        if (clusterMasterService.findByClusterName(clusterName) != null || clusterMasterService.findByMasterIp(masterIp) != null)
            return ResponseResult.e(ResponseCode.FAIL, "更新失败，集群名称或管理节点IP已存在");
        clusterMasterService.update(id, clusterName, masterIp, userName, userPwd);
        return ResponseResult.e(ResponseCode.OK);
    }

    @PostMapping(value = {"/delete"})
    @ApiOperation(value = "删除集群")
    public ResponseResult delete(@RequestParam @ApiParam(value = "id") String id) {
        clusterMasterService.delete(id);
        return ResponseResult.e(ResponseCode.OK);
    }

}
