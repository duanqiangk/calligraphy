package com.dqit.calligraphy.common.enums;

/**
 * @Author qiang.duan
 * @Date 2021/5/5 22:02
 * @Description 状态常量枚举
 */
public enum StatusEnum {
    /**
     * 默认值
     */
    NONE(0, "默认值"),
    /**
     * 生效
     */
    EFFECTIVE(1, "生效"),
    /**
     * 不生效
     */
    NO_EFFECTIVE(2, "不生效"),
    ;

    private int code;
    private String desc;

    StatusEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static StatusEnum codeOf(int code){
        StatusEnum result = NONE;
        switch (code){
            case 1 : result = EFFECTIVE ; break;
            case 2 : result = NO_EFFECTIVE ; break;
            default:{}
        }
        return result;
    }
}
