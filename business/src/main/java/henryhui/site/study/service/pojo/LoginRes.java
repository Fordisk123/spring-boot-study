package henryhui.site.study.service.pojo;

import henryhui.site.study.model.User;
import lombok.Data;

@Data
public class LoginRes {

    public LoginRes(User user, String token) {
        this.user = user;
        this.token = token;
    }

    User user;
    String token;
}
