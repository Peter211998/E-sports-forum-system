package com.sports.service;

import com.sports.model.User;
import com.sports.model.UserExample;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    //根据userId查找用户
    public User findById(Integer userId);

    //根据用户名查询用户密码
    public User getUserByUsername(String username);
    //登录验证用户参数
    public User loginValidation(String accountName,String userPassword);

    //用户注册
    public int userRegister(String accountName,String userPassword,String mail,Integer role);

    //添加管理员
    public List<String> addManager();

    //用户角色查询
    public int findRoleByUserId(Integer userId);

    //在redis中修改密码并返回
    public boolean changeRedisPassword(String accountName,String password);

    //修改密码
    public int changePassword(Integer userId,String password);

    //修改用户昵称
    public int changeUserName(Integer userId,String userName);

    //修改用户头像
    public int changeUserPhoto(Integer userId,String userPhoto);

    //修改用户邮箱
    public int changeUserMail(Integer userId,String userMail);

    //用户注销
    public int userLogout(Integer userId);

}
