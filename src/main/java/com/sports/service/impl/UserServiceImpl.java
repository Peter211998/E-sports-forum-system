package com.sports.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sports.dao.RelationshipMapper;
import com.sports.dao.UserMapper;
import com.sports.model.Relationship;
import com.sports.model.RelationshipExample;
import com.sports.model.User;
import com.sports.model.UserExample;
import com.sports.service.UserService;
import com.sports.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.swing.plaf.TableHeaderUI;
import java.util.ArrayList;
import java.util.List;


@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RelationshipMapper relationshipMapper;//角色关系表对象
    @Autowired
    private RedisUtils redisUtils;//redis工具类
    /**
     * 根据主键查询用户
     * @param userId
     * @return User对象
     */
    @Override
    public User findById(Integer userId){

        return userMapper.selectByPrimaryKey(userId);
    }

    /**
     * 根据用户名查询用户
     * @param userAccountName
     * @return
     */
    @Override
    public User getUserByUsername(String userAccountName) {
        UserExample example = new UserExample();
        example.createCriteria().andUserAccountNameEqualTo(userAccountName);
        List<User> userList = userMapper.selectByExample(example);
        if(userList.size()!=0){
            //password改成char[]类型
            return userList.get(0);
        }else{
            return null;
        }

    }

    /**
     * 用户登录验证
     * @param accountName
     * @param userPassword
     * @return 返回符合参数的User类型对象
     */
    @Override
    public User loginValidation(String accountName,String userPassword) {
        //先查询redis
        String jsonString = (String)redisUtils.get(accountName);
        User user = JSON.parseObject(jsonString,User.class);
        if(jsonString!=null){
            //System.out.println("直接从redis进行了调用！");
            return user;
        }
        //redis中没有，查数据库
        if (jsonString==null){
            UserExample example = new UserExample();
            example.createCriteria().andUserAccountNameEqualTo(accountName).andUserPasswordEqualTo(userPassword);
            List<User> userList = userMapper.selectByExample(example);
            //如果数据库查询非空，则放入redis并返回User对象
            if(userList.size()>0) {
                //转json
                String jsonIn = JSON.toJSONString(userList.get(0));
                redisUtils.set(userList.get(0).getUserAccountName(), jsonIn,86400L);//放入redis数据库：key是accountName，value是model转json
                //返回
                return userList.get(0);
            }
        }
        return null;
    }

    /**
     * 用户注册
     * @param accountName
     * @param userPassword
     * @param mail
     * @param role
     * @return 20：用户名已被使用 15：邮箱已被注册
     */
    @Transactional(rollbackFor = {Exception.class}) //保证事务完整性
    @Override
    public int userRegister(String accountName, String userPassword, String mail,Integer role){
        //检查该用户名是否被占用
        UserExample accountCheck = new UserExample();
        accountCheck.createCriteria().andUserAccountNameEqualTo(accountName);
        List<User> userList2 = userMapper.selectByExample(accountCheck);
        if(!userList2.isEmpty()){
            return 20;//被使用就返回20
        }
        //检查该邮箱是否被占用
        UserExample example = new UserExample();
        example.createCriteria().andUserEmailEqualTo(mail);
        List<User> userList = userMapper.selectByExample(example);
        if(!userList.isEmpty())return 15;//有则此邮箱已被注册

        boolean flag = true;
        try {
            User user = new User();
            //生成随机用户昵称
            String str = System.currentTimeMillis()+"";
            user.setUserName("论坛用户"+str.substring(str.length() - 6));
            //user表
            user.setUserAccountName(accountName);
            user.setUserPassword(userPassword);
            user.setUserEmail(mail);
            user.setUserPhotoUrl("www.photo.com");
            user.setUserRegisterTime(System.currentTimeMillis());
            user.setIsEnable(1);
            int userInsert = userMapper.insert(user);

            //relationship表
            Relationship relationship = new Relationship();
            //System.out.println(Thread.currentThread().getName()+loginValidation(accountName,userPassword).getUserId());
            int userId = loginValidation(accountName,userPassword).getUserId();//todo
            //System.out.println(name);
            relationship.setUserId(userId);
            relationship.setRoleId(role);//普通用户注册
            relationship.setIsEnable(0);
            int relationInsert = relationshipMapper.insert(relationship);
            if(userInsert==1&&relationInsert==1){
                //redis
                String jsonIn = JSON.toJSONString(user);
                redisUtils.set(accountName, jsonIn,86400L);
                return 1;
            }
        }catch(Exception e){
            //todo: 日志功能
            flag = false;
        }
        if(!flag){
            //回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return -1;
    }

    /**
     * 添加管理员
     * @return 返回List：账户名；密码；默认邮箱号码
     */
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public List<String> addManager(){
        UserExample example = new UserExample();
        example.createCriteria().andUserAccountNameGreaterThan("admin");
        List<User> adminList = userMapper.selectByExample(example);
        int last = -1;
        for(int i=0;i<adminList.size();i++){
            int temp = Integer.parseInt(adminList.get(i).getUserAccountName().substring(5));
            last = temp > last ? temp : last;
        }
        last++;
        String accountName;
        if(last<9){
            accountName = "admin00"+last;
        }else if(last<99){
            accountName = "admin0"+last;
        }else{
            accountName = "admin"+last;
        }
        System.out.println(accountName);
        String password = "123456";//管理员的默认密码
        String mail = "123456@manager";//默认邮箱
        int isCreateManager = userRegister(accountName,password,mail,1);

        //拼接返回值
        List<String> result = new ArrayList<>();
        if(isCreateManager==1){
            result.add(accountName);
            result.add(password);
            result.add(mail);
        }else{
            result.add("Something wrong");
        }
        return result;
    }

    /**
     * 根据userId查询用户权限
     * @param userId
     * @return
     */
    @Override
    public int findRoleByUserId(Integer userId) {
        RelationshipExample relationshipExample = new RelationshipExample();
        relationshipExample.createCriteria().andUserIdEqualTo(userId);
        int role = relationshipMapper.selectByExample(relationshipExample).get(0).getRoleId();
        return role;
    }

    /**
     * 更新redis中的用户密码
     * @param accountName
     * @param password
     * @return true：已经修改redis中的用户密码     false：未修改redis中的用户密码，且redis中没有这条数据
     */
    @Override
    public boolean changeRedisPassword(String accountName, String password) {//todo
        //先查redis中是否有，没有就直接进行数据库操作
        boolean hasKey = redisUtils.exists(accountName);
        if(hasKey==false)return false;//redis中没有就不要先在存redis了，要先从数据库中查出来，也会花费时间
        String jsonString = (String)redisUtils.get(accountName);
        User user = JSON.parseObject(jsonString,User.class);
        user.setUserPassword(password);
        String jsonIn = JSON.toJSONString(user);
        redisUtils.set(accountName, jsonIn,50L);
        return true;
    }

    /**
     * 修改密码
     * @param userId
     * @param password
     * @return 1则密码修改成功
     */
    @Override
    public int changePassword(Integer userId,String password) {
        //更新数据库
        User user = userMapper.selectByPrimaryKey(userId);
        user.setUserPassword(password);
        int isChange = userMapper.updateByPrimaryKey(user);
        //更新redis中用户密码
        redisUtils.remove(user.getUserAccountName());
        String jsonIn = JSON.toJSONString(user);
        redisUtils.set(user.getUserAccountName(),jsonIn,86400L);//todo:新建一个方法，redis存完就返回，然后再调用方法存MySQL
        return isChange;
    }

    /**
     * 修改用户昵称
     * @param userId
     * @param userName
     * @return
     */
    @Override
    public int changeUserName(Integer userId, String userName) {
        User user = userMapper.selectByPrimaryKey(userId);
        user.setUserName(userName);
        int isChange = userMapper.updateByPrimaryKey(user);
        return isChange;
    }

    /**
     * 修改用户头像
     * @param userId
     * @param userPhoto
     * @return
     */
    @Override
    public int changeUserPhoto(Integer userId,String userPhoto) {
        User user = userMapper.selectByPrimaryKey(userId);
        user.setUserPhotoUrl(userPhoto);
        int isChange = userMapper.updateByPrimaryKey(user);
        return isChange;
    }

    /**
     * 修改用户邮箱
     * @param userId
     * @param userMail
     * @return
     */
    @Override
    public int changeUserMail(Integer userId, String userMail) {
        User user = userMapper.selectByPrimaryKey(userId);
        user.setUserEmail(userMail);
        int isChange = userMapper.updateByPrimaryKey(user);
        return isChange;
    }

    /**
     * 用户注销
     * @param userId
     * @return
     */
    @Override
    public int userLogout(Integer userId) {//todo: 永久不可用？
        User user = userMapper.selectByPrimaryKey(userId);
        user.setIsEnable(0);
        int isChange = userMapper.updateByPrimaryKey(user);
        return isChange;
    }
}
