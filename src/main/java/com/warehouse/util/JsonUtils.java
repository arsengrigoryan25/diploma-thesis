package com.warehouse.util;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Tigran
 */
@Slf4j
public class JsonUtils {

    public static Map<String, Map<String, String>> jsonToMap(String json) {
        Gson gson = new Gson();
        Map<String, Map<String, String>> map = new LinkedHashMap<>();
        try {
            map = (Map<String, Map<String, String>>) gson.fromJson(json, map.getClass());
        } catch (Exception e) {
            log.error("Fail convert json to Map ",e);
            return null;
        }
        return map;
    }


    public static Map<String, String> jsonToMap1(String json) {
        Map<String, String> inputFieldsMap = new HashMap<>();

        /* Process FIELDS */
        inputFieldsMap.putAll(jsonToMap(json).get("fields"));

        /* Process COMBOS */
        JsonObject jsonObject = (JsonObject) new JsonParser().parse(json);
        JsonObject combos = jsonObject.getAsJsonObject("comboBox");
        if (combos != null) {
            combos.entrySet().forEach(jsonEntry -> {
                final String value = jsonEntry.getValue().getAsJsonObject().get("value").getAsString();
                final String label = jsonEntry.getValue().getAsJsonObject().get("visValue").getAsString();
                inputFieldsMap.put(jsonEntry.getKey(), value);
            });
        }

        return inputFieldsMap;
    }
    public static Map<String, String> jsonToMapComboLabel(String json) {
        Map<String, String> inputFieldsMap = new HashMap<>();

        /* Process FIELDS */
      //  inputFieldsMap.putAll(jsonToMap(json).get("fields"));

        /* Process COMBOS */
        JsonObject jsonObject = (JsonObject) new JsonParser().parse(json);
        JsonObject combos = jsonObject.getAsJsonObject("comboBox");
        if (combos != null) {
            combos.entrySet().forEach(jsonEntry -> {
                final String value = jsonEntry.getValue().getAsJsonObject().get("value").getAsString();
                final String label = jsonEntry.getValue().getAsJsonObject().get("visValue").getAsString();
                inputFieldsMap.put(jsonEntry.getKey(), label);
            });
        }

        return inputFieldsMap;
    }
}