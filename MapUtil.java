package com.dlkj.exam.util;

import com.alibaba.fastjson.JSON;

import javax.annotation.Nonnull;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;

/**
 * Map工具
 *
 * @author 朱天强
 * @date 2018/06/04
 */
public class MapUtil<T> {
    /**
     * 获取实体
     *
     * @param map map
     * @param key 键
     * @param cls 实体类
     * @return 实体
     */
    public static <T> T getEntity(@NotNull final Map<String, Object> map,
                                  @NotNull final String key,
                                  @Nonnull final Class<T> cls) {
        final Object jsonObject = getObject(map, key);
        if (jsonObject == null) {
            return null;
        }
        final String json = getObject(map, key).toString();
        return JSON.parseObject(json, cls);
    }


    /*--- 避免操作null ---*/

    public static Object getObject(@NotNull final Map<String, Object> map,
                                   @NotNull final String key,
                                   @NotNull final Object defaultVal) {
        return Optional.ofNullable(map.get(key)).orElse(defaultVal);
    }

    public static Object getObject(@NotNull final Map<String, Object> map,
                                   @NotNull final String key) {
        // 和不要null本意违背
        // todo
        return getObject(map, key, null);
    }

    public static BigDecimal getBigDecimal(@NotNull final Map<String, Object> map,
                                           @NotNull final String key,
                                           @NotNull final BigDecimal defaultVal) {
        return new BigDecimal(getObject(map, key, defaultVal).toString());
    }

    public static BigDecimal getBigDecimal(@NotNull final Map<String, Object> map,
                                           @NotNull final String key) {
        return getBigDecimal(map, key, BigDecimal.ZERO);
    }

    public static Integer getInteger(@NotNull final Map<String, Object> map,
                                     @NotNull final String key,
                                     @NotNull final Integer defaultVal) {
        return (Integer) getObject(map, key, defaultVal);
    }

    public static Integer getInteger(@NotNull final Map<String, Object> map,
                                     @NotNull final String key) {
        return getInteger(map, key, 0);
    }

    public static String getString(@NotNull final Map<String, Object> map,
                                   @NotNull final String key,
                                   @NotNull final String defaultVal) {
        return (String) getObject(map, key, defaultVal);
    }

    public static String getString(@NotNull final Map<String, Object> map,
                                   @NotNull final String key) {
        return getString(map, key, "");
    }
}
