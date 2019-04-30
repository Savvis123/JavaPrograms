package POIApache;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteDataIntoExcel {

    public static void main(String...strings) throws IOException{
    	
    	File file=new File("C:\\Users\\ab64129\\Desktop\\Interview\\test.xlsx");
    	FileInputStream fis = new FileInputStream(file);
    	
    	XSSFWorkbook wb=new XSSFWorkbook(fis);
    	
    	XSSFSheet sh=wb.getSheetAt(0);
    	
    	int rowcount=sh.getLastRowNum();
    	
    	   Row row = sh.getRow(0);
    	   
    	   Row newRow = sh.createRow(rowcount+1);
    	   for(int j=0;j<row.getLastCellNum();j++)
    	   {
    		   Cell cell=newRow.getCell(j);
    		   cell.setCellValue("Mahesh");
    		   
    	   }
    	  fis.close();

    	    //Create an object of FileOutputStream class to create write data in excel file

    	    FileOutputStream outputStream = new FileOutputStream(file);

    	    //write data in the excel file

    	   wb.write(outputStream);

    	    //close output stream

    	    outputStream.close();

    	

    }

}