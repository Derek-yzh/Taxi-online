package com.mashibing.serviceorder.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * tbl_order_event
 * @author 
 */
@Data
public class TblOrderEvent implements Serializable {
    private Integer id;

    private String orderType;

    private String process;

    private String content;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;
}