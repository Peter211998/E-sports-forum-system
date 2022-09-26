package com.sports.controller;

import com.sports.enumPackage.GameEnum;
import com.sports.model.Competition;
import com.sports.model.Info;
import com.sports.service.CompetitionService;
import com.sports.viewModel.CompetitionView;
import com.sports.viewModel.InfoListView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/competition")
public class CompetitionController {

    @Autowired
    private CompetitionService competitionService;

    @RequestMapping("/test")
    @ResponseBody
    public String test(String gameName) {

        //参数转换
        //parameter validation: 参数校验
        int type;
        if(gameName.equals(GameEnum.LOL.getName())){
            type = GameEnum.LOL.getType();
        }
        return null;
    }

    /**
     * 根据赛事类型和赛季选择比赛
     * @param compeType
     * @param season
     * @return
     */
    @RequestMapping("/findByTypeAndSeason")
    @ResponseBody
    public List<CompetitionView> findByTypeAndSeason(Integer compeType, Integer season){//todo:时间一致性,redis中只有部分赛事
        //参数校验

        //调用service层方法
        List<CompetitionView> competitionList = competitionService.findByCompeTypeAndCompeSeason(compeType,season);
        //拼接返回值
        if(competitionList==null)return null;
        return competitionList;
    }

    /**
     * 添加赛事
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
     * @return 0：添加失败 1：添加成功
     */
    @RequestMapping("/add")
    @ResponseBody
    public int addCompe(String title, Integer compeType, Integer compeStatus, Integer hostScore, Integer guestScore, String videoUrl, Integer hostId, Integer guestId, Integer institution, Integer winTeam, Integer season,Integer compeId1,Integer htGoal1, Integer gtGoal1, Integer htLdragon1, Integer gtLdragon1, Integer htSdragon1, Integer gtSdragon1, Integer htGold1, Integer gtGold1, Integer htGuard1, Integer gtGuard1, Integer tag1, Integer isEnable1,Integer compeId2,Integer htGoal2, Integer gtGoal2, Integer htLdragon2, Integer gtLdragon2, Integer htSdragon2, Integer gtSdragon2, Integer htGold2, Integer gtGold2, Integer htGuard2, Integer gtGuard2, Integer tag2, Integer isEnable2,Integer compeId3,Integer htGoal3, Integer gtGoal3, Integer htLdragon3, Integer gtLdragon3, Integer htSdragon3, Integer gtSdragon3, Integer htGold3, Integer gtGold3, Integer htGuard3, Integer gtGuard3, Integer tag3, Integer isEnable3,Integer compeId4,Integer htGoal4, Integer gtGoal4, Integer htLdragon4, Integer gtLdragon4, Integer htSdragon4, Integer gtSdragon4, Integer htGold4, Integer gtGold4, Integer htGuard4, Integer gtGuard4, Integer tag4, Integer isEnable4,Integer compeId5,Integer htGoal5, Integer gtGoal5, Integer htLdragon5, Integer gtLdragon5, Integer htSdragon5, Integer gtSdragon5, Integer htGold5, Integer gtGold5, Integer htGuard5, Integer gtGuard5, Integer tag5, Integer isEnable5) {
        //参数校验

        //参数转换
        int len = hostScore+guestScore;
        for(int i=0;i<len;i++){
            List<Integer> temp = new ArrayList<>();

            for(int j = 0;j<13;j++){

            }
        }
        int[] result1 = new int[13];
        result1[0] = compeId1;
        result1[1] = htGoal1;
        result1[2] = gtGoal1;
        result1[3] = htLdragon1;
        result1[4] = gtLdragon1;
        result1[5] =htSdragon1;
        result1[6] = gtSdragon1;
        result1[7] = htGold1;
        result1[8] = gtGold1;
        result1[9] =  htGuard1;
        result1[10] = gtGuard1;
        result1[11] = tag1;
        result1[12] = isEnable1;
        int[] result2 = new int[13];
        //0,0,0,0,0,0,0,0,0,0,0,0,0
        result2[0] = compeId2;
        result2[1] = htGoal2;
        result2[2] = gtGoal2;
        result2[3] = htLdragon2;
        result2[4] = gtLdragon2;
        result2[5] =htSdragon2;
        result2[6] = gtSdragon2;
        result2[7] = htGold2;
        result2[8] = gtGold2;
        result2[9] =  htGuard2;
        result2[10] = gtGuard2;
        result2[11] = tag2;
        result2[12] = isEnable2;
        int[] result3 = new int[13];;
        result3[0] = compeId3;
        result3[1] = htGoal3;
        result3[2] = gtGoal3;
        result3[3] = htLdragon3;
        result3[4] = gtLdragon3;
        result3[5] =htSdragon3;
        result3[6] = gtSdragon3;
        result3[7] = htGold3;
        result3[8] = gtGold3;
        result3[9] =  htGuard3;
        result3[10] = gtGuard3;
        result3[11] = tag3;
        result3[12] = isEnable3;
        int[] result4 =new int[13];;
        result4[0] = compeId4;
        result4[1] = htGoal4;
        result4[2] = gtGoal4;
        result4[3] = htLdragon4;
        result4[4] = gtLdragon4;
        result4[5] =htSdragon4;
        result4[6] = gtSdragon4;
        result4[7] = htGold4;
        result4[8] = gtGold4;
        result4[9] =  htGuard4;
        result4[10] = gtGuard4;
        result4[11] = tag4;
        result4[12] = isEnable4;
        int[] result5 = new int[13];;
        result5[0] = compeId5;
        result5[1] = htGoal5;
        result5[2] = gtGoal5;
        result5[3] = htLdragon5;
        result5[4] = gtLdragon5;
        result5[5] =htSdragon5;
        result5[6] = gtSdragon5;
        result5[7] = htGold5;
        result5[8] = gtGold5;
        result5[9] =  htGuard5;
        result5[10] = gtGuard5;
        result5[11] = tag5;
        result5[12] = isEnable5;
        //调用service层方法
        Competition competition = competitionService.createNewCompe(title,compeType,compeStatus,hostScore,guestScore,videoUrl,hostId,guestId,institution,winTeam,season,result1,result2,result3,result4,result5);
        if(competition!=null)return 1;//添加赛事成功
        return 0;//
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
    @RequestMapping("/addInfo")
    @ResponseBody
    public int createInfo(String title,Integer authorId,Integer viewCnt,Integer likeCnt,String context,String apUrl){
        //参数校验

        //调用service层方法
        int infoInsert = competitionService.createInfo(title,authorId,viewCnt,likeCnt,context,apUrl);
        return infoInsert;
    }

    /**
     * 查抄最新5条资讯
     * @return
     */
    @RequestMapping("/findNewestInfo")
    @ResponseBody
    public List<InfoListView> findNewInfos(){
        //参数校验和转换

        //调用Service层方法
        List<InfoListView> infoListViews = competitionService.findNewInfos();
        return infoListViews;
    }

    /**
     * 根据info id查找对应资讯
     * @param infoId
     * @return
     */
    @RequestMapping("/findInfoById")
    @ResponseBody
    public Info findByInfoId(Integer infoId){
        Info info = competitionService.findByInfoId(infoId);
        return info;
    }
}
