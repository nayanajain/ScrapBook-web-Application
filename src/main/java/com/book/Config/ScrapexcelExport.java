package com.book.Config;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.book.model.Scrap;

public class ScrapexcelExport {
	
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private List<Scrap> lists;
	
	
	
	public ScrapexcelExport() {
		super();
		// TODO Auto-generated constructor stub
	}  
	
	


	public ScrapexcelExport(List<Scrap> lists) {
		super();
		this.lists = lists;
		workbook= new XSSFWorkbook();
		sheet=workbook.createSheet("Scraps");
	}




	public void export(List<Scrap> lists, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		Row row=sheet.createRow(0);
		CellStyle st=workbook.createCellStyle();
		XSSFFont font=workbook.createFont();
		font.setBold(true);
        font.setFontHeight(20);
        st.setFont(font);
        
		Cell cell=row.createCell(0);
		cell.setCellValue("Id");
		cell.setCellStyle(st);
		
		 cell=row.createCell(1);
		cell.setCellValue("Name");
		cell.setCellStyle(st);
		
		 cell=row.createCell(2);
		cell.setCellValue("Contactno");
		cell.setCellStyle(st);
		 cell=row.createCell(3);
		cell.setCellValue("Lyrics");
		cell.setCellStyle(st);
		
		int rownum=1;
		
		for(Scrap s: lists)
		{
			Row r=sheet.createRow(rownum++);
			Cell cells=r.createCell(0);
			cells.setCellValue(s.getId());
			
		    cells=r.createCell(1);
			cells.setCellValue(s.getName());
			cells=r.createCell(2);
			cells.setCellValue(s.getContactno());
			cells=r.createCell(3);
			cells.setCellValue(s.getLyrics());
			
	
		}
		
		
		
		ServletOutputStream outputStream= response.getOutputStream();
		workbook.write(outputStream);
		outputStream.close();
		
	
		
		
	}

}
