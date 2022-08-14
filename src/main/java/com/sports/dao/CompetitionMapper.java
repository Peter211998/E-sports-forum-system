package com.sports.dao;

import com.sports.model.Competition;
import com.sports.model.CompetitionExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CompetitionMapper {
    long countByExample(CompetitionExample example);

    int deleteByExample(CompetitionExample example);

    int deleteByPrimaryKey(Integer compeId);

    int insert(Competition record);

    int insertSelective(Competition record);

    List<Competition> selectByExample(CompetitionExample example);

    Competition selectByPrimaryKey(Integer compeId);

    int updateByExampleSelective(@Param("record") Competition record, @Param("example") CompetitionExample example);

    int updateByExample(@Param("record") Competition record, @Param("example") CompetitionExample example);

    int updateByPrimaryKeySelective(Competition record);

    int updateByPrimaryKey(Competition record);
}