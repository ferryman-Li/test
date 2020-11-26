package org.qnit.common.util;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 路径处理工具
 * fileType/projectName/module/yyyy/MMdd/xxx.ext
 *
 * @author 于子源
 * @date 2020-06-06 17:58:20
 **/

@Data
//@AllArgsConstructor     //提供类的全参构造
public class PathUtils {

    private static final String SLASH = "/";
    private static final String PERIOD = ".";

    private String absolutePath;// "N:\Desktop\xxx.txt"
    private String module;
    private String projectName;

    public PathUtils(String absolutePath, String module, String projectName) {
        this.absolutePath = absolutePath;
        this.module = module;
        this.projectName = projectName;
    }

    // "/"的位置
    private int slash() {
        return absolutePath.lastIndexOf(SLASH);
    }

    // "."的位置
    private int period() {
        return absolutePath.lastIndexOf(PERIOD);
    }

    // 文件名称
    public String filename() {
        return absolutePath.substring(slash() + 1, period());
    }

    // 文件拓展名
    public String extension() {
        return absolutePath.substring(period() + 1);
    }

    /**
     * @return /yyyy/MMdd
     */
    private String datePath() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(SLASH + "yyyy" + SLASH + "MMdd");
        return simpleDateFormat.format(new Date());
    }

    /**
     * @return /projectName/module/yyyy/MMdd/xxx.ext
     */
    public String relativePath() {
        return SLASH + projectName + SLASH + module + datePath() + SLASH + filename() + PERIOD + extension();
    }

}
