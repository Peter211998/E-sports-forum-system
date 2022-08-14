package com.sports.service.impl;

import com.sports.dao.RelationshipMapper;
import com.sports.dao.UserMapper;
import com.sports.model.Relationship;
import com.sports.model.RelationshipExample;
import com.sports.model.User;
import com.sports.model.UserExample;
import com.sports.service.RoleService;
import com.sports.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RelationshipMapper roleMapper;

    @Autowired
    private UserService userService;

    @Override
    public Set<String> getAllRoleNamesByUsername(String username) {
        User user = userService.getUserByUsername(username);
        RelationshipExample relationshipExample = new RelationshipExample();
        relationshipExample.createCriteria().andUserIdEqualTo(user.getUserId());
        List<Relationship> roleList = roleMapper.selectByExample(relationshipExample);
        Set<String> roleSet = new HashSet();
        for(int i=0;i<roleList.size();i++){
            int roleId = roleList.get(i).getRoleId();
            if(roleId==1){
                roleSet.add("普通用户");
            }else{
                roleSet.add("管理员");
            }
        }
        return roleSet;
    }
}
