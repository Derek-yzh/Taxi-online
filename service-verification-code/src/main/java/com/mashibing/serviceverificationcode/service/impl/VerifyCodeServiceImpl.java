package com.mashibing.serviceverificationcode.service.impl;

import com.mashibing.internalcommon.constant.CommonStatusEnum;
import com.mashibing.internalcommon.constant.IdentityConstant;
import com.mashibing.internalcommon.constant.RedisKeyPrefixConstant;
import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.internalcommon.dto.serviceVerificationCode.response.VerifyCodeResponse;
import com.mashibing.serviceverificationcode.service.VerifyCodeService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author: Derek
 * @DateTime: 2020/10/31 20:56
 * @Description: TODO
 */
@Service
public class VerifyCodeServiceImpl implements VerifyCodeService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public ResponseResult<VerifyCodeResponse> generate(int identity, String phoneNumber) {
        //校验 发送时限，三挡验证，不能无限制发短信
        checkSendCodeTimeLimit(phoneNumber);

        // 0.9*9=8.1+1 9,去掉首位为0的情况。 0.11225478552211(0.0-<1)
        String code = String.valueOf((int)( (Math.random()*9+1)*Math.pow(10,5)));

        //生成redis key
        String keyPre = generateKeyPreByIdentity(identity);
        String key = keyPre + phoneNumber;
        //存redis，2分钟过期
        BoundValueOperations<String, String> codeRedis = redisTemplate.boundValueOps(key);
        codeRedis.set(code,2, TimeUnit.MINUTES);

        //返回
        VerifyCodeResponse data = new VerifyCodeResponse();
        data.setCode(code);
        return ResponseResult.success(data);
    }

    private ResponseResult checkSendCodeTimeLimit(String phoneNumber) {
        //判断是否有 限制1分钟，10分钟，24小时。

        return ResponseResult.success("");
    }

    @Override
    public ResponseResult verify(int identity, String phoneNumber, String code) {
        //三档验证

        //生成redis key
        String keyPre = generateKeyPreByIdentity(identity);
        String key = keyPre + phoneNumber;
        BoundValueOperations<String, String> codeRedis = redisTemplate.boundValueOps(key);
        String redisCode = codeRedis.get();

        if (StringUtils.isNotBlank(code)
                && code.trim().equals(redisCode.trim())){
            return ResponseResult.success("");
        }else {
            return ResponseResult.fail(CommonStatusEnum.VERIFY_CODE_ERROR.getCode(),CommonStatusEnum.VERIFY_CODE_ERROR.getValue());
        }
    }

    /**
     * 根据身份类型生成对应的缓存key
     * @param identity
     * @return
     */
    private String generateKeyPreByIdentity(int identity) {
        String keyPre = "";
        if(identity == IdentityConstant.PASSENGER){
            keyPre = RedisKeyPrefixConstant.PASSENGER_LOGIN_CODE_KEY_PRE;
        }else if (identity == IdentityConstant.DRIVER){
            keyPre = RedisKeyPrefixConstant.DRIVER_LOGIN_CODE_KEY_PRE;
        }
        return keyPre;
    }
}
