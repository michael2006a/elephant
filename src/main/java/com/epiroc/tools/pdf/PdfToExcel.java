package com.epiroc.tools.pdf;

import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.text.PDFTextStripper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author : Herbert Yin
 * @version : V1.0
 * @project : cat
 * @file : PdfToExcel.java
 * @description : TODO
 * @date : 2020/3/13 12:53
 * @Copyright : 2020 Epiroc Trading Co., Ltd. All rights reserved.
 */
public class PdfToExcel {

    private static final Logger logger = LoggerFactory.getLogger(PdfToExcel.class);

  /*// Load PDF document
  Document document = new Document("Test.pdf");
  // Instantiate ExcelSave Option object
  ExcelSaveOptions excelsave = new ExcelSaveOptions();
// Save the output to XLS format
document.save("ConvertedFile.xls", excelsave);*/

    public static void main (String[] args) {
        PdfToExcel pdfToExcel = new PdfToExcel();
        pdfToExcel.loadPdf();
    }

    public void loadPdf () {

        try {
            PDDocument document = PDDocument.load(new File("D:\\pdf\\I20190000159516081.pdf"));
            PDDocumentCatalog docCatalog = document.getDocumentCatalog();
            PDAcroForm acroForm = docCatalog.getAcroForm();
            PDFTextStripper textStripper = new PDFTextStripper();
            String text = textStripper.getText(document);
            System.out.println(text);
//      document.save("D:\\pdf\\I20190000159516081.doc");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
