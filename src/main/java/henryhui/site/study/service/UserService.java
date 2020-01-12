package henryhui.site.study.service;

import henryhui.site.study.dao.UserDao;
import henryhui.site.study.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    @Autowired
    UserDao userDao;

    public User createUser(User user){
        return userDao.save(user);
    }

    public User getUser(int id){
        return null;
    }

    public User getUserByName(String loginName){
        return userDao.findUserByLoginName(loginName);
    }

}
