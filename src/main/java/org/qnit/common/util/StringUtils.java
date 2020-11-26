package org.qnit.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhuxianyu
 * @version 2020/9/15
 */
public class StringUtils {

    /**
     * 判断字符串是否为 null
     *
     * @param input
     * @return
     */
    public static boolean isNull(String input) {
        return input == null;
    }

    /**
     * 判断字符串是否包含空格
     *
     * @param input
     * @return
     */
    public static boolean containSpace(String input) {
        return Pattern.compile("\\s+").matcher(input).find();
    }

    /**
     * 判断字符串是否为 null 或 ""
     *
     * @param input
     * @return true为包含，false为不包含
     */
    public static boolean isEmptyOrNull(String input) {
        return isNull(input) || input.isEmpty();
    }

    /**
     * 判断字符串是否为数字、字母、下划线
     *
     * @param input
     * @return
     */
    public static boolean isValid(String input) {
        Pattern pattern = Pattern.compile("^\\w+$");
        return pattern.matcher(input).matches();
    }

    /**
     * 判断是否含有特殊字符
     *
     * @param str
     * @return true为包含，false为不包含
     */
    public static boolean isSpecialChar(String str) {
        String regEx = "[ _`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.find();
    }

    /**
     * 英文或数字，且不能以数字打头
     *
     * @param str
     * @return true 为合法， fase 为不合法
     */
    public static boolean isNumberAndEnglish(String str) {
        String regEx = "^[A-Za-z]{1}[A-Za-z0-9]*$";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.find();
    }

    /**
     * 邮箱格式判断
     *
     * @param email
     * @return true 表示合法，false表示不合法
     */
    public static boolean checkEmail(String email) {
        boolean flag = false;
        try {
            String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(email);
            flag = matcher.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    /**
     * 判断字符串的长度，与 shortest 和 longest 做比较
     *
     * @param str
     * @param shortest
     * @param longest
     * @return true 表示 shortest <= 字符串的长度 <= longest，false 反之
     */
    public static boolean strLength(String str, int shortest, int longest) {
        int length = str.length();
        return length >= shortest && length <= longest;
    }

}
