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
 * @Description: TODO
 */
@Component
public class ProduceTask {

    @Autowired
    private TblOrderEventDao tblOrderEventDao;

    @Autowired
    private Queue queue;

    @Autowired
    JmsMessagingTemplate jmsMessagingTemplate;

    @Scheduled(cron = "0/5 * * * * ?")
    @Transactional(rollbackFor = Exception.class)
    public void task(){
        System.out.println("定时任务");

        List<TblOrderEvent> orderEvents = tblOrderEventDao.selectByOrderType("1");
        for (int i = 0; i < orderEvents.size(); i++) {
            TblOrderEvent event = orderEvents.get(i);

            tblOrderEventDao.updateEvent(event.getId());
            System.out.println("修改数据库完成");

            jmsMessagingTemplate.convertAndSend(queue, JSONObject.fromObject(event).toString());

        }

    }

}
