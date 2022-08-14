package com.sports.service;


import com.sports.model.Competition;
import com.sports.model.Info;
import com.sports.viewModel.CompetitionView;
import com.sports.viewModel.InfoListView;
import org.springframework.aop.target.LazyInitTargetSource;

import java.util.List;

public interface CompetitionService {
    //根据赛事id查询赛事
    public Competition findByCompetitionId(Integer competId);

    //根据游戏+赛季查找所有赛事
    public List<CompetitionView> findByCompeTypeAndCompeSeason(Integer compeType, Integer season);

    //新建赛事
    public Competition createNewCompe(String title,Integer compeType,Integer compeStatus,Integer hostScore,Integer guestScore,String videoUrl,Integer hostId,Integer guestId,Integer institution,Integer winTeam,Integer season,int[] result1,int[] result2,int[] result3,int[] result4,int[] result5);

    //新建赛事结果
    public int createNewResult(
            Integer compeId,Integer htGoal, Integer gtGoal, Integer htLdragon, Integer gtLdragon, Integer htSdragon, Integer gtSdragon, Integer htGold, Integer gtGold, Integer htGuard, Integer gtGuard, Integer tag, Integer isEnable);

    //查询最新的5条资讯
    public List<InfoListView> findNewInfos();

    //新增咨询(数据库)
    public int createInfo(String title,Integer authorId,Integer viewCnt,Integer likeCnt,String context,String apUrl);

    //新增资讯（redis）
    public int redisCreateInfoSubscriber(Integer id,String title,Integer authorId,Integer viewCnt,Integer likeCnt,String context,String apUrl);

    //根据infoId查询info详情
    public Info findByInfoId(Integer infoId);
}
