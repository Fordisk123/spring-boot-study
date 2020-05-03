package henryhui.site.study.core;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtComponent {
    //One Hour
    public static final long EXPIRITION = 1000 * 60 * 60;

    @Value("demo.auth.secret")
    public String tokenSecret;

    /**
     * 生成token
     * @param loginName
     * @return
     */
    public String createToken(String loginName) {
        //指定签名的时候使用的签名算法，也就是header那部分，jjwt已经将这部分内容封装好了
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long nowMillis = System.currentTimeMillis();

        String token = Jwts
                .builder()
                .setSubject(loginName)
                .claim("loginName",loginName)
                .setIssuedAt(new Date(nowMillis))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRITION))
                .signWith(signatureAlgorithm, tokenSecret).compact();
        return token;
    }

    public Claims checkJWT(String token) {
        try {
            final Claims claims = Jwts.parser().setSigningKey(tokenSecret).parseClaimsJws(token).getBody();
            return claims;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取用户名
     * @param token
     * @return
     */
    public String getLoginName(String token){
        Claims claims = Jwts.parser().setSigningKey(tokenSecret).parseClaimsJws(token).getBody();
        return claims.get("loginName").toString();
    }

    /**
     * 是否过期
     * @param token
     * @return
     */
    public boolean isExpiration(String token){
        Claims claims = Jwts.parser().setSigningKey(tokenSecret).parseClaimsJws(token).getBody();
        return claims.getExpiration().before(new Date());
    }

//    public static void main(String[] args) {
//        String name = "acong";
//        String role = "rol";
//        String token = createToken(name,role);
//        System.out.println(token);
//
//        Claims claims = checkJWT(token);
//        System.out.println(claims.get("username"));
//
//        System.out.println(getUsername(token));
//        System.out.println(getUserRole(token));
//        System.out.println(isExpiration(token));
//
//    }
}