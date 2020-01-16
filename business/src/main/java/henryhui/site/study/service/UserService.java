package henryhui.site.study.service;

import henryhui.site.study.dao.UserDao;
import henryhui.site.study.dao.UserGroupDao;
import henryhui.site.study.model.User;
import henryhui.site.study.model.UserGroup;
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

    public User createUser(User user){
        return userDao.save(user);
    }

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

    //    //为角色分配权限，传入一个角色的id，还有要分配权限对应的id数组
//    @PostMapping("/SetPriv")
//    public Role setPrivs(Long id,@RequestBody Long[] ids){
//        Role role=roleRepository.findById(id).get();
//        Set<Priv>privSet=new HashSet<>();
//        for (long pid:ids) {
//            privSet.add(privRepository.findById(pid).get());
//        }
//        role.setPrivs(privSet);
//        roleRepository.save(role);
//        return  role;
//    }

}
