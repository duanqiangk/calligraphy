package com.dqit.calligraphy.util;

import java.security.MessageDigest;

/**
 * @Author qiang.duan
 * @Date 2021/2/18 17:30
 * @Description
 */
public class Md5 {
    public Md5() {
    }

    public static String getMD5(String string) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] result = md.digest(string.getBytes());
            StringBuffer sb = new StringBuffer();
            byte[] var4 = result;
            int var5 = result.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                byte b = var4[var6];
                int sign = b & 255;
                String str = Integer.toHexString(sign);
                if (str.length() == 1) {
                    sb.append("0");
                }

                sb.append(str);
            }

            return sb.toString();
        } catch (Exception var10) {
            var10.printStackTrace();
            return "";
        }
    }
}
