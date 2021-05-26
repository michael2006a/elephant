package com.epiroc.tools.translate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author : Herbert Yin
 * @version : V1.0
 * @project : elephant
 * @file : TranslateJson.java
 * @description : TODO
 * @date : 2021/5/15 20:57
 * @Copyright : 2021 Epiroc Trading Co., Ltd. All rights reserved.
 */
public class TranslateJson {

    private static final Logger logger = LoggerFactory.getLogger(TranslateJson.class);

    public static void main (String[] args) {
        String test = "D:\\50git\\elephant\\src\\main\\resources\\data\\testJson.json";
        String emergencyEn = "D:\\50git\\elephant\\src\\main\\resources\\data\\emergency_app_en.json";
        String emergencyZh = "D:\\50git\\elephant\\src\\main\\resources\\data\\emergency_app_zh_google.json";

        String scheduler_en = "D:\\50git\\elephant\\src\\main\\resources\\data\\scheduler_en.json";
        String scheduler_zh = "D:\\50git\\elephant\\src\\main\\resources\\data\\scheduler_zh_google.json";

        TranslateJson translateJson = new TranslateJson();
        JSONObject jsonObject = translateJson.loadFile(emergencyEn);
        translateJson.translate(jsonObject);
        try {
            FileUtils.write(new File(emergencyZh), jsonObject.toJSONString(), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private JSONObject loadFile (String fileName) {
        JSONObject jsonObject = new JSONObject();
        try {
            String jsonStr = FileUtils.readFileToString(new File(fileName), "UTF-8");
            jsonObject = JSON.parseObject(jsonStr);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    private void translate (JSONObject jsonObject) {
        Set<String> keySet = jsonObject.keySet();

        for (String key : keySet) {
            if (jsonObject.get(key) instanceof JSONObject) {
                translate(jsonObject.getJSONObject(key));
            } else {
                String value = jsonObject.getString(key);
                try {
                    String transStr = GoogleApi.translate(value);
                    System.out.println(key + "=" + transStr);
                    jsonObject.put(key, transStr);
                    int numSecond = (int) (30000 + Math.random() * 40000);
                    Thread.sleep(numSecond);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

//        Object value = jsonObject.get("ddd") instanceof JSONObject ? ((JSONObject) jsonObject
//                .getJSONObject("ddd")) : jsonObject.getString("ddd");
//        System.out.println(keySet.toString());
    }

}
