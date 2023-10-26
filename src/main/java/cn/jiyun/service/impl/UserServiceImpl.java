package cn.jiyun.service.impl;

import cn.jiyun.entity.User;
import cn.jiyun.mapper.UserMapper;
import cn.jiyun.result.Result;
import cn.jiyun.service.UserService;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public Result login(User user, HttpSession session, String token) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername, user.getUsername());
        queryWrapper.eq(User::getPassword, user.getPassword());
        User login = userMapper.selectOne(queryWrapper);

        if (login != null) {
            if (token != null && !"".equals(token)) {
                redisTemplate.boundValueOps(login.getId() + "").set(JSONObject.toJSONString(login));
            }
            session.setAttribute("login", login);
            return Result.success(login);
        } else {
            return Result.error("账号或密码错误");
        }
    }

    @Override
    public Result loginLike(Integer id) {
//        User user = userMapper.selectById(1);
//        System.out.println(user.toString());
//        System.out.println(JSON.toJSONString(user));
//        redisTemplate.boundValueOps(user.getId() + "").set(JSON.toJSONString(user));
//
//        String userJsonStr = (String) redisTemplate.boundValueOps(user.getId() + "").get();
//        User parse = (User) JSON.parseObject(userJsonStr, User.class);
//        System.out.println(parse);
        String login = null;

        login = (String) redisTemplate.boundValueOps(id + "").get();

        User user = JSON.parseObject(login, User.class);

        if (user != null) {
            return Result.success(user);
        } else {
            return Result.error("登陆失效，请重新登录!!!");
        }
    }
}
