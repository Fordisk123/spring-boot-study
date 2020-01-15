package henryhui.site.study.controller;

import henryhui.site.study.model.User;
import henryhui.site.study.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@Slf4j
public class UserController{

    @Autowired
    UserService userService;

    @PostMapping("/createUser")
    public User createUser(@RequestBody User user) {
        log.info("In createUser");
        return userService.createUser(user);
    }

    @GetMapping("/userName/{id}")
    public User findUser(@PathVariable Long id){
        return userService.getUser(id);
    }

    @PutMapping("/changeUserGroup/{id}")
    public User changeUserGroup(@PathVariable Long id , @RequestBody List<Long> userGroupIds) throws Exception{
        return userService.changeUserGroup(id , userGroupIds);
    }


}
