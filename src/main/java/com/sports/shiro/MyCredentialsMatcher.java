package com.sports.shiro;

import com.sports.service.UserService;
import com.sports.token.JwtToken;
import com.sports.utils.StringUtil;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 密码验证器
 */
@Component
public class MyCredentialsMatcher extends SimpleCredentialsMatcher {
    @Autowired
    private UserService userService;

    /**
     * 密码验证器：把输入的密码加密之后与数据库中存的密码对比
     * @param token
     * @param info
     * @return
     */
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        JwtToken jwtToken=(JwtToken) token;
        if (jwtToken.getPassword() == null){
            return true;//如果有token就证明有身份了
        }
        //获得用户输入的密码:(可以采用加盐(salt)的方式去检验)
        String inPassword = new String(jwtToken.getPassword());
        //获得数据库中的用户名
        String username = String.valueOf(info.getPrincipals());
        //获取盐
        String slat = userService.getUserByUsername(username).getSalt();
        //数据库中存的密码
        String dbPassword=(String) info.getCredentials();
        //进行密码的比对
        //String doublePass = StringUtil.md5(inPassword + slat);
        //System.out.println("加密的密码是"+doublePass);
        return this.equals(StringUtil.md5(inPassword + slat), dbPassword);
    }
}
