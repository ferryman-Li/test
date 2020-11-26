package org.qnit.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.qnit.common.bean.ResponseCode;
import org.qnit.common.response.ResponseResult;
import org.qnit.common.util.PathUtils;
import org.qnit.service.ScriptInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@Api(tags = "脚本上传")
@RequestMapping("/script")
public class ScriptUploadController {
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

    @PostMapping(value = {"/upload"}, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ApiOperation(value = "脚本上传")
    public ResponseResult uploadScript(@RequestParam("file") MultipartFile multipartFile,
                                       @RequestParam @ApiParam(value = "所属模块") String moduleName,
                                       @RequestParam @ApiParam(value = "脚本名") int status,
                                       @RequestParam @ApiParam(value = "备注") String remarks) {
        Map result = upload(multipartFile, moduleName, remarks);
        String fullFilename = (String) result.get("fullFilename");
        String savePath = (String) result.get("savePath");
        if (result != null) {
            scriptInfoService.add(moduleName, fullFilename, savePath, status, remarks);
            return ResponseResult.e(ResponseCode.OK, result);
        }
        return ResponseResult.e(ResponseCode.FAIL, result);
    }
}
