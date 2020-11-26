package org.qnit.controller2;

import org.qnit.entity.ClusterMaster;
import org.qnit.entity.Template;
import org.qnit.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class TemplateController2 {

    @Autowired
    private TemplateService TemplateService;

    @RequestMapping("/findallTemplate")
    public String findall(Model model) {
        List<Template> list = TemplateService.findAll();
        model.addAttribute("list", list);
        return "findallTemplate";
    }
    @RequestMapping("/addTemplate")
    public String addTemplate() {
        return "addTemplate";
    }

    @RequestMapping("/updateTemplate")
    public String updateTemplate() {
        return "updateTemplate";
    }

    @RequestMapping("/findByTemplatename")
    public String findByTemplatename() {
        return "findByTemplatename";
    }

    @RequestMapping("/deleteTemplate")
    public String delete() {
        return "deleteTemplate";
    }

    @RequestMapping("/addTemplateValid")
    public String addTemplateValid(HttpServletRequest request) {
        String templateName = request.getParameter("templateName");
        String content = request.getParameter("content");
        String remarks = request.getParameter("remarks");
        TemplateService.add(templateName,content,remarks);
        return "valid";
    }


    @RequestMapping("/updateTemplateValid")
    public String updateTemplateValid(HttpServletRequest request) {
        String id=request.getParameter("id");
        String templateName = request.getParameter("templateName");
        String content = request.getParameter("content");
        String remarks = request.getParameter("remarks");
        TemplateService.add(templateName,content,remarks);
        TemplateService.update(id , templateName,content,remarks);
        return "valid";
    }
    @RequestMapping("/findByTemplatenameValid")
    public String findByTemplatenameValid(HttpServletRequest request ,Model model) {
        String templateName = request.getParameter("templateName");
        Template template = TemplateService.findByTemplateName(templateName);
        model.addAttribute("template", template);
        return "findbyTname";
    }

    @RequestMapping("/deleteTemplateValid")
    public String deleteTemplateValid(HttpServletRequest request) {
        TemplateService.delete(request.getParameter("id"));
        return "valid";
    }

}
