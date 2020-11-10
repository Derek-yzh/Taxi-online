package com.mashibing.servicepay.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * tbl_order_pay
 * @author 
 */
@Data
public class TblOrderPay implements Serializable {
    private Integer id;

    private String orderType;

    private String process;

    private String content;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;
}