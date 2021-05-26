package com.epiroc.tools.translate;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.net.URLEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author : Herbert Yin
 * @version : V1.0
 * @project : elephant
 * @file : GoogleApi.java
 * @description : TODO
 * @date : 2021/5/12 14:04
 * @Copyright : 2021 Epiroc Trading Co., Ltd. All rights reserved.
 */
public class GoogleApi {

    private static final Logger logger = LoggerFactory.getLogger(GoogleApi.class);

    private static final String baseUrl = "http://translate.google.cn/translate_a/single?client=gtx&dt=t&dj=1&ie=UTF-8&sl=auto&tl=zh_CN&q=";

    public static String translate (String key) throws Exception {

        String resultStr = "";
        String url = baseUrl.concat(URLEncoder.encode(key, "UTF-8"));
        String result = HttpClient4.doGet(url);

        JSONObject jsonObject = JSONObject.parseObject(result);
//        if (jsonObject.getFloat("confidence") > 0.8) {
        JSONArray jsonArray = jsonObject.getJSONArray("sentences");
        JSONObject innerJson = jsonArray.getJSONObject(0);
        resultStr = innerJson.getString("trans");
//        } else {
//            resultStr = "请手工翻译";
//        }
        return resultStr;
    }

    public static void main (String[] args) {
        String key = "test";

        try {
            String translate = GoogleApi.translate(key);
            System.out.println(translate);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
