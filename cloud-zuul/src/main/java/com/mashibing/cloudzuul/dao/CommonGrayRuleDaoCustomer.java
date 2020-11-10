package com.mashibing.cloudzuul.dao;

import com.mashibing.cloudzuul.entity.CommonGrayRule;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @Author: Derek
 * @DateTime: 2020/11/4 9:50
 * @Description: TODO
 */
@Mapper
public interface CommonGrayRuleDaoCustomer extends CommonGrayRuleDao{

    CommonGrayRule selectByUserId(Integer userId);

}
