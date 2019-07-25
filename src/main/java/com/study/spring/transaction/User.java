package com.study.spring.transaction;

import lombok.AllArgsConstructor;
import lombok.Data;

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
public class User {

    private int id;

    private String username;

    private int age;
}
