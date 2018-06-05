package com.dlkj.exam.util;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;

/**
 * Map工具，避免操作null
 *
 * @author 朱天强
 * @date 2018/6/4
 */
public class MapUtil {
    private static Object get(final Map<String, Object> map, final String key, final Object defaultVal) {
        return Optional.ofNullable(map.get(key)).orElse(defaultVal);
    }

    public static BigDecimal getBigDecimal(final Map<String, Object> map, final String key, final BigDecimal defaultVal) {
        return new BigDecimal(get(map, key, defaultVal).toString());
    }

    public static BigDecimal getBigDecimal(final Map<String, Object> map, final String key) {
        return new BigDecimal(get(map, key, BigDecimal.ZERO).toString());
    }

    public static Integer getInteger(final Map<String, Object> map, final String key, final Integer defaultVal) {
        return (Integer) get(map, key, defaultVal);
    }

    public static Integer getInteger(final Map<String, Object> map, final String key) {
        return (Integer) get(map, key, 0);
    }

    public static String getString(final Map<String, Object> map, final String key, final String defaultVal) {
        return (String) get(map, key, defaultVal);
    }

    public static String getString(final Map<String, Object> map, final String key) {
        return (String) get(map, key, "");
    }
}
