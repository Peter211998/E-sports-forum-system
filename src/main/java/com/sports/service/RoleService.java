package com.sports.service;

import java.util.Set;

public interface RoleService {
    /**
     * 通过用户名获取所有角色名
     * @param userAccountName
     * @return
     */
    Set<String> getAllRoleNamesByUsername(String userAccountName);
}
