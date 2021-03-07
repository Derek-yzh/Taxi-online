package com.mashibing.internalcommon.dto.serviceSms.request;

import com.mashibing.internalcommon.dto.serviceSms.SmsTemplateDto;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: Derek
 * @DateTime: 2020/11/1 15:56
 * @Description:
 */
@Data
public class SmsSendRequest {

    private String[] receivers;
    private List<SmsTemplateDto> data;

    @Override
    public String toString() {
        return "SmsSendRequest [reveivers=" + Arrays.toString(receivers) + ", data=" + data + "]";
    }

}
