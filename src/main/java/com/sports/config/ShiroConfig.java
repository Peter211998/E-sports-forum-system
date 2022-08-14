package com.sports.config;

import com.sports.Realm.MyRealm;
import com.sports.shiro.JwtFilter;
import com.sports.shiro.MyCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Autowired
    private MyRealm myRealm;

    @Autowired
    private MyCredentialsMatcher myCredentialsMatcher;//自定义的密码加密器和密码验证器



    @Bean
    public DefaultWebSecurityManager getDefaultSecurityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        myRealm.setCredentialsMatcher(myCredentialsMatcher);
        securityManager.setRealm(myRealm);
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager securityManager,JwtFilter jwtFilter) {
        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
        filterFactoryBean.setSecurityManager(securityManager);
        //加一个过滤器
        Map<String,Filter> filterMap = new HashMap<>();
        filterMap.put("jwt",jwtFilter);
        filterFactoryBean.setFilters(filterMap);//加入过滤器
        Map<String, String> map = new LinkedHashMap<>();//过滤的路径、过滤器
        //以下过滤规则是从上往下执行的
        //为了让swagger不被拦截，先添加头3行
        map.put("/swagger-ui.html**", "anon");
        map.put("/v2/api-docs", "anon");
        map.put("/swagger-resources/**", "anon");//anon表示正常登录.系统自带 auth表示需要登录验证

        map.put("/**","jwt");//除了上面3个，让所有请求都走这个jwt过滤器 让他拦截
        filterFactoryBean.setFilterChainDefinitionMap(map);
        filterFactoryBean.setLoginUrl("/user/login");//自定义的登录界面
        return filterFactoryBean;
    }

    @Bean
    public JwtFilter getJwtFilter() {
        return new JwtFilter();
    }

    /**
     * 开启注释
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
        creator.setProxyTargetClass(true);
        return creator;
    }
}
