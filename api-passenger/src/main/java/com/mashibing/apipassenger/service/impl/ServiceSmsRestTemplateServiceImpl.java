package com.mashibing.apipassenger.service.impl;

import com.mashibing.apipassenger.service.ServiceSmsRestTemplateService;
import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.internalcommon.dto.serviceSms.SmsTemplateDto;
import com.mashibing.internalcommon.dto.serviceSms.request.SmsSendRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: Derek
 * @DateTime: 2020/11/1 15:04
 * @Description: 短信服务远程调用模板
 */
@Service
public class ServiceSmsRestTemplateServiceImpl implements ServiceSmsRestTemplateService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ResponseResult sendSms(String phoneNumber, String code) {

        String http = "http://";
        String serviceName = "SERVICE-SMS";
        String uri = "/send/sms-template";

        String url = http + serviceName + uri;
        SmsSendRequest smsSendRequest = new SmsSendRequest();
        String[] phoneNumbers = new String[] {phoneNumber};
        smsSendRequest.setReceivers(phoneNumbers);

        List<SmsTemplateDto> data = new ArrayList<>();
        SmsTemplateDto dto = new SmsTemplateDto();
        dto.setId("SMS_144145499");
        int templateSize = 1;
        HashMap<String, Object> templateMap = new HashMap<>(templateSize);
        templateMap.put("code",code);
        dto.setTemplateMap(templateMap);
        data.add(dto);

        smsSendRequest.setData(data);
        return restTemplate.postForEntity(url,smsSendRequest,ResponseResult.class).getBody();
    }
}
