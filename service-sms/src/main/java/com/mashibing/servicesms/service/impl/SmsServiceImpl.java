package com.mashibing.servicesms.service.impl;

import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.internalcommon.dto.serviceSms.SmsTemplateDto;
import com.mashibing.internalcommon.dto.serviceSms.request.SmsSendRequest;
import com.mashibing.servicesms.constant.SmsStatusEnum;
import com.mashibing.servicesms.dao.ServiceSmsRecordDao;
import com.mashibing.servicesms.dao.ServiceSmsTemplateCustomDao;
import com.mashibing.servicesms.entity.ServiceSmsRecord;
import com.mashibing.servicesms.entity.ServiceSmsTemplate;
import com.mashibing.servicesms.service.SmsService;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Derek
 * @DateTime: 2020/11/1 18:58
 * @Description: TODO
 */
@Service
@Slf4j
@SuppressWarnings("all")
public class SmsServiceImpl implements SmsService {

    //缓存用于替换内容的模板
    private Map<String,String> templateMaps = new HashMap<>();

    @Autowired
    private ServiceSmsTemplateCustomDao serviceSmsTemplateCustomDao;

    @Autowired
    private ServiceSmsRecordDao serviceSmsRecordDao;

    @Override
    public ResponseResult sendSms(SmsSendRequest request) {
        log.info(request.toString());
/*        for (String phoneNumber : request.getReceivers()) {
            List<SmsTemplateDto> templates = request.getData();

            ServiceSmsRecord sms = new ServiceSmsRecord();
            sms.setPhoneNumber(phoneNumber);

            for (SmsTemplateDto template : templates) {
                if (!templateMaps.containsKey(template.getId())){
                    //此处注释掉的内容为，将db模板加载到内存
                    ServiceSmsTemplate t = serviceSmsTemplateCustomDao.selectByTemplateId(template.getId());
                    System.out.println(t.getTemplateContent());
                    templateMaps.put(template.getId(),t.getTemplateContent());
                }

                //替换占位符
                String content = templateMaps.get(template.getId());
                for (Map.Entry<String, Object> entry : template.getTemplateMap().entrySet()) {
                    content = StringUtils.replace(content,"${"+entry.getKey()+"}",""+entry.getValue());
                }

                //发生错误时，不影响其他手机号和模板的发送
                try {
                    int result = send(phoneNumber,template.getId(),template.getTemplateMap());

                    //组装SMS对象
                    sms.setSendTime(new Date());
                    sms.setOperatorName("");
                    sms.setSendFlag(1);
                    sms.setSendNumber(0);
                    sms.setSmsContent(content);

                    if (result != SmsStatusEnum.SEND_SUCCESS.getCode()){
                        throw new Exception("短信发送失败");
                    }
                }catch (Exception e){
                    sms.setSendFlag(0);
                    sms.setSendNumber(1);
                    log.error("发送短信（" + template.getId() + "）失败：" + phoneNumber, e);
                }finally {
                    sms.setCreateTime(new Date());
                    serviceSmsRecordDao.insert(sms);
                }

            }
        }*/

        return ResponseResult.success("");
    }

    private int send(String phoneNumber, String templateId, Map<String, ?> templateMap) throws Exception {
        JSONObject param = new JSONObject();
        param.putAll(templateMap);

        return sendMsg(phoneNumber,templateId,param.toString());
    }

    private int sendMsg(String phoneNumber, String templateId, String toString) {
        /**
         *  供应商 发 短信
         */
        return SmsStatusEnum.SEND_SUCCESS.getCode();
    }
}
