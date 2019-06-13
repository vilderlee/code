package com.vilderlee.quartz.mapper;

import com.vilderlee.quartz.entity.ProcessControl;
import org.springframework.stereotype.Repository;

import java.util.Map;

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
@Repository("processControlDao")
public interface ProcessControlDao {


    ProcessControl getProcessControlByMap(Map map);

}
