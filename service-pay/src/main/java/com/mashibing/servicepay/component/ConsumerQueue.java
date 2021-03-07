package com.mashibing.servicepay.component;

import com.mashibing.servicepay.dao.TblOrderPayDao;
import com.mashibing.servicepay.entity.TblOrderPay;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * @Author: Derek
 * @DateTime: 2020/11/9 15:08
 * @Description: ConsumerQueue
 */
@Component
@SuppressWarnings("all")
public class ConsumerQueue {

    @Autowired
    private TblOrderPayDao tblOrderPayDao;

    @JmsListener(destination = "ActiveMQQueue",containerFactory = "jmsListenerContainerFactory")
    public void receive(TextMessage textMessage, Session session) throws JMSException {
        try {
            System.out.println("收到的消息为："+textMessage.getText());
            String content = textMessage.getText();

            TblOrderPay tblOrderPay = (TblOrderPay) JSONObject.toBean(JSONObject.fromObject(content), TblOrderPay.class);
            tblOrderPayDao.insert(tblOrderPay);
            //业务完成 确认消息消费成功
            textMessage.acknowledge();
        }catch (Exception e){
            e.printStackTrace();
            //e.getMessage(); 放到log中
            System.out.println("异常了...");
            session.recover();
        }
    }

    /**
     * 补偿处理。 根据业务需求调整
     * @param text
     */
    @JmsListener(destination = "DLQ.ActiveMQQueue")
    public void receive2(String text){
        System.out.println("死信队列："+text);
    }

}
