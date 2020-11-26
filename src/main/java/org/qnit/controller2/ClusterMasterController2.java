package org.qnit.controller2;

import org.qnit.entity.ClusterMaster;
import org.qnit.service.ClusterMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ClusterMasterController2 {

    @Autowired
    private ClusterMasterService clusterMasterService;

    @RequestMapping("/findall")
    public String findall(Model model) {
        List<ClusterMaster> list = clusterMasterService.findAll();
        model.addAttribute("list", list);
        return "findall";
    }

    @RequestMapping("/add")
    public String add() {
        return "add";
    }

    @RequestMapping("/findByClusterName")
    public String findByClusterName() {
        return "findByClusterName";
    }

    @RequestMapping("/findByMasterIp")
    public String findByMasterIp() {
        return "findByMasterIp";
    }

    @RequestMapping("/delete")
    public String delete() {
        return "delete";
    }

    @RequestMapping("/update")
    public String update() {
        return "update";
    }

    @RequestMapping("/addValid")
    public String addValid(HttpServletRequest request) {
        String clusterName = request.getParameter("clusterName");
        String masterIp = request.getParameter("masterIp");
        String userName = request.getParameter("userName");
        String userPwd = request.getParameter("userPwd");
        clusterMasterService.add(clusterName, masterIp, userName, userPwd);
        return "valid";
    }

    @RequestMapping("/deleteValid")
    public String deleteValid(HttpServletRequest request) {
        clusterMasterService.delete(request.getParameter("id"));
        return "valid";
    }

    @RequestMapping("/updateValid")
    public String updateValid(HttpServletRequest request) {
        String id = request.getParameter("id");
        String clusterName = request.getParameter("clusterName");
        String masterIp = request.getParameter("masterIp");
        String userName = request.getParameter("userName");
        String userPwd = request.getParameter("userPwd");
        clusterMasterService.update(id, clusterName, masterIp, userName, userPwd);
        clusterMasterService.add(clusterName, masterIp, userName, userPwd);
        return "valid";
    }

    @RequestMapping("/findByClusterNameValid")
    public String findByClusterNameValid(HttpServletRequest request ,Model model) {
        String clusterName = request.getParameter("clusterName");
        ClusterMaster clusterMaster = clusterMasterService.findByClusterName(clusterName);
        model.addAttribute("clusterMaster", clusterMaster);
        return "findbyCMname";
    }
    @RequestMapping("/findByMasterIpValid")
    public String findByMasterIpValid(HttpServletRequest request , Model model) {
        String masterIp = request.getParameter("masterIp");
        ClusterMaster clusterMaster = clusterMasterService.findByMasterIp(masterIp);
        model.addAttribute("clusterMaster", clusterMaster);
        return "findbyCMip";
    }
}
