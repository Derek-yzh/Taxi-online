package com.mashibing.lncpay.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * lcn_pay
 * @author 
 */
@Data
public class LcnPay implements Serializable {
    private Integer id;

    private String payName;

    private static final long serialVersionUID = 1L;
}