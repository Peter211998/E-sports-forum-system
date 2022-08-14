package com.sports.demo;

import com.alibaba.fastjson.JSON;
import com.sports.controller.CompetitionController;
import com.sports.dao.CompetitionMapper;
import com.sports.enumPackage.SeasonEnum;
import com.sports.model.Competition;
import com.sports.model.Info;
import com.sports.service.CompetitionService;
import com.sports.utils.Publisher;
import com.sports.utils.RedisUtils;
import com.sports.viewModel.CompetitionView;
import com.sports.viewModel.InfoListView;
import org.apache.activemq.command.ActiveMQTopic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.sports.enumPackage.authorEnum;

import javax.jms.Destination;
import java.text.SimpleDateFormat;
import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CompetitionTests {

    @Autowired
    private CompetitionMapper competitionMapper;

    @Autowired
    private CompetitionService competitionService;

    @Autowired
    private CompetitionController competitionController;

    @Autowired
    private RedisUtils redisUtils;//redis工具类

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private Publisher publisher;//发布者

    //根据赛事id测试查找赛事
    @Test
    public void findByCompetitionId(){
        Competition competition = competitionService.findByCompetitionId(1);
        System.out.println(competition.toString());
    }

    //根据游戏类型和赛季筛选比赛
    @Test
    public void findCompeTypeAndCompeSeason(){
        //List<CompetitionView> competitionList =  competitionService.findByCompeTypeAndCompeSeason(1,1);
        List<CompetitionView> competitionList = competitionController.findByTypeAndSeason(1,1);
        System.out.println(competitionList);

    }

    //创建赛事
    @Test
    public void addCompetition(){
        //Competition competition = competitionService.createNewCompe("TESvsIG",1,300,2,0,"www.video.com",1,4,13,1,1,result1,result2,result3,result4,result5);
        //int competition = competitionController.addCompe("TESvsIG",1,300,2,0,"www.video.com",1,4,13,1,1,10,18,7,2,0,3,2,69855,56680,11,21,1,1,10,11,7,1,0,4,1,62857,54879,9,3,2,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
        //System.out.println(competition);
        long it2 = System.currentTimeMillis()/1000;
        long it = it2*1000;
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = new Date(it);
        String res = sdf.format(date1);
        System.out.println("格式化结果：" + res);
        System.out.println(System.currentTimeMillis()/1000);
    }
    /**
     * 获取所有的key
     */
    @Test
    public void getListKey() {
        String prefix = "_Compe";
        Set<String> keys = redisTemplate.keys(prefix.concat("*"));
        List<CompetitionView> values = redisTemplate.opsForValue().multiGet(keys);
        System.out.println(keys);
        System.out.println(values);
        System.out.println(values instanceof CompetitionView);
    }

    //测试加如result表
    @Test
    public void testAddResult(){
        int result = competitionService.createNewResult(10,18,7,2,0,3,2,69855,56680,11,21,1,1);
        System.out.println(result);
    }

    //测试添加资讯
    @Test
    public void testAddInfo(){
        String title = "2022LPL夏季赛第一周&第二周最佳阵容";
        int authorId = authorEnum.LOLG.getAuthorId();
        int viewCnt = 2110;
        int likeCnt = 0;
        String context = "上单——JDG.369 /* 打野——JDG.Kanavi /* 中单——LNG.Doinb /* ADC——JDG.Hope /* 辅助——WBG.ON /* url1 /* 第一周&第二周MVP选手——LNG.Doinb url2 /* 第一周&第二周最佳新秀——V5.Dream url3";
        String apUrl = "www.apUrl6.com";
        int insert = competitionController.createInfo(title,authorId, viewCnt, likeCnt,context, apUrl);
        System.out.println(insert);
    }

    //测试查找最新5条资讯
    @Test
    public void testFindInfo(){
        List<InfoListView> infoList = competitionController.findNewInfos();
        for (int i = 0;i<infoList.size();i++){
            System.out.println(infoList.get(i).toString());
        }
    }

    //根据infoId查询info详情
    @Test
    public void testFindByInfoId(){
        Info info = competitionService.findByInfoId(1);
        System.out.println(info);
    }


    @Test
    public void topicTest() {
        // 设置话题监听者，可以自由切换
        Destination destination = new ActiveMQTopic("infoListener1");
        String title = "2022LPL夏季赛第一周&第二周最佳阵容";
        int authorId = authorEnum.LOLG.getAuthorId();
        int viewCnt = 2110;
        int likeCnt = 0;
        String context = "上单——JDG.369 /* 打野——JDG.Kanavi /* 中单——LNG.Doinb /* ADC——JDG.Hope /* 辅助——WBG.ON /* url1 /* 第一周&第二周MVP选手——LNG.Doinb url2 /* 第一周&第二周最佳新秀——V5.Dream url3";
        String apUrl = "www.apUrl6.com";
        Info info = new Info();
        info.setInfoTitle(title);
        long time = System.currentTimeMillis()/1000;
        info.setInfoDate((int)time);
        info.setInfoAuthorId(authorId);
        info.setInfoViewCnt(viewCnt);
        info.setInfoLikeCnt(likeCnt);
        info.setInfoText(context);
        info.setInfoApUrl(apUrl);
        info.setIsEnable(1);
        String message = JSON.toJSONString(info);
        for (int i = 0; i < 1; i++) {
            publisher.publish(destination, message);
            System.out.println("发布了");
        }
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("使线程睡 300 毫秒，保证消费者消费完毕!");
    }
}
