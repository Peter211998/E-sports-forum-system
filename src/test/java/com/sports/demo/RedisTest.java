package com.sports.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sports.controller.UserController;
import com.sports.dao.UserMapper;
import com.sports.model.User;
import com.sports.model.UserExample;
import com.sports.service.UserService;
import com.sports.utils.RedisUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserController userController;
    @Autowired
    private UserService userService;
    @Test
    public void test(){
        UserExample example = new UserExample();
        example.createCriteria().andUserAccountNameEqualTo("admin002").andUserPasswordEqualTo("123456");
        List<User> userList = userMapper.selectByExample(example);
        User user = userList.get(0);
        //JSONObject json =(JSONObject)JSON.toJSON(user);
        String userAccountName = user.getUserAccountName();
        String json = JSON.toJSONString(user);
        redisUtils.set(userAccountName,json,86400L);//expireTime:一天
        System.out.println((String)redisUtils.get("admin002"));
    }
    @Test
    public void testLogin(){
        String data = (String)redisUtils.get("admin001");
        User user = JSON.parseObject(data,User.class);
        System.out.println(user.toString());
    }

}