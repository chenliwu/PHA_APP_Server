package com.clw.phaapp.common.utils;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig.Feature;
import org.codehaus.jackson.type.TypeReference;

import java.util.Map;


public class JsonUtils {
    private static ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
        objectMapper.configure(Feature.WRITE_DATES_AS_TIMESTAMPS, false);
    }

    /**
     * @param map
     * @param clazz
     * @return
     */
    public static <T> T convertMapToObject(Map<String, Object> map, Class<T> clazz) {
        if (map == null || clazz == null) {return null;}
        try {
            return objectMapper.convertValue(map, clazz);
        } catch (Exception e) {
            ifNULLThenNew();
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T convertMap(Object obj, TypeReference<T> t) {
        if (obj == null || t == null) {return null;}
        try {
            return objectMapper.convertValue(obj, t);
        } catch (Exception e) {
            ifNULLThenNew();
            e.printStackTrace();
        }
        return null;
    }

    /**
     * java 对象转换为json 存入流中
     *
     * @param obj
     */
    public static String toJson(Object obj) {
        if (obj == null) {
            return null;
        }
        String s = null;
        try {
            s = objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            ifNULLThenNew();
            throw new RuntimeException(e);
        }
        return s;
    }

    /**
     * json 转为java对象
     *
     * @param <T>
     * @param json
     */

    public static <T> T fromJson(String json, Class<T> valueType) {
        json = replaceJsonStrNull(json);
        if (json == null || "".equals(json)) {
            return null;
        }
        T obj = null;
        try {
            obj = objectMapper.readValue(json, valueType);
        } catch (Exception e) {
            ifNULLThenNew();
            throw new RuntimeException(e);
        }
        return obj;
    }

    /**
     * json 转为java对象
     *
     * @param <T>
     * @param json
     * @param valueTypeRef
     */
    public static <T> T fromJson(String json, TypeReference<T> valueTypeRef) {
        json = replaceJsonStrNull(json);
        if (json == null || "".equals(json)) {
            return null;
        }
        T obj = null;
        try {
            obj = objectMapper.readValue(json, valueTypeRef);
        } catch (Exception e) {
            ifNULLThenNew();
            throw new RuntimeException(e);
        }
        return obj;
    }

    /**
     * 将jsonstring 转化成 jsonNode
     *
     * @return
     * @methodName: readTree
     * @returnType: T
     * @author: liuBh
     */
    public static JsonNode readTree(String content) {
        content = replaceJsonStrNull(content);
        try {
            return objectMapper.readTree(content);
        } catch (Exception e) {
            ifNULLThenNew();
            throw new RuntimeException(e);
        }
    }

    public static <T> T fromNode(JsonNode node, Class<T> clazz) {
        try {
            return objectMapper.convertValue(node, clazz);
        } catch (Exception e) {
            ifNULLThenNew();
            throw new RuntimeException(e);
        }
    }

    public static <T> T fromNode(JsonNode node, TypeReference<T> typeReference) {
        try {
            return objectMapper.convertValue(node, typeReference);
        } catch (Exception e) {
            ifNULLThenNew();
            throw new RuntimeException(e);
        }
    }

    private static synchronized void ifNULLThenNew() {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
        }
        objectMapper.configure(Feature.WRITE_DATES_AS_TIMESTAMPS, false);
    }


    private static String replaceJsonStrNull(String json) {
        if (json == null || "".equals(json)) {
            return json;
        }
        json = json.replaceAll("\"[^\"]+\":null,", "");
        json = json.replaceAll(",\"[^\"]+\":null", "");
        return json;
    }
}