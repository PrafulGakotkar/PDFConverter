package com.Numitry.in.Service;

import java.io.IOException;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletResponse;

public class EmployeeService {
	
	public void export(HttpServletResponse response) throws IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
 
        document.open();
        Font fontHeader = FontFactory.getFont(FontFactory.TIMES_BOLD);
        fontHeader.setSize(22);
 
        Paragraph headerParagraph = new Paragraph("## PDF Heading ##", fontHeader);
        headerParagraph.setAlignment(Paragraph.ALIGN_CENTER);
 
        Font fontParagraph = FontFactory.getFont(FontFactory.TIMES);
        fontParagraph.setSize(14);
 
        Paragraph pdfParagraph = new Paragraph("*** PDF Paragraph ***", fontParagraph);
        pdfParagraph.setAlignment(Paragraph.ALIGN_LEFT);
         
        document.add(headerParagraph);
        document.add(pdfParagraph);
        document.close();
	}
}
