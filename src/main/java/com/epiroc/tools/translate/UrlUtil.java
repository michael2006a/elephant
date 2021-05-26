package com.epiroc.tools.translate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author : Herbert Yin
 * @version : V1.0
 * @project : elephant
 * @file : UrlUtil.java
 * @description : TODO
 * @date : 2021/5/12 16:30
 * @Copyright : 2021 Epiroc Trading Co., Ltd. All rights reserved.
 */
public class UrlUtil {

    private static final Logger logger = LoggerFactory.getLogger(UrlUtil.class);

    public static String encodeStr (String keys) {
        String replaceSpace = keys.replaceAll(" ", "%20");
        String repalceDoubleQuotes = replaceSpace.replaceAll("\"", "%22");
        return repalceDoubleQuotes;
    }
}
