package org.qnit.common.util;

import io.swagger.annotations.Api;
import org.qnit.common.bean.ResponseCode;
import org.qnit.common.response.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

/**
 * @author 于子源
 * @date 2020-06-04 16:38:04
 */

@RestController
@Api(tags = "文件下载")
@RequestMapping("/common/download")
public class FileDownloadBak {

    @GetMapping("id")
    public ResponseResult download(String sourcePath, String targetPath) {

        // 原文件存储路径
        InputStream in;
        OutputStream out = null;
        try {
            File file = new File(targetPath);
            //判断路径是否存在，如果不存在就创建一个
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            //创建 BufferedOutputStream 流
            out = new BufferedOutputStream(new FileOutputStream(file));
            in = new FileInputStream(sourcePath);
            int len = 0;
            //创建数据缓冲区
            byte[] buffer = new byte[1024];
            //将FileInputStream流写入到buffer缓冲区
            while ((len = in.read(buffer)) > 0) {
                //使用BufferedOutputStream将缓冲区的数据输出到指定位置文件
                out.write(buffer, 0, len);
            }
            out.flush();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return ResponseResult.e(ResponseCode.OK);
    }

}