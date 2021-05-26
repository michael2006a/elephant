package com.epiroc.tools.translate;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author : Herbert Yin
 * @version : V1.0
 * @project : elephant
 * @file : TranslateFile.java
 * @description : TODO
 * @date : 2021/5/12 16:15
 * @Copyright : 2021 Epiroc Trading Co., Ltd. All rights reserved.
 */
public class TranslateFile {

    private static final Logger logger = LoggerFactory.getLogger(TranslateFile.class);


    public static void translateProperties (String inPath, String outPath) throws IOException {

        List<String> strList = FileUtils.readLines(new File(inPath), "UTF-8");
        List<String> outList = new ArrayList<String>(strList.size());

        for (String line : strList) {
            if (line.contains("=")) {
                String[] keyValue = line.split("=");
                String transStr = null;
                try {
                    transStr = GoogleApi.translate(keyValue[1]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String outStr = keyValue[0].concat("=").concat(transStr);
                logger.debug(outStr);
                System.out.println(outStr);
                outList.add(outStr);
                FileUtils.write(new File(outPath), outStr.concat("\n"), "UTF-8", true);
                int numSecond = (int) (30000 + Math.random() * 40000);
                try {
                    Thread.sleep(numSecond);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                outList.add(line);
                FileUtils.write(new File(outPath), line.concat("\n"), "UTF-8", true);
            }
        }
        //FileUtils.writeLines(new File(outPath), outList, "UTF-8");
    }

    public static void main (String[] args) {
        String sa_en = "D:\\50git\\elephant\\src\\main\\resources\\data\\sa_en.properties";
        String sa_zh = "D:\\50git\\elephant\\src\\main\\resources\\data\\sa_zh_google_0525.properties";
        try {
            translateProperties(sa_en, sa_zh);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
