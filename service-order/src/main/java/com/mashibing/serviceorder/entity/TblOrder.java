package com.mashibing.serviceorder.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * tbl_order
 * @author 
 */
@Data
public class TblOrder implements Serializable {
    private Integer orderId;

    private Integer orderStatus;

    private static final long serialVersionUID = 1L;
}