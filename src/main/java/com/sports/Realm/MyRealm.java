package com.sports.Realm;

import com.sports.model.User;
import com.sports.service.PermissionService;
import com.sports.service.RoleService;
import com.sports.service.UserService;
import com.sports.token.JwtToken;
import com.sports.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;
    //想要自定义token就必须重写这个方法
    @Override
    //获得自己定义的token
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    /**
     * 授权：获取角色权限
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String userAccountName = (String)principalCollection.iterator().next();
        Set<String> roles = roleService.getAllRoleNamesByUsername(userAccountName);
        Set<String> permission = permissionService.getAllPermissionByUsername(userAccountName);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(roles);
        info.setStringPermissions(permission);
        return info;
    }

    //认证
    //使用自定义token
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        JwtToken jwtToken = (JwtToken)authenticationToken;
        String jwt = (String)jwtToken.getPrincipal();//就是getUserName
        Claims claims = JwtUtil.parseJWT(jwt);
        String username = claims.getId();//
        User user = userService.getUserByUsername(username);
        if(user==null){
            return null;
        }
        //String passwordTemp = user.getUserPassword();
        //char[] passChar = passwordTemp.toCharArray();
        return new SimpleAuthenticationInfo(username,user.getUserPassword(),getName());
        //
    }
}
