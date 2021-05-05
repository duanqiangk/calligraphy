package com.dqit.calligraphy.common.config;

/**
 * @Author qiang.duan
 * @Date 2021/1/17 19:38
 * @Description  微信后台信息通用配置类
 */
public class WxInfoConfig {
    private static final String CET_READ_APP_ID = "wx9b330b062433a9b0";
    private static final String CET_READ_APP_SECRET = "ade13f580ae134ceb3d34004f17dd4dc";
    private static final String CET_READ_GRANT_TYPE = "authorization_code";

    private static final String CET_LISTEN_APP_ID = "wx9ea4c8f83871d19d";
    private static final String CET_LISTEN_APP_SECRET = "a21898063a7623e2c5b3b2069a104372";
    private static final String CET_LISTEN_GRANT_TYPE = "authorization_code";

    private static final String YAN_APP_ID = "wx9ea4c8f83871d19d";
    private static final String YAN_APP_SECRET = "a21898063a7623e2c5b3b2069a104372";
    private static final String YAN_GRANT_TYPE = "authorization_code";

    /**
     * 获取小程序信息
     *
     * @param programCode 小程序编码
     * @return 小程序信息
     */
    public static ProgramConfig getProgramConfig(Integer programCode){
        switch (programCode){
            case 1: return new ProgramConfig(YAN_APP_ID,YAN_APP_SECRET,YAN_GRANT_TYPE);
            case 2: return new ProgramConfig(CET_READ_APP_ID,CET_READ_APP_SECRET,CET_READ_GRANT_TYPE);
            case 3: return new ProgramConfig(CET_LISTEN_APP_ID,CET_LISTEN_APP_SECRET,CET_LISTEN_GRANT_TYPE);
            default:{
                return null;
            }
        }
    }
}
