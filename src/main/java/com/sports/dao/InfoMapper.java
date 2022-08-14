package com.sports.dao;

import com.sports.model.Info;
import com.sports.model.InfoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface InfoMapper {
    long countByExample(InfoExample example);

    int deleteByExample(InfoExample example);

    int deleteByPrimaryKey(Integer infoId);

    int insert(Info record);

    int insertSelective(Info record);

    List<Info> selectByExampleWithBLOBs(InfoExample example);

    List<Info> selectByExample(InfoExample example);

    Info selectByPrimaryKey(Integer infoId);

    int updateByExampleSelective(@Param("record") Info record, @Param("example") InfoExample example);

    int updateByExampleWithBLOBs(@Param("record") Info record, @Param("example") InfoExample example);

    int updateByExample(@Param("record") Info record, @Param("example") InfoExample example);

    int updateByPrimaryKeySelective(Info record);

    int updateByPrimaryKeyWithBLOBs(Info record);

    int updateByPrimaryKey(Info record);
}