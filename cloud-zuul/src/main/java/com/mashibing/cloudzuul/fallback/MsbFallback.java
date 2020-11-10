package com.mashibing.cloudzuul.fallback;

import com.mashibing.internalcommon.dto.ResponseResult;
import net.sf.json.JSONObject;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: Derek
 * @DateTime: 2020/11/5 16:45
 * @Description: 服务容错
 */
@Component
public class MsbFallback implements FallbackProvider {

    @Override
    public String getRoute() {
        return "*";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse() {
            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }

            @Override
            public InputStream getBody() throws IOException {
                //通用返回值结构一样 即ResponseResult
                //在此处也可以写降级代码 例如：{code:0,message:"",data:{1}} -> {code:0,message:"",data:{未知}}
                JSONObject json = JSONObject.fromObject(ResponseResult.fail(-100, "sd"));
                return new ByteArrayInputStream(json.toString().getBytes());
            }

            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.BAD_REQUEST;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return HttpStatus.BAD_REQUEST.value();
            }

            @Override
            public String getStatusText() throws IOException {
                return "message ";
            }

            @Override
            public void close() {

            }
        };
    }
}
