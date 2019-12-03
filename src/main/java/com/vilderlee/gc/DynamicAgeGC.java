package com.vilderlee.gc;

/**
 * 功能描述: -Xmn10m -Xmx20m -Xms20m -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15 -XX:+PrintGCDetails
 *
 * @package com.vilderlee.gc
 * @auther vilderlee
 * @date 2019/11/26 11:12 下午
 */
public class DynamicAgeGC {

    private static final int _1m = 1024 * 1024;

    public static void main(String[] args) {
        byte[] bytes1 = new byte[_1m / 2];
        byte[] bytes2 = new byte[_1m / 2];
        byte[] bytes3 = new byte[_1m * 4];
        byte[] bytes4 = new byte[_1m * 4];
        bytes4 = null;
        bytes4 = new byte[_1m * 4];

    }

}
