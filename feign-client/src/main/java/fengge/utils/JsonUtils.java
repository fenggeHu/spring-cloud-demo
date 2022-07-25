package fengge.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Map;

/**
 * @Description:
 * @Author Jinfeng.hu  @Date 2022/7/25
 **/
public class JsonUtils {
    private static Gson gson = new GsonBuilder().create();

    public static <T> T map2Object(Map<String, Object> map, Class<T> t) {
        return toObject(toJson(map), t);
    }

    public static <T> T toObject(String json, Class<T> t) {
        return gson.fromJson(json, t);
    }

    public static String toJson(Object src) {
        return gson.toJson(src);
    }

    public static JsonObject getJsonObject(String json) {
        return gson.fromJson(json, JsonElement.class).getAsJsonObject();
    }
}
