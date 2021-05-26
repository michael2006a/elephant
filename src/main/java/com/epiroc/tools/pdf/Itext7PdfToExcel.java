package com.epiroc.tools.pdf;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.canvas.parser.PdfDocumentContentParser;
import com.itextpdf.kernel.pdf.canvas.parser.listener.SimpleTextExtractionStrategy;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author : Herbert Yin
 * @version : V1.0
 * @project : cat
 * @file : Itext7PdfToExcel.java
 * @description : TODO
 * @date : 2020/3/13 13:22
 * @Copyright : 2020 Epiroc Trading Co., Ltd. All rights reserved.
 */
public class Itext7PdfToExcel {

    private static final Logger logger = LoggerFactory.getLogger(Itext7PdfToExcel.class);


    public static void main (String[] args) {
        Itext7PdfToExcel itext7PdfToExcel = new Itext7PdfToExcel();
        itext7PdfToExcel.load();
    }

    public void load () {
        PdfReader reader;

        try {
            reader = new PdfReader("D:\\pdf\\I20190000159516081.pdf");

            PdfDocument pdfDocument = new PdfDocument(reader);
            PdfDocumentContentParser parser = new PdfDocumentContentParser(pdfDocument);
            SimpleTextExtractionStrategy strategy;

            String line = null;
//    for (int i = 1; i <= reader.get; i++) {
            strategy = parser.processContent(1, new SimpleTextExtractionStrategy());
            line = strategy.getResultantText();
            System.out.println("line --- " + line);
//    }

//conversion starts here....

//    HSSFRow myRow = null;
//    HSSFCell myCell = null;
//    CreationHelper helper = myWorkBook.getCreationHelper();
            List<String> lines = IOUtils.readLines(new StringReader(line));

//    for (int i = 0; i < lines.size(); i++) {
//      String str[] = lines.get(i).split(",");
//      myRow = mySheet.createRow((short) i);
//      for (int j = 0; j < str.length; j++) {
//        myRow.createCell(j).setCellValue(helper.createRichTextString(str[j]));
//      }
//    }

//    FileOutputStream fileOut;
//    try {
//      fileOut = new FileOutputStream("D:/JDEV_WORK/MANOJ/ItemPriceExcel.xls");
//      myWorkBook.write(fileOut);
//      fileOut.close();
//    } catch (FileNotFoundException e) {
//      System.out.println("FILE NOT FOUND");
//    }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
