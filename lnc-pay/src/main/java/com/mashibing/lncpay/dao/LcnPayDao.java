package com.mashibing.lncpay.dao;

import com.mashibing.lncpay.entity.LcnPay;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LcnPayDao {
    int deleteByPrimaryKey(Integer id);

    int insert(LcnPay record);

    int insertSelective(LcnPay record);

    LcnPay selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LcnPay record);

    int updateByPrimaryKey(LcnPay record);
}