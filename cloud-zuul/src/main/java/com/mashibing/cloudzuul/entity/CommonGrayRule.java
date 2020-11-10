package com.mashibing.cloudzuul.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * common_gray_rule
 * @author 
 */
@Data
public class CommonGrayRule implements Serializable {
    private Integer id;

    private Integer userId;

    private String serviceName;

    private String metaVersion;

    private static final long serialVersionUID = 1L;
}