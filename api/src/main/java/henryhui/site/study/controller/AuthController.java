package henryhui.site.study.controller;

import com.sun.deploy.net.HttpResponse;
import henryhui.site.study.core.ApiResponse;
import henryhui.site.study.service.AuthService;
import henryhui.site.study.service.pojo.LoginReq;
import henryhui.site.study.service.pojo.LoginRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/login")
    public ApiResponse login(@RequestBody @Validated LoginReq dto , HttpServletResponse httpResponse) throws Exception {
        LoginRes res = authService.login(dto);
        httpResponse.setHeader("token", res.getToken());
        return ApiResponse.Builder.success(res.getUser());
    }
}
