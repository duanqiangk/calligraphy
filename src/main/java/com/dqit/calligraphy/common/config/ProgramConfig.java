package com.dqit.calligraphy.common.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author qiang.duan
 * @Date 2021/1/17 19:57
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProgramConfig implements Serializable {
    private String appId;
    private String appSecret;
    private String grantType;
}