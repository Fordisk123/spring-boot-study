package henryhui.site.study.service;

import henryhui.site.study.core.JwtComponent;
import henryhui.site.study.dao.UserDao;
import henryhui.site.study.model.User;
import henryhui.site.study.service.pojo.LoginReq;
import henryhui.site.study.service.pojo.LoginRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AuthService {

    @Autowired
    UserDao userDao;

    @Autowired
    JwtComponent jwtComponent;

    public LoginRes login(LoginReq dto) throws Exception{
        User user = userDao.findUserByLoginName(dto.getLoginName());
        if (user == null){
            String errMsg = String.format("Can't get user by login name ： %s" , dto.getLoginName());
            log.error(errMsg);
            throw new Exception(errMsg);
        }
        String password = user.getPassword();
        String token = "";
        if(password.equals(dto.getPassword())){
            //签发token
            token = jwtComponent.createToken(dto.getLoginName());
        }else{
            String errMsg = String.format("Wrong password");
            log.error(errMsg);
            throw new Exception(errMsg);
        }
        if (token.isEmpty()){
            String errMsg = String.format("Get token error");
            log.error(errMsg);
            throw new Exception(errMsg);
        }
        return new LoginRes(user,  token);
    }

}
