package com.mashibing.serviceorder.task;

import com.mashibing.serviceorder.dao.TblOrderEventDao;
import com.mashibing.serviceorder.entity.TblOrderEvent;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.jms.Queue;
import java.util.List;

/**
 * @Author: Derek
 * @DateTime: 2020/11/9 13:27
 * @Description: 分布式事务  消息队列+定时任务+本地事件表：定时任务
 */
@Component
@SuppressWarnings("all")
public class ProduceTask {

    @Autowired
    private TblOrderEventDao tblOrderEventDao;

    @Autowired
    private Queue queue;

    @Autowired
    JmsMessagingTemplate jmsMessagingTemplate;

    //@Scheduled(cron = "0/5 * * * * ?")//定时任务
    @Transactional(rollbackFor = Exception.class)//本地事务
    public void task(){
        System.out.println("定时任务");

        List<TblOrderEvent> orderEvents = tblOrderEventDao.selectByOrderType("1");
        for (int i = 0; i < orderEvents.size(); i++) {
            TblOrderEvent event = orderEvents.get(i);

            //将类型改为2
            tblOrderEventDao.updateEvent(event.getId());
            System.out.println("修改数据库完成");

            jmsMessagingTemplate.convertAndSend(queue, JSONObject.fromObject(event).toString());
        }
    }

}
