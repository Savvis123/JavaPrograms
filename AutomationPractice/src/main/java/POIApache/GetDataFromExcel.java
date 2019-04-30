package POIApache;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetDataFromExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileInputStream fis=new FileInputStream(new File("C:\\Users\\ab64129\\Desktop\\Data.xlsx"));
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sh=wb.getSheet("Sheet1");
		int rowcount=sh.getLastRowNum();
		for(int i=0;i<rowcount+1;i++)
		{
			Row row=sh.getRow(i);
			
			for(int j=0;j<row.getLastCellNum();j++)
			{
				System.out.println(row.getCell(j).getStringCellValue());
			}
			
		}
		
		
		
		
		

	}

}
