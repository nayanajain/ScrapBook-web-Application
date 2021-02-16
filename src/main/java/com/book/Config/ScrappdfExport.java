package com.book.Config;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.book.model.Scrap;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class ScrappdfExport {
	
	private List<Scrap> listscrap;
	
	

	public ScrappdfExport(List<Scrap> listscrap) {
		super();
		this.listscrap = listscrap;
	}

	public List<Scrap> getListscrap() {
		return listscrap;
	}

	public void setListscrap(List<Scrap> listscrap) {
		this.listscrap = listscrap;
	}
	
	
	
	
	public void export(List<Scrap> lists, HttpServletResponse response) throws DocumentException, IOException
	{
		Document doc= new Document(PageSize.A4);
		PdfWriter.getInstance(doc, response.getOutputStream());
		doc.open();
		Paragraph paragraph= new Paragraph("Details of Scrap");
		paragraph.setAlignment(Element.ALIGN_CENTER);
		doc.add(paragraph);
		
		
		PdfPTable table=new PdfPTable(4);
		table.setWidthPercentage(100);
		Font tableHeader= FontFactory.getFont("Ariel", 10);
		
		Font tablebody= FontFactory.getFont("Ariel", 10);

		float colwidth[]= {2f,2f,2f,2f};
		table.setWidths(colwidth);
		
		PdfPCell name=new PdfPCell(new Paragraph("name", tableHeader));
		//name.setBorderColor(BaseColor.BLACK);
		table.addCell(name);
		
		
		PdfPCell contactno=new PdfPCell(new Paragraph("contactno", tableHeader));
	//	contactno.setBorderColor(BaseColor.BLACK);
		table.addCell(contactno);
		
		
		PdfPCell ly=new PdfPCell(new Paragraph("lyrics", tableHeader));
	//	ly.setBorderColor(BaseColor.BLACK);
		table.addCell(ly);
		
		for(Scrap s: lists)
		{
			PdfPCell nameval=new PdfPCell(new Paragraph(s.getName(), tableHeader));
			//nameval.setBorderColor(BaseColor.BLACK);
			table.addCell(nameval);
			
			PdfPCell contactval=new PdfPCell(new Paragraph(s.getContactno(), tableHeader));
			//contactval.setBorderColor(BaseColor.BLACK);
			table.addCell(contactval);
			
			PdfPCell lyval=new PdfPCell(new Paragraph(s.getLyrics(), tableHeader));
			//lyval.setBorderColor(BaseColor.BLACK);
			table.addCell(lyval);
			
			
			
		}
		
		doc.add(table);
		
		doc.close();
		
		
		
	}
	

}
