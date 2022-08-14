package com.sports.demo;

import com.sports.controller.UserController;
import com.sports.dao.RelationshipMapper;
import com.sports.dao.UserMapper;
import com.sports.enumPackage.GameEnum;
import com.sports.model.Relationship;
import com.sports.model.RelationshipExample;
import com.sports.model.User;
import com.sports.model.UserExample;
import com.sports.service.PermissionService;
import com.sports.service.RoleService;
import com.sports.service.UserService;
import com.sports.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class DemoApplicationTests{

	@Test
	void contextLoads() {
	}

	@Autowired
	private UserService userService;

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private UserController userController;

	@Autowired
	private RelationshipMapper relationshipMapper;//角色关系对象

	@Autowired
	private RoleService roleService;

	@Autowired
	private PermissionService permissionService;

	@Test
	public void testFindAllRoleByAccountName(){
		Set<String> roleList = permissionService.getAllPermissionByUsername("admin002");
		System.out.println(roleList);
	}
	@Test
	public void testFindRole(){
		Set<String> roleList = roleService.getAllRoleNamesByUsername("admin002");
		System.out.println(roleList);
	}

	@Test
	public void testFindUserByName(){
		User user = userService.getUserByUsername("admin002");
		System.out.println(user.getUserPassword().length());
		System.out.println(user.toString());
	}
	//测试枚举类
	@Test
	public void testEnum(){
		System.out.println(GameEnum.LOL.getType());
		System.out.println(GameEnum.LOL.getName());
	}

    @Test
	public void testAddUser() {

		UserExample example = new UserExample();
		example.createCriteria().andUserAccountNameEqualTo("admin004").andUserPasswordEqualTo("123456");
		System.out.println(1);

		List<User> user = userMapper.selectByExample(example);
		if(user.size() != 0){
			System.out.println(user.get(0).toString());
		}else{
			System.out.println("no one");
		}
	}

	@Test
	public void testAddManager() {
		List<String> temp= userService.addManager();
		System.out.println(temp);
	}

	//测试登录
	@Test
	public void testLogin() {
		//List<String> user = userController.loginValidation("admin002","123456");
		User user2 = userService.loginValidation("admin002","123456");
		System.out.println(user2.toString());
	}

	//测试添加用户
	@Test
	public void addUser() {
		int id = userController.userRegister("user008","123456","abc1239@163.com",0);
		//int id = userService.userRegister("user003","123456","123456@163.com",0);
		System.out.println(id);
	}

	@Test
	public void check(){
		User user = userService.findById(35);
		System.out.println(user.toString());
	}

	//多线程下测试添加用户
	@Test
	public void addUser2(){
		int id = userController.userRegister("user007","123456","abc1238@163.com",0);
		//int id = userService.userRegister("user003","123456","123456@163.com",0);
		System.out.println(id);
	}

	@Test
	public void selectRole() {
		int role = userService.findRoleByUserId(1);
		System.out.println(role);
		String str = System.currentTimeMillis()+"";

		System.out.println(str.substring(0,6));
	}

	//测试修改密码
	@Test
	public void changePassword() {
		/*int isChange = userController.changePassword(21,"111111");
		System.out.println(isChange);*/
		boolean result = false;
		try {
			result = userService.changeRedisPassword("admin003","222222");
			//if(result==true)return true;
		}catch(Exception e){

		}finally {
			System.out.println("b");
			System.out.println(result);
		}
	}

    //测试修改用户昵称
    @Test
    public void changeUserName() {
        int isChange = userController.changeUserName(19,"测试用户1");
        System.out.println(isChange);
    }

	//测试修改用户头像
	@Test
	public void changeUserPhoto() {
		int isChange = userController.changeUserPhoto(19,"www.aaaaa10010.com");
		System.out.println(isChange);
	}

	//测试修改用户邮箱
	@Test
	public void changeUserMail() {
		int isChange = userService.changeUserMail(19,"1112345@163.com");
		System.out.println(isChange);
	}
}
