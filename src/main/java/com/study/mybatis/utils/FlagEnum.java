package com.study.mybatis.utils;

/**
 * 功能描述:
 *
 * @package com.study.mybatis.utils
 * @auther vilderlee
 * @date 2019-01-13 20:02
 */
public enum FlagEnum {
    /**
     * 存在
     */
    FLAG_TRUE(true, "存在"),

    /**
     * 不存在
     */
    FLAG_FALSE(false, "不存在");


    private boolean flag;
    private String des;

    FlagEnum(boolean flag, String des) {
        this.flag = flag;
        this.des = des;
    }

    public static FlagEnum getValue(boolean flag) {
        for (FlagEnum flagEnum : FlagEnum.values()) {
            if (flagEnum.flag == flag) {
                return flagEnum;
            }
        }

        return null;
    }


    public boolean isFlag() {
        return flag;
    }

    public String getDes() {
        return des;
    }}
