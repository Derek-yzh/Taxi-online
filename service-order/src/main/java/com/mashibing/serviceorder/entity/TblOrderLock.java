package com.mashibing.serviceorder.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * tbl_order_lock
 * @author 
 */
@Data
public class TblOrderLock implements Serializable {
    private Integer orderId;

    private Integer driverId;

    private static final long serialVersionUID = 1L;
}