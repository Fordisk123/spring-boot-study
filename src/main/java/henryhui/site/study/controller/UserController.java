package henryhui.site.study.controller;

import henryhui.site.study.model.User;
import henryhui.site.study.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

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

    @GetMapping("/userName/{loginName}")
    public User findUserByName(@PathVariable String loginName){
        return userService.getUserByName(loginName);
    }
}
