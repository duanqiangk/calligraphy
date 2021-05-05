package com.dqit.calligraphy.util;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class NetWorkUtil {
    public static List<String> getRequest(String path){
        List<String> result = Lists.newArrayList();
        try {
            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("GET");
            conn.connect();
            InputStream is = conn.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String str = "";

            while ((str = br.readLine()) != null) {
                str=new String(str.getBytes(),"UTF-8");
                result.add(str);
            }
            is.close();
            conn.disconnect();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public NetWorkUtil() {
    }

    private static String buildGetUrlString(String url, Map<String, String> paramMap) {
        StringBuilder stringBuilder = new StringBuilder(url);
        boolean first = true;
        Iterator var4 = paramMap.keySet().iterator();

        while(var4.hasNext()) {
            String key = (String)var4.next();
            String value = (String)paramMap.get(key);
            if (first) {
                stringBuilder.append("?");
                stringBuilder.append(key).append("=").append(value);
                first = false;
            } else {
                stringBuilder.append("&").append(key).append("=").append(value);
            }
        }

        return stringBuilder.toString();
    }

    public static String httpGetRequest(String url, Map<String, String> paramMap) {
        Preconditions.checkNotNull(url, "URL 为null");
        if (paramMap != null && !paramMap.isEmpty()) {
            url = buildGetUrlString(url, paramMap);
        }

        String result = null;

        try {
            URL urlObject = new URL(url);
            HttpURLConnection httpURLConnection = (HttpURLConnection)urlObject.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setReadTimeout(60000);
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == 200) {
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                StringBuilder stringBuilder = new StringBuilder();

                String temp;
                while((temp = bufferedReader.readLine()) != null) {
                    stringBuilder.append(temp);
                }

                result = stringBuilder.toString();
            }
        } catch (IOException var9) {
            var9.printStackTrace();
        }

        return result;
    }
}
