package com.warehouse.util;

/**
 * @author hrant.azatyan | created: 1/26/2019 6:25 PM
 */
public class StringUtils {

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static String convertToHtmlBreaks(String text) {
        return text.replaceAll("\n", "<br>");
    }

    private StringUtils() {

    }
}
