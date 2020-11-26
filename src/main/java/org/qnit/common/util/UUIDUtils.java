package org.qnit.common.util;

import java.util.UUID;

/**
 * @author zhuxianyu
 * @version 2020/9/15
 */
public class UUIDUtils {
    public static String getUuid() {
        // 注意replaceAll前面的是正则表达式
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
