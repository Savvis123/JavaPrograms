package POIApache;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		try{
			File file=new File("C:\\Users\\ab64129\\Desktop\\Interview\\test.xlsx");
			
			FileInputStream fis=new FileInputStream(file);
			
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			
			XSSFSheet sh=wb.getSheetAt(0);
			
			int rowcount=sh.getLastRowNum();
			
			for(int i=0;i<rowcount+1;i++)
			{
			 Row row=sh.getRow(i);
			 
			 for(int j=0;j<row.getLastCellNum();j++)
			 {
				 System.out.println(sh.getRow(i).getCell(j).getStringCellValue());
			 }
			}
			
		}
		catch(Exception e)
		{
			
		}
	}

}
