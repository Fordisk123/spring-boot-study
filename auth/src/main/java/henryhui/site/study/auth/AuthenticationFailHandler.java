//package henryhui.site.study.auth;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import henryhui.site.study.model.ApiRestResponse;
//import henryhui.site.study.model.ApiResultCode;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//
//@Component
//@Slf4j
//public class AuthenticationFailHandler extends SimpleUrlAuthenticationFailureHandler {
//
//    private static ObjectMapper objectMapper = new ObjectMapper();
//
//    @Override
//    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
//        log.info("Login failed");
//
//
//        ApiRestResponse apiRestResponse = new ApiRestResponse();
//        apiRestResponse.setCode(ApiResultCode.TOKEN_INVALID.code());
//        apiRestResponse.setMessage(ApiResultCode.TOKEN_INVALID.message());
//
//        response.setStatus(500);
//        response.setContentType("application/json;charset=UTF-8");
//        response.getWriter().write(objectMapper.writeValueAsString(apiRestResponse));
//    }
//
//}
