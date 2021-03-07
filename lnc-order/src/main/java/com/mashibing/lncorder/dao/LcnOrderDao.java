package com.mashibing.lncorder.dao;

import com.mashibing.lncorder.entity.LcnOrder;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LcnOrderDao {
    int deleteByPrimaryKey(Integer id);

    int insert(LcnOrder record);

    int insertSelective(LcnOrder record);

    LcnOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LcnOrder record);

    int updateByPrimaryKey(LcnOrder record);
}