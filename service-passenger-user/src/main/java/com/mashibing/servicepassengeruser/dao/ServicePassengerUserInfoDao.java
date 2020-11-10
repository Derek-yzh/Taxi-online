package com.mashibing.servicepassengeruser.dao;

import com.mashibing.servicepassengeruser.entity.ServicePassengerUserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: Derek
 * @DateTime: 2020/11/1 20:52
 * @Description: TODO
 */
@Mapper
public interface ServicePassengerUserInfoDao {

    int deleteByPrimaryKey(Long id);

    int insert(ServicePassengerUserInfo record);

    int insertSelective(ServicePassengerUserInfo record);

    ServicePassengerUserInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ServicePassengerUserInfo record);

    int updateByPrimaryKey(ServicePassengerUserInfo record);

}
