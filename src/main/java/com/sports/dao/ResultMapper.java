package com.sports.dao;

import com.sports.model.Result;
import com.sports.model.ResultExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ResultMapper {
    long countByExample(ResultExample example);

    int deleteByExample(ResultExample example);

    int deleteByPrimaryKey(Integer resId);

    int insert(Result record);

    int insertSelective(Result record);

    List<Result> selectByExample(ResultExample example);

    Result selectByPrimaryKey(Integer resId);

    int updateByExampleSelective(@Param("record") Result record, @Param("example") ResultExample example);

    int updateByExample(@Param("record") Result record, @Param("example") ResultExample example);

    int updateByPrimaryKeySelective(Result record);

    int updateByPrimaryKey(Result record);
}