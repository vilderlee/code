package com.vilderlee.quartz.entity;

import lombok.Data;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/3/29      Create this file
 * </pre>
 */
@Data
public class ProcessControl {

    private Integer depositMode;
    private String institutionID;
    private String cutOffDate;
    private Integer step;
    private String status;


}
