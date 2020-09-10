package com.fumei.bg.util;

import com.fumei.bg.common.AjaxResult;
import com.fumei.bg.config.Global;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zkh
 */
@SuppressWarnings("AlibabaClassNamingShouldBeCamel")
public class JWTUtil {
    private static final Logger log = LoggerFactory.getLogger(JWTUtil.class);
    private static final long EXPIRE_TIME = Long.parseLong(Global.getConfig("Token.expireTime"));
    private static final String TOKEN_SECRET = Global.getConfig("Token.secret");
    private static final String TOKEN_HEADER = Global.getConfig("Token.header");

    public static String sign(Long userId) {
        Map<String, Object> map = new HashMap<>(1);
        map.put("userId", userId);
        return Jwts.builder()
                .setClaims(map)
                .setIssuedAt(DateUtils.currentTime())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_TIME))
                .signWith(SignatureAlgorithm.HS256, TOKEN_SECRET)
                .compact();
    }

    public static String getToken(HttpServletRequest request, HttpServletResponse response) {
        String token = getToken(request);
        if (token != null) {
            return token;
        }
        ServletUtil.responseAjaxResult(response, new AjaxResult(AjaxResult.USER_NOT_LOGIN_CODE, AjaxResult.USER_NOT_LOGIN_MESSAGE));
        return null;
    }

    public static Long parse(HttpServletRequest request, HttpServletResponse response) {
        String token = getToken(request, response);
        if (token == null) {
            return null;
        }
        try {
            return ((Claims) Jwts.parser().setSigningKey(TOKEN_SECRET).parse(token).getBody()).get("userId", Long.class);
        } catch (ExpiredJwtException | IllegalArgumentException e) {
            ServletUtil.responseAjaxResult(response, new AjaxResult(AjaxResult.USER_LOGIN_TIMEOUT_CODE, AjaxResult.USER_LOGIN_TIMEOUT_MESSAGE));
        } catch (MalformedJwtException | SignatureException e) {
            ServletUtil.responseAjaxResult(response, new AjaxResult(AjaxResult.USER_TOKEN_ERROR_CODE, AjaxResult.USER_LOGIN_TIMEOUT_MESSAGE));
        }
        return null;
    }

    public static String getToken(HttpServletRequest request) {
        /*Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(TOKEN_HEADER)) {
                return cookie.getValue();
            }
        }
        return null;*/
        return request.getHeader(TOKEN_HEADER);
    }

    public static boolean validateLogin(HttpServletRequest request, HttpServletResponse response){
        Long parse = parse(request, response);
        return parse != null;
    }
}
