package com.automation.utils;

import com.automation.constants.FrameworkConstants;
import com.automation.enums.ConfigProperties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyUtils {

    private PropertyUtils() {
    }

    private static Properties prop = new Properties();
    private static final Map<String, String> map = new HashMap<>();

    static {
        try (FileInputStream file = new FileInputStream(FrameworkConstants.CONFIGFILEPATH)) {
            prop.load(file);
            for (Object key : prop.keySet()) {
                map.put(String.valueOf(key), String.valueOf(prop.get(key)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(ConfigProperties key) {
        return map.get(key.name().toLowerCase());
    }
}