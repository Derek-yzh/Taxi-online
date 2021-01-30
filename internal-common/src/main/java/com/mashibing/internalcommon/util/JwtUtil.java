package com.mashibing.internalcommon.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * @Author: Derek
 * @DateTime: 2020/11/1 21:34
 * @Description: token服务
 */
public class JwtUtil {
    /**
     * 密钥，仅服务端存储
     */
    private static String secret = "ko346134h_we]rg3in_yip1!";

    /**
     *
     * @param subject
     * @param issueDate 签发时间
     * @return
     */
    public static String createToken(String subject, Date issueDate){
        String compactJws = Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(issueDate)
                //.setExpiration(issueDate + ...) //token过期时间
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
        return compactJws;
    }

    /**
     * 解密 jwt
     * @param token
     * @return
     * @throws Exception
     */
    public static JwtInfo parseToken(String token) {
        try {
//            xxxx.xxxxx.xxxxxxxx
            Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
            if (claims != null){
                JwtInfo ji = new JwtInfo();
                ji.setSubject(claims.getSubject());
                ji.setIssueDate(claims.getIssuedAt().getTime());
                return ji;
            }
        }catch (ExpiredJwtException e){
            e.printStackTrace();
            System.out.println("jwt过期了");
        }

        return null;
    }

    public static void main(String[] args) {
        String subject = "1";
        String token = createToken(subject,new Date());
        System.out.println("原始值："+token+"\n解码后:"+parseToken(token));
    }
}
