package com.mashibing.serviceorder.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * tbl_order_lock
 * @author mysql做分布式锁使用的表
 */
@Data
public class TblOrderLock implements Serializable {
    private Integer orderId;

    private Integer driverId;

    private static final long serialVersionUID = 1L;
}