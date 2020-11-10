package com.mashibing.internalcommon.dto.serviceSms;

import lombok.Data;

import java.util.Map;

/**
 * @Author: Derek
 * @DateTime: 2020/11/1 15:59
 * @Description: TODO
 */
@Data
public class SmsTemplateDto {

    // 模板id
    private String id;

    // 参数  占位符
    private Map<String, Object> templateMap;

    @Override
    public String toString() {
        return "SmsTemplateDto [id=" + id + ", templateMap=" + templateMap + "]";
    }


}
