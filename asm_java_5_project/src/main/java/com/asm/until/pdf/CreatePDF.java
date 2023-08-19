package com.asm.until.pdf;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class CreatePDF {
	public static Document CreatePDFGenerator(String nameOfPDF){
		Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream( nameOfPDF +  ".pdf"));
            document.open();
            Paragraph paragraph = new Paragraph();
            document.add(paragraph);
           return document; 
        } catch (DocumentException | IOException e) {
        	System.out.println("Không thể tạo PDF");
        	return null;
        }
	}
}
