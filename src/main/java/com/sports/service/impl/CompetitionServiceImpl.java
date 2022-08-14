package com.sports.service.impl;

import com.alibaba.fastjson.JSON;
import com.sports.dao.CompetitionMapper;
import com.sports.dao.InfoMapper;
import com.sports.dao.ResultMapper;
import com.sports.model.*;
import com.sports.service.CompetitionService;
import com.sports.utils.Publisher;
import com.sports.utils.RedisUtils;
import com.sports.viewModel.CompetitionView;
import com.sports.viewModel.InfoListView;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.jms.Destination;
import java.text.SimpleDateFormat;
import java.util.*;

@Service("competitionService")
public class CompetitionServiceImpl implements CompetitionService {

    @Autowired
    CompetitionMapper competitionMapper;

    @Autowired
    private RedisUtils redisUtils;//redis工具类

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private ResultMapper resultMapper;

    @Autowired
    private InfoMapper infoMapper;

    @Autowired
    private Publisher publisher;//发布者

    @Override
    public Competition findByCompetitionId(Integer competId) {
        Competition competition = competitionMapper.selectByPrimaryKey(competId);
        return competition;
    }

    /**
     * 根据游戏类型和赛季筛选比赛
     * @param compeType
     * @param season
     * @return
     */
    @Override
    public List<CompetitionView> findByCompeTypeAndCompeSeason(Integer compeType, Integer season) {//todo:线程安全
        //先查redis todo:加try
        String prefix = "_Compe";//赛事记录前缀
        //根据key前缀获取所有redis上所有符合条件的key
        Set<String> keys = redisUtils.getKeysByPrefix(prefix);
        List<CompetitionView> list = new ArrayList<>();
        for(String key: keys){
            String jsonString = (String)redisUtils.get(key);
            CompetitionView competitionView = JSON.parseObject(jsonString,CompetitionView.class);
            list.add(competitionView);
        }
        if(list.size()!=0){
            System.out.println("直接从人redis");
            return list;
        }
        //redis中没有，查数据库
        CompetitionExample competitionExample = new CompetitionExample();
        competitionExample.createCriteria().andIsEnableEqualTo((byte)1).andCompeTypeEqualTo(compeType).andCompeSeasonEqualTo(season);
        List<Competition> competitionList = competitionMapper.selectByExample(competitionExample);

        //存redis
        List<CompetitionView> redisIn = new ArrayList<>();
        //存热点数据
        for(int i=0;i< competitionList.size();i++){
            CompetitionView competitionView = new CompetitionView();
            competitionView.setCompetitionId(competitionList.get(i).getCompeId()+"");//赛事主键 id
            competitionView.setCompetitonTime(competitionList.get(i).getCompeTime()+"");//赛事时间
            competitionView.setCompetitionStatus(competitionList.get(i).getCompeStatus()+"");//赛事状态
            competitionView.setCompetitionHtId(competitionList.get(i).getCompeHtId()+"");//主队 team id
            competitionView.setCompetitionGtId(competitionList.get(i).getCompeGtId()+"");//客队 team id
            competitionView.setCompetitionHtScore(competitionList.get(i).getCompeHostScore()+"");//主队 得分
            competitionView.setCompetitionGtScore(competitionList.get(i).getCompeGuestScore()+"");//客队 得分
            competitionView.setCompetitionInstitution(competitionList.get(i).getCompeInstitution()+"");//赛制（BO1 BO3等）
            competitionView.setSeasonName(season+"");
            redisIn.add(competitionView);
            String jsonKey = "_Compe"+competitionList.get(i).getCompeId();
            String jsonIn = JSON.toJSONString(competitionView);
            redisUtils.set(jsonKey,jsonIn,864000L);
        }
        return redisIn;
    }

    /**
     * 新建赛事
     * @param title
     * @param compeType
     * @param compeStatus
     * @param hostScore
     * @param guestScore
     * @param videoUrl
     * @param hostId
     * @param guestId
     * @param institution
     * @param winTeam
     * @param season
     * @return 新建成功则返回competition对象，失败返回null
     */
    @Transactional(rollbackFor = {Exception.class}) //保证事务完整性
    @Override
    public Competition createNewCompe(String title, Integer compeType, Integer compeStatus, Integer hostScore, Integer guestScore, String videoUrl, Integer hostId, Integer guestId, Integer institution, Integer winTeam, Integer season,int[] result1,int[] result2,int[] result3,int[] result4,int[] result5) {
        //校验 todo:非空校验

        //存入数据库
        boolean flag = true;
        try {
            Competition competition = new Competition();
            competition.setCompeTitle(title);
            competition.setCompeType(compeType);
            competition.setCompeStatus(compeStatus);
            competition.setCompeHostScore(hostScore);
            competition.setCompeGuestScore(guestScore);
            //真实时间转时间戳
            long time = System.currentTimeMillis()/1000;
            competition.setCompeTime((int)time);
            competition.setCompeVideoUrl(videoUrl);
            competition.setCompeHtId(hostId);
            competition.setCompeGtId(guestId);
            competition.setCompeInstitution(institution);
            competition.setCompeWtId(winTeam);
            competition.setCompeSeason(season);
            competition.setIsEnable(1);
            int competitionInsert = competitionMapper.insert(competition);
            //存result表
            int len = hostScore+guestScore;
            for(int tag = 1;tag<=len;tag++){
                if(tag==1){
                    int result = createNewResult(result1[0],result1[1],result1[2],result1[3],result1[4],result1[5],result1[6],result1[7],result1[8],result1[9],result1[10],result1[11],result1[12]);
                    continue;
                }else if(tag==2){
                    int result = createNewResult(result2[0],result2[1],result2[2],result2[3],result2[4],result2[5],result2[6],result2[7],result2[8],result2[9],result2[10],result2[11],result2[12]);
                    continue;
                }else if(tag==3){
                    int result = createNewResult(result3[0],result3[1],result3[2],result3[3],result3[4],result3[5],result3[6],result3[7],result3[8],result3[9],result3[10],result3[11],result3[12]);
                    continue;
                }else if(tag==4){
                    int result = createNewResult(result4[0],result4[1],result4[2],result4[3],result4[4],result4[5],result4[6],result4[7],result4[8],result4[9],result4[10],result4[11],result4[12]);
                    continue;
                }else{
                    int result = createNewResult(result5[0],result5[1],result5[2],result5[3],result5[4],result5[5],result5[6],result5[7],result5[8],result5[9],result5[10],result5[11],result5[12]);
                    continue;
                }
            }
            if(competitionInsert==1){
                //存redis 热点数据
                CompetitionView competitionView = new CompetitionView();
                //拼接key：logic+unique_key
                CompetitionExample competitionExample = new CompetitionExample();
                competitionExample.createCriteria().andCompeTimeEqualTo((int)time);
                List<Competition> competitions = competitionMapper.selectByExample(competitionExample);
                int id  = competitions.get(0).getCompeId();
                String jsonKey = "_Compe"+id;
                competitionView.setCompetitionId(id+"");
                competitionView.setCompetitonTime((int)time+"");
                competitionView.setCompetitionStatus(compeStatus+"");//赛事状态
                competitionView.setCompetitionHtId(hostId+"");//主队 team id
                competitionView.setCompetitionGtId(guestId+"");//客队 team id
                competitionView.setCompetitionHtScore(hostScore+"");//主队 得分
                competitionView.setCompetitionGtScore(guestScore+"");//客队 得分
                competitionView.setCompetitionInstitution(institution+"");//赛制（BO1 BO3等）
                String jsonIn = JSON.toJSONString(competitionView);
                redisUtils.set(jsonKey, jsonIn,864000L);
                return competition;
            }
        }catch(Exception e){
            flag = false;
        }
        if(!flag){
            //回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return null;
    }

    /**
     * 新增赛事结果页面
     * @param compeId
     * @param htGoal
     * @param gtGoal
     * @param htLdragon
     * @param gtLdragon
     * @param htSdragon
     * @param gtSdragon
     * @param htGold
     * @param gtGold
     * @param htGuard
     * @param gtGuard
     * @param tag
     * @param isEnable
     * @return
     */
    @Override
    public int createNewResult(Integer compeId,Integer htGoal, Integer gtGoal, Integer htLdragon, Integer gtLdragon, Integer htSdragon, Integer gtSdragon, Integer htGold, Integer gtGold, Integer htGuard, Integer gtGuard, Integer tag, Integer isEnable){
        Result result = new Result();
        result.setCompeId(compeId);
        result.setResHtScore(htGoal);// 小分，区别于总比分
        result.setResGtScore(gtGoal);
        result.setResHtLdragon(htLdragon);
        result.setResGtLdragon(gtLdragon);
        result.setResHtSdragon(htSdragon);
        result.setResGtSdragon(gtSdragon);
        result.setResHtGold(htGold);
        result.setResGtGold(gtGold);
        result.setResHtGuard(htGuard);
        result.setResGtGuard(gtGuard);
        result.setResTag(tag);
        result.setIsEnable(isEnable);

        int resultInsert = resultMapper.insert(result);
        return resultInsert;
    }

    /**
     * 新增资讯
     * @param title
     * @param authorId
     * @param viewCnt
     * @param likeCnt
     * @param context
     * @param apUrl
     * @return
     */
    @Override
    public int createInfo(String title, Integer authorId, Integer viewCnt, Integer likeCnt, String context, String apUrl) {
        //先存数据库
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
        //消息队列 存redis
        String jsonIn = JSON.toJSONString(info);
        Destination destination = new ActiveMQTopic("infoListener1");//设置话题监听者为infoListener1
        publisher.publish(destination, jsonIn);
        int infoInsert = infoMapper.insert(info);
        return infoInsert;
    }

    @Override
    public int redisCreateInfoSubscriber(Integer id,String title, Integer authorId, Integer viewCnt, Integer likeCnt, String context, String apUrl) {
        String jsonKey = "_Info"+id;
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
        String jsonIn = JSON.toJSONString(info);

        redisUtils.set(jsonKey,jsonIn,864000L);
        return 0;
    }

    /**
     * 查找最新的5条资讯
     * @return
     */
    @Override
    public List<InfoListView> findNewInfos() {
        //redis

        //查数库
        InfoExample infoExample = new InfoExample();
        List<Info> infoList=infoMapper.selectByExampleWithBLOBs(infoExample);
        infoList.sort(Comparator.comparing(Info::getInfoDate));
        Collections.reverse(infoList);
        infoList = infoList.subList(0,5);
        //返回view model给前台
        List<InfoListView> infoListViews = new ArrayList<>();
        for(int i = 0;i<infoList.size();i++){
            InfoListView infoListView = new InfoListView();
            infoListView.setInfoId(infoList.get(i).getInfoId());
            long it = (long)infoList.get(i).getInfoDate()*1000;
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date1 = new Date(it);
            String res = sdf.format(date1);
            infoListView.setInfoDate(res);
            infoListView.setInfoTitle(infoList.get(i).getInfoTitle());
            infoListViews.add(infoListView);
        }
        return infoListViews;
    }

    @Override
    public Info findByInfoId(Integer infoId) {
        Info info = infoMapper.selectByPrimaryKey(infoId);
        return info;
    }
}
