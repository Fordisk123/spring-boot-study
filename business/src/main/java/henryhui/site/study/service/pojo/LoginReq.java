package henryhui.site.study.service.pojo;

import lombok.Data;

import javax.validation.constraints.NotBlank;


@Data
public class LoginReq {
    @NotBlank(message = "LoginName can't be empty!")
    String loginName;
    String password;
}
