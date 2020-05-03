package henryhui.site.study.auth;

import henryhui.site.study.core.ApiResponse;
import henryhui.site.study.core.JwtComponent;
import henryhui.site.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static henryhui.site.study.core.utils.SendMessageUtils.sendJsonMessage;

/**
 * @author HenryHui
 */
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Autowired
    UserService userService;

    @Autowired
    JwtComponent jwtComponent;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
        // 从 http 请求头中取出 token
        String token = httpServletRequest.getHeader("token");

        // 执行认证
        if (token == null) {
            sendJsonMessage(httpServletResponse, ApiResponse.Builder.success("Token is empty"), 400);
            return false;
        }

        //验证是否过期
        if(jwtComponent.isExpiration(token)){
            sendJsonMessage(httpServletResponse, ApiResponse.Builder.success("Token has expired"), 400);
            return false;
        }

        //提取loginName
        String loginName = jwtComponent.getLoginName(token);
        System.out.println("Get name : " + loginName);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {
    }

}