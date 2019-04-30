package POIApache;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelToDataProvider {
	
	  String xlFilePath = "C:\\Users\\ab64129\\Desktop\\NaveenAutomationLabsRestAPI\\DataProviderAndApachePOI\\TestDataSheet.xlsx";
	    String sheetName = "Credentials";
	    Xls_Reader eat = null;
	     
	    @Test(dataProvider = "userData")
	    public void fillUserForm(String userName, String passWord, String dateCreated, String noOfAttempts)
	    {
	       System.out.println("UserName: "+ userName);
	       System.out.println("PassWord: "+ passWord);
	       System.out.println("DateCreated: "+ dateCreated);
	       System.out.println("NoOfAttempts: "+ noOfAttempts);
	      // System.out.println("Result: "+ result);
	       System.out.println("*********************");
	    }
	     
	     
	    @DataProvider(name="userData")
	    public Object[][] userFormData() throws Exception
	    {
	        Object[][] data = testData(xlFilePath, sheetName);
	        return data;
	    }
	     
	    public Object[][] testData(String xlFilePath, String sheetName) throws Exception
	    {
	        Object[][] excelData = null;
	        eat = new Xls_Reader(xlFilePath);
	        int rows = eat.getRowCount(sheetName);
	        int columns = eat.getColumnCount(sheetName);
	                 
	        excelData = new Object[rows-1][columns];
	         
	        for(int i=1; i<rows; i++)
	        {
	            for(int j=0; j<columns; j++)
	            {
	                excelData[i-1][j] = eat.getCellData(sheetName, j, i);
	            }
	             
	        }
	        return excelData;
	    }

}