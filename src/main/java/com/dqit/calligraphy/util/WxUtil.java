package com.dqit.calligraphy.util;


import com.dqit.calligraphy.common.config.ProgramConfig;
import com.dqit.calligraphy.common.config.WxInfoConfig;
import lombok.Data;

import java.util.List;

/**
 * @Author qiang.duan
 * @Date 2021/1/17 19:34
 * @Description 微信后台操作
 */
public class WxUtil {

    /**
     * 发送网络请求以获取用户OPENID
     *
     * @param code 前端code
     * @param fromCode 小程序来源Code
     * @return 用户OpenId，获取失败获取NULL
     */
    public static String getUserOpenId(String code , Integer fromCode , String encryptedData , String iv){
        ProgramConfig programConfig = WxInfoConfig.getProgramConfig(fromCode);
        if(programConfig == null){
            return null;
        }

        String url = String.format("https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=%s",
                programConfig.getAppId(),programConfig.getAppSecret(),code,programConfig.getGrantType());
        List<String> wxResponse = NetWorkUtil.getRequest(url);
        if(wxResponse.size() == 1){
            WxResponse response = (WxResponse)JsonUtil.toObject(wxResponse.get(0) , WxResponse.class).toObject();
            return response.openid;
        }
        return null;
    }

    @Data
    private static class WxResponse{
        private String session_key ;
        private String openid;
    }
}
