package com.study.spring.propagation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/9/3      Create this file
 * </pre>
 */
@Service
public class OrderService {


    @Autowired
    private UserBuyDao userBuyDao;

    @Autowired
    private OrderDao orderDao;

    public void insertOrder(){

    }

}
