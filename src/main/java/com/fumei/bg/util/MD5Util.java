package com.fumei.bg.util;

import com.fumei.bg.domain.User;
import org.apache.tomcat.util.security.MD5Encoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author zkh
 */
@SuppressWarnings({"AlibabaClassNamingShouldBeCamel","AlibabaLowerCamelCaseVariableNaming"})
public class MD5Util {

    public static String MD5Encoding(String str){
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
        md.reset();
        byte[] digest = md.digest(str.getBytes(StandardCharsets.UTF_8));
        return bytesToHexString(digest);
    }

    public static String MD5Encoding(File file) {
        FileInputStream fis = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            fis = new FileInputStream(file);
            byte[] buffer = new byte[2048];
            long var5 = System.currentTimeMillis();

            int length;
            while ((length = fis.read(buffer)) != -1) {
                md.update(buffer, 0, length);
            }

            byte[] b = md.digest();
            return bytesToHexString(b);
        } catch (Exception var18) {
            var18.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException var17) {
                var17.printStackTrace();
            }

        }

        return null;
    }

    private static String bytesToHexString(byte[] src) {
        StringBuilder sb = new StringBuilder();
        if (src != null && src.length > 0) {
            for (byte b : src) {
                int v = b & 255;
                String hv = Integer.toHexString(v);
                if (hv.length() < 2) {
                    sb.append(0);
                }

                sb.append(hv);
            }

            return sb.toString();
        } else {
            return null;
        }
    }

    public static void passwordEncoding(User user) {
        String loginName = user.getLoginName(), password = user.getPassword(), salt = getRandomChar(4);
        user.setSalt(salt);
        user.setPassword(MD5Encoding(loginName + password + salt));
    }

    public static char getRandomChar() {
        return (char) (0x4e00 + (int) (Math.random() * (0x9fa5 - 0x4e00 + 1)));
    }

    public static String getRandomChar(int count) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < count;i++){
            sb.append(getRandomChar());
        }
        return sb.toString();
    }
}
