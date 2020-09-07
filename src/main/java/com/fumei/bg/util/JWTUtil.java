package com.fumei.bg.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fumei.bg.common.AjaxResult;
import com.fumei.bg.config.Global;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;

/**
 * @author zkh
 */
@SuppressWarnings("AlibabaClassNamingShouldBeCamel")
public class JWTUtil {

    private static final long EXPIRE_TIME = Long.parseLong(Global.getConfig("Token.expireTime"));
    private static final String TOKEN_SECRET = Global.getConfig("Token.secret");
    private static final String TOKEN_HEADER = Global.getConfig("Token.header");
    private static final String TOKEN_EXPIRE = "The Token has expired";

    public static String sign(Long userId) {
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
        HashMap<String, Object> map = new HashMap<>(2);
        map.put("Type", "Jwt");
        map.put("alg", "HS256");
        return JWT.create()
                .withHeader(map)
                .withClaim("userId", userId)
                .withExpiresAt(date)
                .sign(algorithm);
    }

    public static Long verify(String token) {
        Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
        JWTVerifier build = JWT.require(algorithm).build();
        DecodedJWT verify = build.verify(token);
        return verify.getClaim("userId").asLong();
    }

    public static String getToken(HttpServletRequest request){
        return request.getHeader(TOKEN_HEADER);
    }

    public static boolean validateToken(HttpServletRequest request, HttpServletResponse response) {
        String header = request.getHeader(TOKEN_HEADER);
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (header == null) {
            try {
                writer.write(JsonUtil.objectToJson(new AjaxResult(AjaxResult.USER_NOT_LOGIN_CODE, AjaxResult.USER_NOT_LOGIN_MESSAGE)));
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }
        try {
            JWTUtil.verify(header);
        } catch (JWTVerificationException e) {
            if (e.getMessage().contains(TOKEN_EXPIRE)) {
                try {
                    writer.write(JsonUtil.objectToJson(new AjaxResult(AjaxResult.USER_LOGIN_TIMEOUT_CODE, AjaxResult.USER_LOGIN_TIMEOUT_MESSAGE)));
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            } else {
                try {
                    writer.write(JsonUtil.objectToJson(new AjaxResult(AjaxResult.USER_TOKEN_ERROR_CODE, AjaxResult.USER_TOKEN_ERROR_MESSAGE)));
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
            return false;
        }
        return true;
    }
}
