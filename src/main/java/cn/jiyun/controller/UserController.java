package cn.jiyun.controller;

import cn.jiyun.entity.User;
import cn.jiyun.result.Result;
import cn.jiyun.service.UserService;
import io.swagger.models.auth.In;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/login")
    public Result login(@RequestBody User user, HttpSession session, String token) {
        System.out.println("==>>Token:" + token);
        return userService.login(user, session, token);
    }

    @RequestMapping("loginLike")
    public Result loginLike(Integer id) {
        return userService.loginLike(id);
    }
}
