package com.warehouse.util;

import java.security.MessageDigest;

/**
 * @author hrant.azatyan | created: 1/26/2019 12:25 PM
 */
public class HashUtils {

    public static String hashSHA(String source) {
        return hash(source, "SHA");
    }

    public static String hashSHA_256(String source) {
        return hash(source, "SHA-256");
    }

    public static String hash(String source, String algorithm) {
        StringBuilder sb = new StringBuilder();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            byte[] bytes = messageDigest.digest(source.getBytes());
            for (byte aByte : bytes) {
                String hexVal = Integer.toHexString(0xFF & aByte);
                if (hexVal.length() == 1) {
                    sb.append("0");
                }
                sb.append(hexVal);
            }
        } catch (Exception ignored) {

        }
        return sb.toString();
    }

    private HashUtils() {

    }

}
