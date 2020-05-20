package com.epiroc.tools.excel;

import java.io.File;
import java.util.Date;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

/**
 * @author : Herbert Yin
 * @version : V1.0
 * @project : tools
 * @file : TestReadExcel.java
 * @description : TODO
 * @date : 2020/4/13 15:20
 * @Copyright : 2020 Epiroc Trading Co., Ltd. All rights reserved.
 */
public class TestReadExcel {

  public static void main(String[] args) throws Exception {

    ReadExcel re = new ReadExcel();
    //忽略前5行
    List<List<String>> list = re.read("D:\\excel\\repair.xlsx", 1);

    // 遍历读取结果
    if (list != null) {
      for (int i = 0; i < list.size(); i++) {
        StringBuilder stringBuilder = new StringBuilder();
       List<String> cellList = list.get(i);
        for (int j = 0; j < cellList.size(); j++) {
          if(j==1){
            stringBuilder.append(cellList.get(j)).append(",");
          }
          if(j==4){
            Date date = DateUtils.parseDate(cellList.get(j),"dd-mm-yyyy");
            stringBuilder.append(DateFormatUtils.format(date,"yyyy/mm/dd")).append(",");
          }
          if(j==5){
            stringBuilder.append(cellList.get(j)).append("\n");
          }
        }
        System.out.println();
        FileUtils.write(new File("D:\\excel\\repair.csv"),stringBuilder.toString(),"UTF-8",true);
      }
    }
  }


}
