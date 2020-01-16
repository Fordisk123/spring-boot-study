package henryhui.site.study.controller;

import henryhui.site.study.model.UserGroup;
import henryhui.site.study.service.UserGroupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class UserGroupController {

    @Autowired
    UserGroupService userGroupService;

    @GetMapping("/userGroup/{id}")
    public UserGroup findUserGroup(@PathVariable long id){
        return userGroupService.getUserGroup(id);
    }

    @GetMapping("/listUserGroup")
    public Page<UserGroup> listUserGroup(@RequestParam int page, @RequestParam int size){
        return userGroupService.listUserGroup(page , size);
    }

    @PutMapping("/userGroup")
    public UserGroup saveUserGroup(@RequestBody UserGroup userGroup){
        return userGroupService.saveUserGroup(userGroup);
    }

    @DeleteMapping("/userGroup/{id}")
    public void deleteUserGroup(@PathVariable Long id){
        userGroupService.deleteUserGroup(id);
    }




}
