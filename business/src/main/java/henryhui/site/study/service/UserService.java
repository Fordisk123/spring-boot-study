package henryhui.site.study.service;

import henryhui.site.study.core.utils.PasswordUtils;
import henryhui.site.study.dao.UserDao;
import henryhui.site.study.dao.UserGroupDao;
import henryhui.site.study.model.User;
import henryhui.site.study.model.UserGroup;
import henryhui.site.study.service.exception.UserException;
import henryhui.site.study.service.exception.UserExceptionCode;
import henryhui.site.study.core.properties.PasswordProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@Slf4j
public class UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    UserGroupDao userGroupDao;

    @Autowired
    PasswordProperties passwordProperties;

    public User createUser(User user) throws UserException {
        User existUser = userDao.findUserByLoginName(user.getLoginName());
        if (existUser != null){
            throw new UserException(500 ,UserExceptionCode.DUPLICATE_USERNAME.getCode() ,
                    String.format("Duplicate username : %s" , user.getLoginName()));
        }

        String inputPassword = "";
        try{
            inputPassword = PasswordUtils.decode(user.getPassword() , passwordProperties.getInputSalt());
        }catch (Exception e){
            UserException userException = new UserException(400 ,
                    UserExceptionCode.PASSWORD_INCORRECT.getCode() , e.getMessage());
            log.error(userException.getMessage());
            throw userException;
        }
        String savePassword = "";
        try {
            savePassword = PasswordUtils.encode(inputPassword, passwordProperties.getSaveSalt());
        } catch (Exception e) {
            UserException userException = new UserException(500 ,
                    UserExceptionCode.ENCODE_PASSWORD_ERROR.getCode() , e.getMessage());
            log.error(userException.getMessage());
            throw userException;
        }
        user.setPassword(savePassword);

        return userDao.save(user);
    }

    //TODO 返回没有密码的用户信息
    public User getUser(Long id){
        return userDao.findById(id).get();
    }

    public User changeUserGroup(Long id , List<Long> groupIds) throws Exception{
        List<UserGroup> userGroups = userGroupDao.findIn(groupIds);
        User user = userDao.findById(id).get();
        if(user == null){
          throw new Exception("Can't found user by id : " + id);
        }
        user.setLinkedUserGroups(new HashSet<>(userGroups));
        return userDao.save(user);
    }
}
