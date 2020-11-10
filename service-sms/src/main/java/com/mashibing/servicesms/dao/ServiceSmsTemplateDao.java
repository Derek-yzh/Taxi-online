package com.mashibing.servicesms.dao;

import com.mashibing.servicesms.entity.ServiceSmsTemplate;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: Derek
 * @DateTime: 2020/11/1 19:19
 * @Description: TODO
 */
@Mapper
public interface ServiceSmsTemplateDao {
    int deleteByPrimaryKey(Integer id);

    int insert(ServiceSmsTemplate record);

    int insertSelective(ServiceSmsTemplate record);

    ServiceSmsTemplate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ServiceSmsTemplate record);

    int updateByPrimaryKey(ServiceSmsTemplate record);
}
