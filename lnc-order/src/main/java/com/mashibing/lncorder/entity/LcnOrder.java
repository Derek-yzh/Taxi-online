package com.mashibing.lncorder.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * lcn_order
 * @author 
 */
@Data
public class LcnOrder implements Serializable {
    private Integer id;

    private String orderName;

    private static final long serialVersionUID = 1L;
}