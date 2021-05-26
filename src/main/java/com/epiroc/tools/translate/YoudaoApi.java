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
 * @file : YoudaoApi.java
 * @description : TODO
 * @date : 2021/5/13 9:30
 * @Copyright : 2021 Epiroc Trading Co., Ltd. All rights reserved.
 */
public class YoudaoApi {

    private static final Logger logger = LoggerFactory.getLogger(YoudaoApi.class);

    private static final String baseUrl = "http://fanyi.youdao.com/translate?&doctype=json&type=EN2ZH_CN&i=";

    public static String translate (String key) throws Exception {

        String resultStr = "";
        String url = baseUrl.concat(URLEncoder.encode(key, "UTF-8"));
        String result = HttpClient4.doGet(url);
        JSONObject jsonObject = JSONObject.parseObject(result);
        JSONArray jsonArray = jsonObject.getJSONArray("translateResult");
        JSONObject innerJson = jsonArray.getJSONArray(0).getJSONObject(0);
        resultStr = innerJson.getString("tgt");
//        } else {
//            resultStr = "请手工翻译";
//        }
        return resultStr;
    }

    public static void main (String[] args) {
        String key = "test";

        try {
            String translate = YoudaoApi.translate(key);
            System.out.println(translate);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
