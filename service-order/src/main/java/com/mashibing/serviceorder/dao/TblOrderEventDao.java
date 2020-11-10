package com.mashibing.serviceorder.dao;

import com.mashibing.serviceorder.entity.TblOrderEvent;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TblOrderEventDao {

    int updateEvent(Integer id);

    /**
     * 根据订单类型查询订单事件表
     * @param orderType 订单类型
     * @return TblOrderEvent
     */
    List<TblOrderEvent> selectByOrderType(String orderType);

    int deleteByPrimaryKey(Integer id);

    int insert(TblOrderEvent record);

    int insertSelective(TblOrderEvent record);

    TblOrderEvent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TblOrderEvent record);

    int updateByPrimaryKey(TblOrderEvent record);
}