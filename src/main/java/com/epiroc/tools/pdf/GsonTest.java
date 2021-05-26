package com.epiroc.tools.pdf;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author : Herbert Yin
 * @version : V1.0
 * @project : elephant
 * @file : GsonTest.java
 * @description : TODO
 * @date : 2020/5/31 17:25
 * @Copyright : 2020 Epiroc Trading Co., Ltd. All rights reserved.
 */
public class GsonTest {

    private static final Logger logger = LoggerFactory.getLogger(GsonTest.class);

    public static void main (String[] args) throws IOException {

        Gson gson = new Gson();

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name", "xuanyouwu");
        jsonObject.addProperty("age", 26);

//    if(jsonObject instanceof Map){
//      System.out.println("fastJson is map");
//    }else {
//      System.out.println("fastJson is not map");
//    }
//
        JSONObject jsonObject1 = new JSONObject();
        if (jsonObject1 instanceof List) {
            System.out.println("fastJson is map");
        } else {
            System.out.println("fastJson is not map");
        }
    }

}
