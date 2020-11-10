package com.mashibing.servicesms.controller;

import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.internalcommon.dto.serviceSms.request.SmsSendRequest;
import com.mashibing.servicesms.service.SmsService;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Derek
 * @DateTime: 2020/11/1 18:57
 * @Description: TODO
 */
@RestController
@RequestMapping("/send")
@Slf4j
public class SendController {

    @Autowired
    private SmsService smsService;

    @RequestMapping(value = "/sms-template",method = RequestMethod.POST)
    public ResponseResult send(@RequestBody SmsSendRequest smsSendRequest){
        //输出收到的参数内容
        JSONObject param = JSONObject.fromObject(smsSendRequest);
        log.info("/send/alisms-template   request："+param.toString());
        return smsService.sendSms(smsSendRequest);
    }

}
