package com.fumei.bg.util;

import java.util.regex.Pattern;

/**
 * @author zkh
 */
public class RegularUtil {
    private static final String PHONE_NUMBER_REG = "^1[3|4|5|7|8][0-9]{9}$";
    private static final String EMAIL_REG = "^[A-Za-z0-9\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";

    public static boolean isPhoneNumber(String phoneNumber){
        return matches(PHONE_NUMBER_REG, phoneNumber);
    }

    public static boolean isEmail(String email){
        return matches(EMAIL_REG, email);
    }

    public static boolean matches(String pattern, String content){
        return Pattern.matches(pattern, content);
    }
}
