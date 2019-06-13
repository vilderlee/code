package com.vilderlee.collection.map;

import org.apache.commons.collections.map.HashedMap;

import java.util.Map;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/4/3      Create this file
 * </pre>
 */
public class Overwirte {

    static class Key{
        public Key(Integer id) {
            this.id = id;
        }

        private Integer id;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        //故意先注释掉equals和hashCode方法
        @Override public boolean equals(Object o) {
            if (null == o || !(o instanceof Key)) {
                return false;
            } else {
                return this.getId().equals(((Key) o).getId());
            }
        }
        @Override public int hashCode() {
            return id.hashCode();
        }
    }

    public static void main(String[] args) {
        Key key1 = new Key(1);
        Key key2 = new Key(1);
        Map map = new HashedMap();
        map.put(key1, "key1");
//        map.put(key2, "key2");

        System.out.println(map.get(key2));
    }

}
