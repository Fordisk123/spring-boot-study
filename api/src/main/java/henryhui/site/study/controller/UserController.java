package henryhui.site.study.controller;

import henryhui.site.study.core.ApiResponse;
import henryhui.site.study.model.User;
import henryhui.site.study.service.UserService;
import henryhui.site.study.service.exception.UserException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class UserController{

    @Autowired
    UserService userService;

    @PutMapping("/createUser")
    public ApiResponse<User> createUser(@RequestBody @Validated User user) throws UserException {
        log.info("In createUser");
        return ApiResponse.Builder.success(userService.createUser(user));
    }

    @GetMapping("/user/{id}")
    public ApiResponse<User> findUser(@PathVariable Long id){
        return ApiResponse.Builder.success(userService.getUser(id));
    }

    @PutMapping("/changeUserGroup/{id}")
    public ApiResponse<User> changeUserGroup(@PathVariable Long id , @RequestBody List<Long> userGroupIds) throws Exception{
        return ApiResponse.Builder.success(userService.changeUserGroup(id , userGroupIds));
    }


}
