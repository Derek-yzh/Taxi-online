package com.mashibing.servicesms.constant;

import lombok.Getter;

/**
 * @Author: Derek
 * @DateTime: 2020/11/2 10:56
 * @Description: T第三方短信 错误码
 */
public enum  SmsStatusEnum {
    /**
     * 操作成功
     */
    SEND_SUCCESS(0, "sms send success"),

    /**
     * 操作异常
     */
    INTERNAL_SERVER_EXCEPTION(-1, "exception"),

    /**
     * 操作失败
     */
    SEND_FAIL(1, "sms send fail");

    @Getter
    private final int code;

    @Getter
    private final String value;

    private SmsStatusEnum(int code, String value) {
        this.code = code;
        this.value = value;
    }
}
