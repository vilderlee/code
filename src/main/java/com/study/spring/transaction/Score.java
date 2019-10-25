package com.study.spring.transaction;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/7/18      Create this file
 * </pre>
 */
@Data
@AllArgsConstructor
public class Score implements Serializable {
    private static final long serialVersionUID = -6942695260855833047L;
    private int id;

    private int userID;
}
