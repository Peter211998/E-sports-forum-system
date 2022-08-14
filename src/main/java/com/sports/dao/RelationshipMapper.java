package com.sports.dao;

import com.sports.model.Relationship;
import com.sports.model.RelationshipExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RelationshipMapper {
    long countByExample(RelationshipExample example);

    int deleteByExample(RelationshipExample example);

    int deleteByPrimaryKey(Integer relaId);

    int insert(Relationship record);

    int insertSelective(Relationship record);

    List<Relationship> selectByExample(RelationshipExample example);

    Relationship selectByPrimaryKey(Integer relaId);

    int updateByExampleSelective(@Param("record") Relationship record, @Param("example") RelationshipExample example);

    int updateByExample(@Param("record") Relationship record, @Param("example") RelationshipExample example);

    int updateByPrimaryKeySelective(Relationship record);

    int updateByPrimaryKey(Relationship record);
}