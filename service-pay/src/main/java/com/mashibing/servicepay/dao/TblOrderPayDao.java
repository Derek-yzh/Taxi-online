package com.mashibing.servicepay.dao;

import com.mashibing.servicepay.entity.TblOrderPay;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TblOrderPayDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TblOrderPay record);

    int insertSelective(TblOrderPay record);

    TblOrderPay selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TblOrderPay record);

    int updateByPrimaryKey(TblOrderPay record);
}