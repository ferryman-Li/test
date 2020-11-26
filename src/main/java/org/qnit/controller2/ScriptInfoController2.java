package org.qnit.controller2;

import org.qnit.entity.ScriptInfo;
import org.qnit.entity.Template;
import org.qnit.service.ScriptInfoService;
import org.qnit.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ScriptInfoController2 {

    @Autowired
    private ScriptInfoService ScriptInfoService;

    @RequestMapping("/findScriptInfoall")
    public String findScriptInfoall(Model model) {
        List<ScriptInfo> list = ScriptInfoService.findAll();
        model.addAttribute("list", list);
        return "findScriptInfoall";
    }

        @RequestMapping("/addScriptInfo")
    public String addScripyInfo() {
        return "addScriptInfo";
    }

    @RequestMapping("/updateScriptInfo")
    public String updateScripyInfo() {
        return "updateScriptInfo";
    }

    @RequestMapping("/deleteScriptInfo")
    public String deleteScriptInfo() {
        return "deleteScriptInfo";
    }

    @RequestMapping("/findByScriptInfoname")
    public String findByScriptInfoname() {
        return "findByScriptInfoname";
    }

    @RequestMapping("/findByScriptInfonameValid")
    public String findByScriptInfonameValid(HttpServletRequest request , Model model) {
        String scriptName = request.getParameter("scriptName");
        ScriptInfo scriptInfo = ScriptInfoService.findByScriptInfoName(scriptName);
        model.addAttribute("scriptInfo", scriptInfo);
        return "findbySIname";
    }

    @RequestMapping("/addScriptInfoValid")
    public String addScriptInfoValid(HttpServletRequest request) {
        String moduleName = request.getParameter("moduleName");
        String scriptName = request.getParameter("scriptName");
        String path = request.getParameter("path");
        int status = request.getIntHeader("status");
        String remarks = request.getParameter("remarks");
        ScriptInfoService.add(moduleName, scriptName, path, status ,remarks);
        return "valid";
    }


    @RequestMapping("/updateScriptInfoValid")
    public String updateScriptInfoValid(HttpServletRequest request) {
        String moduleName = request.getParameter("moduleName");
        String id = request.getParameter("id");
        String scriptName = request.getParameter("scriptName");
        String path = request.getParameter("path");
        int status = request.getIntHeader("status");
        String remarks = request.getParameter("remarks");
        ScriptInfoService.update(id, scriptName, path, status);
        ScriptInfoService.add(moduleName, scriptName, path, status ,remarks);
        return "valid";
    }
    @RequestMapping("/deleteScriptInfoValid")
    public String deleteScriptInfoValid(HttpServletRequest request) {
        ScriptInfoService.delete(request.getParameter("id"));
        return "valid";
    }

}
