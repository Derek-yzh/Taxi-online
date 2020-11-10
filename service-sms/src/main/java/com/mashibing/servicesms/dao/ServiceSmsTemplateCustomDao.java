package com.mashibing.servicesms.dao;

import com.mashibing.servicesms.entity.ServiceSmsTemplate;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: Derek
 * @DateTime: 2020/11/1 19:08
 * @Description: TODO
 */
@Mapper
public interface ServiceSmsTemplateCustomDao extends ServiceSmsTemplateDao{

    ServiceSmsTemplate selectByTemplateId(String templateId);

}
