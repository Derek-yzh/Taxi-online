package com.mashibing.cloudzuul.dao;

import com.mashibing.cloudzuul.entity.CommonGrayRule;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommonGrayRuleDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CommonGrayRule record);

    int insertSelective(CommonGrayRule record);

    CommonGrayRule selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CommonGrayRule record);

    int updateByPrimaryKey(CommonGrayRule record);
}