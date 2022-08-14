package com.sports.utils;

import com.alibaba.fastjson.JSON;
import com.sports.model.Info;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;

/**
 * 消费者
 */
@Component
public class InfoSubscriber1 {
    @Autowired
    private RedisUtils redisUtils;//redis工具类

    @JmsListener(destination = "infoListener1")
    public void subscriber(String jsonString) {
        Info info = JSON.parseObject(jsonString,Info.class);
        String key = "_Info"+info.getInfoTitle();
        System.out.println(key);
        redisUtils.set(key,jsonString,864000L);
    }

}
