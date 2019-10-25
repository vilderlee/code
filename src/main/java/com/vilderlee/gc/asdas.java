package com.vilderlee.gc;

import com.alibaba.druid.util.StringUtils;
import org.apache.commons.collections.map.HashedMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/10/15      Create this file
 * </pre>
 */
public class asdas {
    public static void main(String[] args) {

        Map<String, String> dbSystemParameterMap = new HashMap();

        dbSystemParameterMap.put("1770", "13");

        Map<String, String> sysParameterRefreshRecordMap = new HashMap();

        sysParameterRefreshRecordMap.put("1770", "14");

        Map<String, String> refreshMap = new HashMap();

        for (Map.Entry<String, String> entry : dbSystemParameterMap.entrySet()) {
            String codeOfRecord = sysParameterRefreshRecordMap.get(entry.getKey());
            if (StringUtils.isEmpty(codeOfRecord)) {
                refreshMap.put(entry.getKey(), entry.getValue());
            } else if (entry.getValue().compareTo(codeOfRecord) != 0) {
                refreshMap.put(entry.getKey(), entry.getValue());
            }
        }
        List<String> list = new ArrayList<>(refreshMap.keySet());
        System.out.println(list);
    }
}
