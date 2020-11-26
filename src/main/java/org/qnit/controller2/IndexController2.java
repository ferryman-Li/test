package org.qnit.controller2;

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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController2 {

    @Autowired
    private ClusterMasterService clusterMasterService;

    @Autowired
    private ScriptInfoService scriptInfoService;

    @Autowired
    private TemplateService templateService;

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/clusterMasterManage")
    public String clusterMasterManage() {
        return "clusterMasterManage";
    }

    @RequestMapping("/scriptInfoManage")
    public String scriptInfoManage() {
        return "scriptInfoManage";
    }

    @RequestMapping("/templateManage")
    public String templateManage() {
        return "templateManage";
    }

    @RequestMapping("/submitcmd")
    public String submitcmd() {
        return "submitcmd";
    }

    @RequestMapping("/executescript")
    public String executescript() {
        return "executescript";
    }

    @RequestMapping("/executetemplate")
    public String executetemplate() {
        return "executetemplate";
    }

    @PostMapping(value = {"/submitCmdValid"})
    public String submitCmdValid(HttpServletRequest request, Model model) {

        String masterIp = request.getParameter("masterIp");
        String cmd = request.getParameter("cmd");

        // ===此处数据效验===
        if (masterIp == null)
            return "error1";
        ClusterMaster clusterMaster = clusterMasterService.findByMasterIp(masterIp);

        String userName = clusterMaster.getUserName();
        String userPwd = clusterMaster.getUserPwd();
        RemoteConnection rec = new RemoteConnection(masterIp, userName, userPwd);

        String execute = rec.execute(cmd);
        model.addAttribute("execute", execute);
        return "cmd";
    }

    @PostMapping(value = {"/executescriptValid"})
    public String executeScript(HttpServletRequest request, Model model) {
        String masterIp = request.getParameter("masterIp");
        String id = request.getParameter("id");

        // ===此处数据效验===
        if (masterIp == null || id == null)
            return "error1";
        ClusterMaster clusterMaster = clusterMasterService.findByMasterIp(masterIp);
        String userName = clusterMaster.getUserName();
        String userPwd = clusterMaster.getUserPwd();
        ScriptInfo scriptInfo = scriptInfoService.echo(id);
        if (scriptInfo.getStatus() == 0)
            return "error1";
        RemoteConnection rec = new RemoteConnection(masterIp, userName, userPwd);

        String execute = rec.execute("sh " + scriptInfo.getPath());
        model.addAttribute("execute", execute);
        return "script";
    }
    @PostMapping(value = {"/executetemplateValid"})
    public String executeTemplate(HttpServletRequest request, Model model) {

        String masterIp = request.getParameter("masterIp");
        String id = request.getParameter("id");

        // ===此处数据效验===
        if (masterIp == null || id == null)
            return "error1";
        ClusterMaster clusterMaster = clusterMasterService.findByMasterIp(masterIp);
        String userName = clusterMaster.getUserName();
        String userPwd = clusterMaster.getUserPwd();
        Template template = templateService.echo(id);
        RemoteConnection rec = new RemoteConnection(masterIp, userName, userPwd);
        String execute = rec.execute(template.getContent());
        model.addAttribute("execute", execute);
        return "template";
    }
}
