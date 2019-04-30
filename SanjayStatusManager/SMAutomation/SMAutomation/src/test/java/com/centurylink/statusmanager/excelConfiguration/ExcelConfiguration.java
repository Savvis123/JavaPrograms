package com.centurylink.statusmanager.excelConfiguration;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.centurylink.statusmanager.utilities.URLConfigs;

public class ExcelConfiguration {
	
	public static void main (String []args) throws IOException {
		
		ExcelConfiguration ec = new ExcelConfiguration();
		
		ec.getSheet();
	}
	
	public void getSheet() throws IOException {
		
		
		FileInputStream f = new FileInputStream(URLConfigs.EXCEL_DATA) ;
		@SuppressWarnings("resource")
		XSSFWorkbook wb = new XSSFWorkbook(f);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		XSSFRow row = sheet.getRow(0) ;
		XSSFCell cell = row.getCell(2);
			String val = cell.getStringCellValue() ;
				System.out.println("value = "+ val);
				
	}
	
	public void getCelldata(int rownum, int colnum) {
		
		
	}

}
