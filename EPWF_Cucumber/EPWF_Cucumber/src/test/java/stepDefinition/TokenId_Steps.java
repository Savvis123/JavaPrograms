package stepDefinition;

import cucumber.api.java.en.Then;
import dataOperations.ExcelOperations;
import dataOperations.ExcelUtils;
import genericUtilities.CommonMethods;
import genericUtilities.GlobalVariables;
import genericUtilities.ModifyXML;
import genericUtilities.XMLFileReader;

public class TokenId_Steps extends GlobalVariables{
	ExcelOperations excelOperations = new ExcelOperations();
	public static ExcelUtils excU = new ExcelUtils();
	ModifyXML modifyXML = new ModifyXML();
	CommonMethods commonMethods = new CommonMethods();
	XMLFileReader getXML = 	new XMLFileReader();
	
	@Then("^I Extract the TokenId from the Url and write it in Excel$")
	
	public void i_Extract_the_TokenId_from_the_Url_and_write_it_in_Excel() throws Throwable {
		//String currentpageurl = driver.getCurrentUrl();
	    System.out.println("Current Page URL is :"+currentpageurl);
	    String[] str=currentpageurl.split("=");
	    System.out.println(str[2]);
	    String TokenIDs[]=str[2].split("&");
	    TokenID=TokenIDs[0];
	    
	    //excelOperations.writeDataIntoExcel(TokenID,colTokenId);
		}
	
	}

