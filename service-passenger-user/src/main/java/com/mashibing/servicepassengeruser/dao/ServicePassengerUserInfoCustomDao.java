package com.mashibing.servicepassengeruser.dao;

import com.mashibing.servicepassengeruser.entity.ServicePassengerUserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: Derek
 * @DateTime: 2020/11/1 20:51
 * @Description: TODO
 */
@Mapper
public interface ServicePassengerUserInfoCustomDao extends ServicePassengerUserInfoDao{

    /**
     * 根据手机号查询乘客信息
     * @param passengerPhone
     * @return
     */
    ServicePassengerUserInfo selectByPhoneNumber(String passengerPhone);

}
