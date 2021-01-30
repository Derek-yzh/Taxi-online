package com.mashibing.serviceorder.lock;

import com.mashibing.serviceorder.dao.TblOrderLockDao;
import com.mashibing.serviceorder.entity.TblOrderLock;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Author: Derek
 * @DateTime: 2020/11/16 13:50
 * @Description: mysql锁
 */
@Service
@Data
public class MysqlLock implements Lock {

    @Autowired
    private TblOrderLockDao mapper;

    private ThreadLocal<TblOrderLock> orderLockThreadLocal;

    @Override
    public void lock() {
        //1.尝试加锁
        if (tryLock()){
            System.out.println("尝试加锁");
            return;
        }
        //2.休眠
        try {TimeUnit.MILLISECONDS.sleep(10);} catch (InterruptedException e) {e.printStackTrace();}
        //3.递归再次调用
        lock();
    }

    /**
     *  非阻塞式加锁，成功就成功，失败就失败。直接返回
     * @return
     */
    @Override
    public boolean tryLock() {
        try {
            TblOrderLock tblOrderLock = orderLockThreadLocal.get();

            mapper.insertSelective(tblOrderLock);
            System.out.println("枷锁对象："+orderLockThreadLocal.get());
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public void unlock() {
        mapper.deleteByPrimaryKey(orderLockThreadLocal.get().getOrderId());
        System.out.println("解锁对象："+orderLockThreadLocal.get());
        orderLockThreadLocal.remove();
    }


    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public Condition newCondition() {
        return null;
    }

}
