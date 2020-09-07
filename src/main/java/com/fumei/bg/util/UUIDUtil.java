package com.fumei.bg.util;

import java.util.UUID;

/**
 * @author zkh
 */
public class UUIDUtil {
    public static String randomUUID(boolean isSimple) {
        String s = UUID.randomUUID().toString();
        if (isSimple) {
            return s.replaceAll("-", "");
        }
        return s;
    }
}
