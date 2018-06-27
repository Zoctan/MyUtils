package com.dlkj.exam.util;

import javax.validation.constraints.NotNull;
import java.util.Optional;
import java.util.regex.Pattern;

/**
 * 字符串工具
 *
 * @author 朱天强
 * @date 2018/06/07
 */
public class StringUtil {
    public static void main(final String[] args) {
        final String s1 = get("123");
        System.out.println(isDigital(s1));
        final String s2 = get(null);
        System.out.println(isDigital(s2));
        System.out.println(isEmail("123456789@qq.com"));
    }

    /**
     * 避免操作null
     *
     * @param string 字符串
     * @return 字符串
     */
    public static String get(final String string) {
        return Optional.ofNullable(string).orElse("");
    }

    /**
     * 数字正则
     */
    private static final Pattern DIGITAL_PATTERN = Pattern.compile("^[-\\+]?[\\d]*$");

    /**
     * 校验是否全为数字
     *
     * @param string 字符串
     * @return Boolean
     */
    public static Boolean isDigital(@NotNull final String string) {
        // 正则有点问题，字符串为空时也通过了
        return string.length() != 0 && DIGITAL_PATTERN.matcher(string).matches();
    }

    /**
     * 邮箱正则
     */
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$");

    /**
     * 校验邮箱
     *
     * @param string 字符串
     * @return Boolean
     */
    public static Boolean isEmail(@NotNull final String string) {
        return EMAIL_PATTERN.matcher(string).matches();
    }

    /**
     * 手机正则
     */
    private static final Pattern MOBILE_PATTERN = Pattern.compile("^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$");

    /**
     * 校验手机
     *
     * @param string 字符串
     * @return Boolean
     */
    public static Boolean isMobile(@NotNull final String string) {
        return MOBILE_PATTERN.matcher(string).matches();
    }
}
