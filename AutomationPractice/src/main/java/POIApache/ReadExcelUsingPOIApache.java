package POIApache;

import java.io.File;
import java.io.FileInputStream;



import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelUsingPOIApache {
	
	public static void getData()
	{
		
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
					System.out.println(row.getCell(j).getStringCellValue());
				}
			}

			
			
			
		/*	System.out.println(sh.getRow(0).getCell(0).getStringCellValue());
			System.out.println(sh.getRow(0).getCell(1).getStringCellValue());
		    System.out.println(sh.getRow(0).getCell(2).getStringCellValue());
			
			System.out.println(sh.getRow(1).getCell(0).getStringCellValue());
			System.out.println(sh.getRow(1).getCell(1).getStringCellValue());
			System.out.println(sh.getRow(1).getCell(2).getNumericCellValue());
			
			System.out.println(sh.getRow(2).getCell(0).getStringCellValue());
			System.out.println(sh.getRow(2).getCell(1).getStringCellValue());
			System.out.println(sh.getRow(2).getCell(2).getNumericCellValue());*/
			
			
		}
		catch(Exception e)
		{
			 System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getData();
	
	}

}
