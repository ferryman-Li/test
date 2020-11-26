package org.qnit.controller2;

import org.qnit.common.util.PathUtils;
import org.qnit.service.ScriptInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @auther freeyman
 * @create 2020-11-15-20:23
 */
@Controller
public class ScriptUploadController2 {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ScriptInfoService scriptInfoService;

    @Value("${oss.project_name}")
    private String project_name;

    // 文件准许上传格式导入
    @Value("${oss.file}")
    private String file;

    // 文件存储路径导入
    @Value("${oss.upload_file_path}")
    private String upload_file_path;

    /**
     * @param multipartFile 待上传文件
     * @param moduleName    所属模块，举例：core、common
     * @return
     * @throws IOException
     */
    public Map upload(MultipartFile multipartFile, String moduleName, String remarks) {
        log.info("begin upload");
        try {
            // 上传文件所在的绝对路径
            String absolutePath = multipartFile.getOriginalFilename();
            log.info("absolutePath = {}", absolutePath);
            // 路径处理工具
            PathUtils pathUtils = new PathUtils(absolutePath, moduleName, project_name);

            String filename = pathUtils.filename(); // filename:文件名
            String extension = pathUtils.extension(); // extension:扩展名

            // 全文件名
            String fullFilename = filename + "." + extension;

            // relativePath:相对路径 /projectName/module/yyyy/MMdd/xxx.ext
            String relativePath = pathUtils.relativePath();

            // 根据扩展名判断文件类型
            boolean isFile = file.indexOf(extension) != -1;

            log.info("relativePath = {}", relativePath);

            // 存储路径
            String savePath = null;
            if (isFile) {
                savePath = upload_file_path;
            } else {
                return null;
            }

            // D:/root/fileType + /projectName/module/yyyy/MMdd/xxx.ext
            savePath += relativePath;

            log.info("savePath = {}", savePath);

            File newFile = new File(savePath);
            // 判断路径是否存在，如果不存在就创建一个
            if (!newFile.getParentFile().exists()) {
                boolean fileFlag = newFile.getParentFile().mkdirs();
                log.info("fileFlag = {}", fileFlag);
            }
            log.info("newFile = {}", newFile);
            multipartFile.transferTo(newFile);

            Map<String, String> result = new HashMap<>();
//            result.put("fileName", filename);//文件上传时的名字，最初的名字
//            result.put("extName", extension);//扩展名
//            result.put("fileSize", String.valueOf(multipartFile.getSize()));//文件大小
//            result.put("fileType", fileType);//文件类型
//
//            result.put("resPath", res_path);
//            result.put("uploadFile", resourcePath);
            result.put("moduleName", moduleName);
            result.put("fullFilename", fullFilename);
            result.put("savePath", savePath);
            result.put("remarks", remarks);

            log.info("result = {}", result);
            return result;
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        return null;
    }

    @RequestMapping("/fileupload")
    public String fileupload() {
        return "fileupload";
    }

    @PostMapping(value = {"/fileuploadValid"}, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    @RequestMapping("/fileuploadValid")
    public String fileuploadValid(@RequestParam("uploadFile") MultipartFile multipartFile ,
                                    HttpServletRequest request
//                                  @RequestParam String moduleName,
//                                  @RequestParam int status,
//                                  @RequestParam String remarks
                                  ) {
        String moduleName = request.getParameter("moduleName");
        int status = request.getIntHeader("status");
        String remarks = request.getParameter("remarks");
        Map result = upload(multipartFile, moduleName, remarks);
        String fullFilename = (String) result.get("fullFilename");
        String savePath = (String) result.get("savePath");
        if (result != null) {
            scriptInfoService.add(moduleName, fullFilename, savePath, status, remarks);
            return "valid";
        }
        return "error1";
    }



}
