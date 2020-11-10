package com.mashibing.servicesms.dao;

import com.mashibing.servicesms.entity.ServiceSmsRecord;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: Derek
 * @DateTime: 2020/11/1 19:18
 * @Description: TODO
 */
@Mapper
public interface ServiceSmsRecordDao {
    int deleteByPrimaryKey(Integer id);

    int insert(ServiceSmsRecord record);

    int insertSelective(ServiceSmsRecord record);

    ServiceSmsRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ServiceSmsRecord record);

    int updateByPrimaryKey(ServiceSmsRecord record);
}
