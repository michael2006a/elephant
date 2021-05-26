package com.epiroc.tools.excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author : Herbert Yin
 * @version : V1.0
 * @project : tools
 * @file : ExcelUtil.java
 * @description : TODO
 * @date : 2020/4/13 14:51
 * @Copyright : 2020 Epiroc Trading Co., Ltd. All rights reserved.
 */
public class ExcelUtil {

    private static final Logger logger = LoggerFactory.getLogger(ExcelUtil.class);


    public static List<List<String>> readExcle (String fileName) throws Exception {

        //new一个输入流
        FileInputStream inputStream = new FileInputStream(fileName);
        //new一个workbook
        HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
        //创建一个sheet对象，参数为sheet的索引
        HSSFSheet sheet = workbook.getSheetAt(0);
        //new出存放一张表的二维数组
        List<List<String>> allData = new ArrayList<List<String>>();

        for (Row row : sheet) {
            List<String> oneRow = new ArrayList<String>();
            //不读表头
            if (row.getRowNum() == 0) {
                continue;
            }

            for (Cell cell : row) {
                cell.setCellType(Cell.CELL_TYPE_STRING);
                oneRow.add(cell.getStringCellValue().trim());
            }
            allData.add(oneRow);
        }

        for (int i = 0; i < allData.size(); i++) {
            System.out.println(allData.get(i));
        }
        //关闭workbook
        workbook.close();
        return allData;
    }

    public static boolean writeExcel (List<List<String>> result, String[] sheetHead,
            String fileName) {
        //创建一个workbook对应一个excel
        HSSFWorkbook workbook = new HSSFWorkbook();
        //在workbook中创建一个sheet
        HSSFSheet sheet = workbook.createSheet();
        //在sheet中创建第0行
        HSSFRow row = sheet.createRow(0);

        //设置表头
        for (int i = 0; i < 10; i++) {
            row.createCell(i).setCellValue(sheetHead[i]);
        }
        //填写数据
        for (int i = 0; i < result.size(); i++) {
            HSSFRow row1 = sheet.createRow(i + 1);
            for (int j = 0; j < result.get(i).size(); j++) {
                row1.createCell(j).setCellValue(result.get(i).get(j));
            }
        }
        //写入文件
        try {
            FileOutputStream file = new FileOutputStream(fileName);
            workbook.write(file);
            workbook.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main (String[] args) throws Exception {
        List<List<String>> check = ExcelUtil.readExcle("D:\\excel\\check.xlsx");
        System.out.println(check.size());
    }

}
