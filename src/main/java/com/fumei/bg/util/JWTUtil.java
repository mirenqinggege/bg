package com.fumei.bg.util;

import com.auth0.jwt.algorithms.Algorithm;
import com.fumei.bg.config.Global;

import java.util.Date;

/**
 * @author zkh
 */
@SuppressWarnings("AlibabaClassNamingShouldBeCamel")
public class JWTUtil {

    private static final long EXPIRE_TIME = Long.parseLong(Global.getConfig("Token.expireTime"));
    private static final String TOKEN_SECRET = Global.getConfig("Token.secret");

    public static String sign(Long userId){
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
        return null;
    }
}
