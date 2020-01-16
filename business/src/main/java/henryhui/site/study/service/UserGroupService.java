package henryhui.site.study.service;


import henryhui.site.study.dao.UserGroupDao;
import henryhui.site.study.model.UserGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserGroupService {

    @Autowired
    UserGroupDao userGroupDao;

    public UserGroup getUserGroup(Long id){
        return userGroupDao.findById(id).get();
    }

    public UserGroup saveUserGroup(UserGroup userGroup){
        return userGroupDao.save(userGroup);
    }

    public void deleteUserGroup(Long id){
        userGroupDao.deleteById(id);
    }

    public Page<UserGroup> listUserGroup(int page , int size){
        Pageable pageable = PageRequest.of(page , size);
        return userGroupDao.findAll(pageable);
    }

}
