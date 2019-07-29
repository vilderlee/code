package com.vilderlee.design.commandchain;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/7/26      Create this file
 * </pre>
 */

@Documented
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface RiskCommand {

    /**
     * 风控名称
     *
     * @return
     */
    String RiskName();

    /**
     * 风控等级
     */
    RiskLevelEnum RiskLevel() default RiskLevelEnum.LEVEL_HIGH;

    /**
     * 风控优先级
     */
    int RiskPriority() default 1;

    enum RiskLevelEnum {
        LEVEL_HIGH(1, "高等级"), LEVEL_LOW(2, "低等级");
        private int value;

        private String desc;

        RiskLevelEnum(int value, String desc) {
            this.value = value;
            this.desc = desc;
        }

        public static RiskLevelEnum getInstance(int value){
            for (RiskLevelEnum em : RiskLevelEnum.values()) {
                if (em.getValue() == value) {
                    return em;
                }
            }
            return null;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }
}
