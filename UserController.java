package com.sports.controller;

import com.alibaba.fastjson.JSON;
import com.sports.model.User;
import com.sports.response.ResultCode;
import com.sports.service.UserService;
import com.sports.service.impl.UserServiceImpl;
import com.sports.token.JwtToken;
import com.sports.utils.JwtUtil;
import com.sports.viewModel.CompetitionView;
import lombok.val;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @CrossOrigin
    @RequestMapping(value ="/test",method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions("user:changeUserName")
    public String test(Integer userId) {
        return "你好";
    }

    @CrossOrigin
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestBody User user) {
        //非空校验
        if(user.getUserAccountName()==null||user.getUserPassword()==null){
            return JSON.toJSONString(new ResultCode().setCode(500).setMessage("用户名和密码不正确"));
        }

        Subject subject = SecurityUtils.getSubject();//返回当前对象

        //创建jwt
        String jwt = JwtUtil.createJWT(user.getUserAccountName(),"back","user",1000*60*30);//过期时间30分钟

        //创建jwt这个token
        JwtToken jwtToken = new JwtToken(jwt,user.getUserPassword());
        try{
            //登录
            subject.login(jwtToken);
        }catch (UnknownAccountException e){//账号不存在的异常
            return JSON.toJSONString(new ResultCode().setCode(401).setMessage("账号不存在"));
        }catch(IncorrectCredentialsException e){//密码错误的异常
            return JSON.toJSONString(new ResultCode().setCode(401).setMessage("密码错误"));
        }
        //把user对象返回给前端 todo:转vo
        User backUser = userService.getUserByUsername(user.getUserAccountName());
        //System.out.println(backUser.toString());
        //私密信息弄成空
        backUser.setUserPassword(null);
        backUser.setSalt(null);
        Map<String,Object> map = new HashMap<>();
        map.put("user",backUser);
        map.put("token",jwtToken);
        return JSON.toJSONString(new ResultCode().setCode(200).setMessage("登录成功").setData(map));
        //return userService.findById(1).toString();
    }

    /**
     * 此方法放弃，做参考
     * User login validation用户登录验证:
     * 1)
     * @param accountName
     * @param password
     * @return 是否可用；用户角色；用户昵称；用户头像
     */
    @RequestMapping("/loginValidation")
    @ResponseBody//将java对象转为json格式的数据
    public List<String> loginValidation(String accountName, String password){
        //参数转换
        //parameter validation: 参数校验
        if(accountName.length()>10||accountName.length()<1||password.length()>10||password.length()<1){
            return null;
        }

        //调用service层的登录方法
        User user = userService.loginValidation(accountName,password);
        if(user==null)return null;

        //检查用户角色权限
        int role = userService.findRoleByUserId(user.getUserId());//0:普通用户；1：管理员

        //拼接返回值，最好不直接用数据库原字段返回，容易被SQL注入猜到表字段
        List<String> userView = new ArrayList<>();
        userView.add(user.getIsEnable()+"");//可用
        userView.add(user.getUserId()+"");//用户userId
        userView.add(role+"");//角色
        userView.add(user.getUserName());//用户昵称
        userView.add(user.getUserPhotoUrl());//用户头像照片
        userView.add(user.getUserAccountName());//用户account name
        return userView;
    }


    @CrossOrigin
    @RequestMapping(value ="/test2",method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions("user:changeUserName")
    public String test2(@RequestBody String jsonString) {
        //HashMap<String,Object> map = new HashMap<>();
        ResultCode resultCode=JSON.parseObject(jsonString, ResultCode.class);
        //HashMap<String,Object>
        Object map= resultCode.getData();
        //User user= (User) map.get("user");
        Map map2 = (Map) map;
        Map map3 = (Map) map2.get("user");
        System.out.println(map3.get("userAccountName"));
        //map.forEach((a,b)-> System.out.println(a+"---"+b));
        return "你好";
    }

    /**
     * 用户注册
     * @param accountName
     * @param password
     * @param mail
     * @param role
     * @return 1:插入成功(用户创建成功) 0:输入的用户名或密码不符合规范 10：该用户名已被管理员占用  20：该用户名已被其他用户占用 -1:系统原因插入失败 15：用户邮箱不符合格式，或被占用
     */
    @RequestMapping(value="/userRegister",method = RequestMethod.POST)
    @CrossOrigin
    @ResponseBody
    @RequiresPermissions("user")
    public int userRegister(@RequestBody String jsonString){
        ResultCode resultCode=JSON.parseObject(jsonString, ResultCode.class);
        Object map= resultCode.getData();
        Map map2 = (Map) map;
        Map map3 = (Map) map2.get("user");
        String accountName =(String) map3.get("userAccountName");
                String password,
                String mail,int role
        //parameter validation 用户名和密码长度不能大于10小于6
        if(accountName.length()>10||accountName.length()<6||password.length()>10||password.length()<6){
            return 0;
        }
        //不能占用管理员预留位置
        if(accountName.substring(0,5).equals("admin")){
            return 10;
        }
        //用户邮箱格式符合条件
        if(!mail.contains("@"))return 15;

        //调用service层的方法，插入用户数据,判读得到的返回值
        int isRegister = userService.userRegister(accountName,password,mail,role);

        //拼接返回值
        return isRegister;
    }

    /**
     * 新增管理员
     * @return 新增管理员的账号、密码和邮箱
     */
    @RequestMapping("/addManager")//添加管理员
    @ResponseBody
    public List<String> addManager(){
        List<String> userView = userService.addManager();
        return userView;
    }

    /**
     * 修改密码
     * @param userId
     * @param password
     * @return
     */
    @RequestMapping("/changePassword")
    @ResponseBody
    public int changePassword(Integer userId,String password){
        //参数转换

        //调用service层方法
        int isChange = userService.changePassword(userId,password);
        return isChange;
    }

    /**
     * 修改用户昵称
     * @param userId
     * @param userName
     * @return
     */
    @RequestMapping("/changeUserName")
    @ResponseBody
    public int changeUserName(Integer userId,String userName){//todo
        //参数转换

        //调用service层方法
        int isChange = userService.changeUserName(userId,userName);
        return isChange;
    }

    /**
     * 修改用户头像
     * @param userId
     * @param userPhoto
     * @return
     */
    @RequestMapping("/changeUserPhoto")
    @ResponseBody
    public int changeUserPhoto(Integer userId,String userPhoto){
        //参数转换

        //调用service层方法
        int isChange = userService.changeUserPhoto(userId,userPhoto);
        return isChange;
    }

    /**
     * 修改用户邮箱
     * @param userId
     * @param userMail
     * @return
     */
    @RequestMapping("/changeUserMail")
    @ResponseBody
    public int changeUserMail(Integer userId,String userMail){
        //参数转换

        //调用service层方法
        int isChange = userService.changeUserMail(userId,userMail);
        return isChange;
    }
    //用户注销
    public int userLogout(Integer userId){//todo
        return 0;
    }
}
