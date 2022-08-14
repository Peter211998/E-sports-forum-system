package com.sports.service;

import java.util.Set;

public interface PermissionService {

    /**
     * 通过用户名获取所有权限码
     * @param userAccountName
     * @return
     */
    Set<String> getAllPermissionByUsername(String userAccountName);

    public String getPermissionById(int id);
}
