package com.sports.service.impl;

import com.sports.dao.PermissionMapper;
import com.sports.dao.RolePermissionMapper;
import com.sports.model.*;
import com.sports.service.PermissionService;
import com.sports.service.RoleService;
import com.sports.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("permissionSService")
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;
    /**
     * 通过用户名获取所有权限码
     * @param userAccountName
     * @return
     */
    @Override
    public Set<String> getAllPermissionByUsername(String userAccountName) {
        Set<String> roleSet = roleService.getAllRoleNamesByUsername(userAccountName);
        RolePermissionExample example = new RolePermissionExample();
        Iterator it = roleSet.iterator();
        Set<String> permissionSet = new HashSet<>();
        while(it.hasNext()){
            String temp = (String)it.next();
            List<RolePermission> rolePermissions = new ArrayList<>();
            if(temp.equals("普通用户")){
                example.createCriteria().andRoleIdEqualTo(1);
                rolePermissions = rolePermissionMapper.selectByExample(example);
            }else{
                example.createCriteria().andRoleIdEqualTo(2);
                rolePermissions = rolePermissionMapper.selectByExample(example);
            }


            for(int i=0;i<rolePermissions.size();i++){
                int permissionId = rolePermissions.get(i).getPermissionId();
                String name =getPermissionById(permissionId);
                permissionSet.add(name);
            }
        }

        return permissionSet;
    }

    @Override
    public String getPermissionById(int id){
        PermissionExample permissionExample = new PermissionExample();
        permissionExample.createCriteria().andPermissionIdEqualTo(id);
        List<Permission> permissionList = permissionMapper.selectByExample(permissionExample);
        String permissionName = permissionList.get(0).getPermissionCode();
        return permissionName;
    }
}
