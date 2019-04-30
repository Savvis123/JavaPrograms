package dataOperations;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import genericUtilities.GlobalVariables;

public class ExcelOperations extends GlobalVariables {
	
	int colNumber;
	ExcelUtils excelUtils = new ExcelUtils();
	
	public void setDataAsPerScenario(String data) throws EncryptedDocumentException, InvalidFormatException, IOException{
		
		currentRowNumber=excelUtils.getRowNumber(data);
		
		colNumber = excelUtils.getColumnNumber(colBrowser);
		ex_Browser= excelUtils.getCellData(currentRowNumber, colNumber);
		
		colNumber = excelUtils.getColumnNumber(colXMLFileName);
		ex_XMLFileName= excelUtils.getCellData(currentRowNumber, colNumber);
		
		colNumber = excelUtils.getColumnNumber(colBTN_BAID);
		ex_BTN_BAID= excelUtils.getCellData(currentRowNumber, colNumber);
		
		colNumber = excelUtils.getColumnNumber(colInputChannel);
		ex_InputChannel=excelUtils.getCellData(currentRowNumber, colNumber);
		
		colNumber = excelUtils.getColumnNumber(colInstrumentType);
		ex_InstrumentType=excelUtils.getCellData(currentRowNumber, colNumber);
		
		colNumber = excelUtils.getColumnNumber(colUserId);
		System.out.println(currentRowNumber);
		System.out.println(colNumber);
		ex_UserId= excelUtils.getCellData(currentRowNumber, colNumber); 
		
	
		if(data.contains("Account_LookUp"))
		{
			colNumber = excelUtils.getColumnNumber(colCustomerType);
			ex_CustomerType=excelUtils.getCellData(currentRowNumber, colNumber);
					
			colNumber = excelUtils.getColumnNumber(colInputChannel);
			ex_InputChannel=excelUtils.getCellData(currentRowNumber, colNumber);
			
			colNumber = excelUtils.getColumnNumber(colInstrumentType);
			ex_InstrumentType=excelUtils.getCellData(currentRowNumber, colNumber);
			
			colNumber = excelUtils.getColumnNumber(colBTN_BAID);
			ex_BTN_BAID= excelUtils.getCellData(currentRowNumber, colNumber);
						
		}
		else if(data.contains("TCAT_CXP")){
		
		colNumber = excelUtils.getColumnNumber(colPaypalUsername);
		ex_PaypalUsername= excelUtils.getCellData(currentRowNumber, colNumber);
		
		colNumber = excelUtils.getColumnNumber(colPaypalPassword);
		ex_PaypalPassword= excelUtils.getCellData(currentRowNumber, colNumber);
		
		if(data.contains("CARD")){
			colNumber = excelUtils.getColumnNumber(colCardNumber);
			ex_CardNumber=excelUtils.getCellData(currentRowNumber, colNumber);
			
			colNumber = excelUtils.getColumnNumber(colCardName);
			ex_CardName=excelUtils.getCellData(currentRowNumber, colNumber);
		}
		
		colNumber = excelUtils.getColumnNumber(colUserId);
		System.out.println(currentRowNumber);
		System.out.println(colNumber);
		ex_UserId= excelUtils.getCellData(currentRowNumber, colNumber); 
		
	}
	else if(data.contains("TCAT_SBI")){
			
		colNumber = excelUtils.getColumnNumber(colCustomerType);
		ex_CustomerType=excelUtils.getCellData(currentRowNumber, colNumber);
				
		colNumber = excelUtils.getColumnNumber(colInputChannel);
		ex_InputChannel=excelUtils.getCellData(currentRowNumber, colNumber);
			
			if(data.contains("CARD")){
				colNumber = excelUtils.getColumnNumber(colCardNumber);
				ex_CardNumber=excelUtils.getCellData(currentRowNumber, colNumber);
				
				colNumber = excelUtils.getColumnNumber(colCardName);
				ex_CardName=excelUtils.getCellData(currentRowNumber, colNumber);
			}
			
		}
	else if(data.contains("TCAT_SHI")){
		
		colNumber = excelUtils.getColumnNumber(colCustomerType);
		ex_CustomerType=excelUtils.getCellData(currentRowNumber, colNumber);
				
		colNumber = excelUtils.getColumnNumber(colInputChannel);
		ex_InputChannel=excelUtils.getCellData(currentRowNumber, colNumber);
		
		if(data.contains("CARD")){
			colNumber = excelUtils.getColumnNumber(colCardNumber);
			ex_CardNumber=excelUtils.getCellData(currentRowNumber, colNumber);
					
		}
		
	}
		
	else if(data.contains("Qportal_autopay_Enrollment")){
		
		  colNumber = excelUtils.getColumnNumber(colBrowser);
			ex_Browser= excelUtils.getCellData(currentRowNumber, colNumber);
			
			colNumber = excelUtils.getColumnNumber(colXMLFileName);
			ex_XMLFileName= excelUtils.getCellData(currentRowNumber, colNumber);
			
			colNumber = excelUtils.getColumnNumber(colBTN_BAID);
			ex_BTN_BAID= excelUtils.getCellData(currentRowNumber, colNumber);
			
			colNumber = excelUtils.getColumnNumber(colCustomerType);
			ex_CustomerType=excelUtils.getCellData(currentRowNumber, colNumber);
			
			colNumber = excelUtils.getColumnNumber(colInputChannelID);
			ex_InputChannel=excelUtils.getCellData(currentRowNumber, colNumber);
			
			colNumber = excelUtils.getColumnNumber(colInstrumentType);
			ex_InstrumentType=excelUtils.getCellData(currentRowNumber, colNumber);
			
            if(data.contains("ACH_New")){
            colNumber = excelUtils.getColumnNumber(colRoutingNumber);
            ex_RoutingNumber=excelUtils.getCellData(currentRowNumber, colNumber);
            }

		   if(data.contains("CARD")){
				colNumber = excelUtils.getColumnNumber(colCardNumber);
				ex_CardNumber=excelUtils.getCellData(currentRowNumber, colNumber);
				
			}
			
		}
		
	else if(data.contains("De-enrollAutopay")){
		
		  colNumber = excelUtils.getColumnNumber(colBrowser);
			ex_Browser= excelUtils.getCellData(currentRowNumber, colNumber);
			
			colNumber = excelUtils.getColumnNumber(colXMLFileName);
			ex_XMLFileName= excelUtils.getCellData(currentRowNumber, colNumber);
			
			colNumber = excelUtils.getColumnNumber(colBTN_BAID);
			ex_BTN_BAID= excelUtils.getCellData(currentRowNumber, colNumber);
			
			colNumber = excelUtils.getColumnNumber(colCustomerType);
			ex_CustomerType=excelUtils.getCellData(currentRowNumber, colNumber);
			
			colNumber = excelUtils.getColumnNumber(colInputChannelID);
			ex_InputChannel=excelUtils.getCellData(currentRowNumber, colNumber);
			
			colNumber = excelUtils.getColumnNumber(colInstrumentType);
			ex_InstrumentType=excelUtils.getCellData(currentRowNumber, colNumber);
			
            if(data.contains("ACH_New")){
            colNumber = excelUtils.getColumnNumber(colRoutingNumber);
            ex_RoutingNumber=excelUtils.getCellData(currentRowNumber, colNumber);
            }

		 
		  if(data.contains("CARD")){
				colNumber = excelUtils.getColumnNumber(colCardNumber);
				ex_CardNumber=excelUtils.getCellData(currentRowNumber, colNumber);
				
			}
			
		}
		
	else if(data.contains("CONPORT_EnrollAutopay")){
		
		    colNumber = excelUtils.getColumnNumber(colBrowser);
			ex_Browser= excelUtils.getCellData(currentRowNumber, colNumber);
			
			colNumber = excelUtils.getColumnNumber(colXMLFileName);
			ex_XMLFileName= excelUtils.getCellData(currentRowNumber, colNumber);
			
			colNumber = excelUtils.getColumnNumber(colBTN_BAID);
			ex_BTN_BAID= excelUtils.getCellData(currentRowNumber, colNumber);
			
			colNumber = excelUtils.getColumnNumber(colCustomerType);
			ex_CustomerType=excelUtils.getCellData(currentRowNumber, colNumber);
			
			colNumber = excelUtils.getColumnNumber(colInputChannelID);
			ex_InputChannel=excelUtils.getCellData(currentRowNumber, colNumber);
			
			colNumber = excelUtils.getColumnNumber(colInstrumentType);
			ex_InstrumentType=excelUtils.getCellData(currentRowNumber, colNumber);
			
			colNumber = excelUtils.getColumnNumber(colPaypalUsername);
			ex_PaypalUsername= excelUtils.getCellData(currentRowNumber, colNumber);
			
			colNumber = excelUtils.getColumnNumber(colPaypalPassword);
			ex_PaypalPassword= excelUtils.getCellData(currentRowNumber, colNumber);
			
            if(data.contains("ACH_New")){
            colNumber = excelUtils.getColumnNumber(colRoutingNumber);
            ex_RoutingNumber=excelUtils.getCellData(currentRowNumber, colNumber);
            }

			if(data.contains("CARD")){
		
				colNumber = excelUtils.getColumnNumber(colCardNumber);
				ex_CardNumber=excelUtils.getCellData(currentRowNumber, colNumber);
	    
				colNumber = excelUtils.getColumnNumber(colCardName);
				ex_CardName=excelUtils.getCellData(currentRowNumber, colNumber);
				
			}
			
			colNumber = excelUtils.getColumnNumber(colUserId);
			System.out.println(currentRowNumber);
			System.out.println(colNumber);
			ex_UserId= excelUtils.getCellData(currentRowNumber, colNumber);
			
		}
		
		
		
else if(data.contains("Autopay_Enrollment_Update_Remove")){
		
	  	colNumber = excelUtils.getColumnNumber(colBrowser);
		ex_Browser= excelUtils.getCellData(currentRowNumber, colNumber);
		
		colNumber = excelUtils.getColumnNumber(colXMLFileName);
		ex_XMLFileName= excelUtils.getCellData(currentRowNumber, colNumber);
		
		colNumber = excelUtils.getColumnNumber(colBTN_BAID);
		ex_BTN_BAID= excelUtils.getCellData(currentRowNumber, colNumber);
		
		colNumber = excelUtils.getColumnNumber(colCustomerType);
		ex_CustomerType=excelUtils.getCellData(currentRowNumber, colNumber);
		
		colNumber = excelUtils.getColumnNumber(colInputChannelID);
		ex_InputChannel=excelUtils.getCellData(currentRowNumber, colNumber);
		
		colNumber = excelUtils.getColumnNumber(colInstrumentType);
		ex_InstrumentType=excelUtils.getCellData(currentRowNumber, colNumber);
	 
	  if(data.contains("CARD")){
			colNumber = excelUtils.getColumnNumber(colCardNumber);
			ex_CardNumber=excelUtils.getCellData(currentRowNumber, colNumber);
			
		}
		
	}
	
		

	else if(data.contains("TCAT_SBP")||data.contains("TCAT_SHP")){
		
		colNumber = excelUtils.getColumnNumber(colCustomerType);
		ex_CustomerType=excelUtils.getCellData(currentRowNumber, colNumber);
		
		colNumber = excelUtils.getColumnNumber(colInputChannel);
		ex_InputChannel=excelUtils.getCellData(currentRowNumber, colNumber);
		
		
			if(data.contains("CARD")){
			colNumber = excelUtils.getColumnNumber(colCardNumber);
			ex_CardNumber=excelUtils.getCellData(currentRowNumber, colNumber);
			
			colNumber = excelUtils.getColumnNumber(colCardName);
			ex_CardName=excelUtils.getCellData(currentRowNumber, colNumber);
			
			}
		
	}
    else if(data.contains("SubmitPayment_MARLIE")){
			
    	colNumber = excelUtils.getColumnNumber(colBrowser);
		ex_Browser= excelUtils.getCellData(currentRowNumber, colNumber);
		
		colNumber = excelUtils.getColumnNumber(colXMLFileName);
		ex_XMLFileName= excelUtils.getCellData(currentRowNumber, colNumber);
		
		colNumber = excelUtils.getColumnNumber(colBTN_BAID);
		ex_BTN_BAID= excelUtils.getCellData(currentRowNumber, colNumber);
		
		colNumber = excelUtils.getColumnNumber(colCustomerType);
		ex_CustomerType=excelUtils.getCellData(currentRowNumber, colNumber);
		
		colNumber = excelUtils.getColumnNumber(colInputChannelID);
		ex_InputChannel=excelUtils.getCellData(currentRowNumber, colNumber);
		
		colNumber = excelUtils.getColumnNumber(colInstrumentType);
		ex_InstrumentType=excelUtils.getCellData(currentRowNumber, colNumber);

	        if(data.contains("ACH_New")){
	        colNumber = excelUtils.getColumnNumber(colRoutingNumber);
	        ex_RoutingNumber=excelUtils.getCellData(currentRowNumber, colNumber);
	        }

			if(data.contains("CARD")){
				colNumber = excelUtils.getColumnNumber(colCardNumber);
				ex_CardNumber=excelUtils.getCellData(currentRowNumber, colNumber);
				
				colNumber = excelUtils.getColumnNumber(colCardName);
				ex_CardName=excelUtils.getCellData(currentRowNumber, colNumber);
				
			}
     	}
    else if(data.contains("QPORTAL")){
    	
		    	colNumber = excelUtils.getColumnNumber(colCustomerType);
				ex_CustomerType=excelUtils.getCellData(currentRowNumber, colNumber);
				
				colNumber = excelUtils.getColumnNumber(colBTN_BAID);
				ex_BTN_BAID=excelUtils.getCellData(currentRowNumber, colNumber);
				for (String btn : ex_BTN_BAID.split(",")) {
				ex_QportalBTN.add(btn);
				}
				
				colNumber = excelUtils.getColumnNumber(colPaymentProcessDate);
				ex_PaymentProcessDate=(excelUtils.getCellData(currentRowNumber, colNumber));
				for (String qportalPaymentProcessDate : ex_PaymentProcessDate.split(",")) {
					ex_QportalPaymentProcessDt.add(qportalPaymentProcessDate);
				}
			
				
    	}
		
    else if(data.contains("MYAccount")){
			
			colNumber = excelUtils.getColumnNumber(colBrowser);
			ex_Browser= excelUtils.getCellData(currentRowNumber, colNumber);
			
			colNumber = excelUtils.getColumnNumber(colXMLFileName);
			ex_XMLFileName= excelUtils.getCellData(currentRowNumber, colNumber);
			
			colNumber = excelUtils.getColumnNumber(colBTN_BAID);
			ex_BTN_BAID= excelUtils.getCellData(currentRowNumber, colNumber);
			
			colNumber = excelUtils.getColumnNumber(colCustomerType);
			ex_CustomerType=excelUtils.getCellData(currentRowNumber, colNumber);
			
			colNumber = excelUtils.getColumnNumber(colInputChannelID);
			ex_InputChannel=excelUtils.getCellData(currentRowNumber, colNumber);
			
			colNumber = excelUtils.getColumnNumber(colInstrumentType);
			ex_InstrumentType=excelUtils.getCellData(currentRowNumber, colNumber);
			
			if(data.contains("ACH_New")){
            colNumber = excelUtils.getColumnNumber(colRoutingNumber);
            ex_RoutingNumber=excelUtils.getCellData(currentRowNumber, colNumber);
            }

			
			if(data.contains("CARD")){
				colNumber = excelUtils.getColumnNumber(colCardNumber);
				ex_CardNumber=excelUtils.getCellData(currentRowNumber, colNumber);
				
			}
			
		}
     else if(data.contains("Consmobile")){
			
			colNumber = excelUtils.getColumnNumber(colBrowser);
			ex_Browser= excelUtils.getCellData(currentRowNumber, colNumber);
			
			colNumber = excelUtils.getColumnNumber(colXMLFileName);
			ex_XMLFileName= excelUtils.getCellData(currentRowNumber, colNumber);
			
			colNumber = excelUtils.getColumnNumber(colBTN_BAID);
			ex_BTN_BAID= excelUtils.getCellData(currentRowNumber, colNumber);
			
			colNumber = excelUtils.getColumnNumber(colCustomerType);
			ex_CustomerType=excelUtils.getCellData(currentRowNumber, colNumber);
			
			colNumber = excelUtils.getColumnNumber(colInputChannelID);
			ex_InputChannel=excelUtils.getCellData(currentRowNumber, colNumber);
			
			colNumber = excelUtils.getColumnNumber(colInstrumentType);
			ex_InstrumentType=excelUtils.getCellData(currentRowNumber, colNumber);
			
            if(data.contains("ACH_New")){
            colNumber = excelUtils.getColumnNumber(colRoutingNumber);
            ex_RoutingNumber=excelUtils.getCellData(currentRowNumber, colNumber);
            }

			if(data.contains("CARD")){
				colNumber = excelUtils.getColumnNumber(colCardNumber);
				ex_CardNumber=excelUtils.getCellData(currentRowNumber, colNumber);
				
				colNumber = excelUtils.getColumnNumber(colCardNumber);
				ex_CardNumber=excelUtils.getCellData(currentRowNumber, colNumber);
			}
			
		}
     else{
		
		colNumber = excelUtils.getColumnNumber(colBTN_BAID);
		ex_BTN_BAID=excelUtils.getCellData(currentRowNumber, colNumber);
		
		colNumber = excelUtils.getColumnNumber(colBrowser);
		ex_Browser=excelUtils.getCellData(currentRowNumber, colNumber);
		
		colNumber = excelUtils.getColumnNumber(colXMLFileName);
		ex_XMLFileName=excelUtils.getCellData(currentRowNumber, colNumber);
		
		colNumber = excelUtils.getColumnNumber(colInputChannel);
		ex_InputChannel=excelUtils.getCellData(currentRowNumber, colNumber);
				
		colNumber = excelUtils.getColumnNumber(colCustomerType);
		ex_CustomerType=excelUtils.getCellData(currentRowNumber, colNumber);
				
		/*colNumber = excelUtils.getColumnNumber(colInputChannel);
		ex_InputChannel=excelUtils.getCellData(currentRowNumber, colNumber);*/
		
		colNumber = excelUtils.getColumnNumber(colInstrumentType);
		ex_InstrumentType=excelUtils.getCellData(currentRowNumber, colNumber);
		
		if(data.contains("ACH") && (data.contains("Existing"))==false){
			colNumber = excelUtils.getColumnNumber(colRoutingNumber);
			ex_RoutingNumber=excelUtils.getCellData(currentRowNumber, colNumber);
		}
		
		if(data.contains("CARD") && (data.contains("Existing"))==false){
			colNumber = excelUtils.getColumnNumber(colCardNumber);
			ex_CardNumber=excelUtils.getCellData(currentRowNumber, colNumber);
		}
		
		if(data.contains("Scheduled")&&(data.contains("Ensemble"))==false){
			colNumber = excelUtils.getColumnNumber(colScheduledDate);
			ex_ScheduledDate=excelUtils.getCellData(currentRowNumber, colNumber);
		}
		
		if(data.contains("Scheduled")&&data.contains("Ensemble")){
			colNumber = excelUtils.getColumnNumber(colPaymentProcessDate);
			ex_PaymentProcessDate=excelUtils.getCellData(currentRowNumber, colNumber);
		}
		
	}
	

		if(data.contains("QPORTAL")==false){
				colNumber = excelUtils.getColumnNumber(colCustomerType);
				ex_CustomerType=excelUtils.getCellData(currentRowNumber, colNumber);
		}
				
		
		
		if(data.contains("ACH") && (data.contains("Existing"))==false){
			colNumber = excelUtils.getColumnNumber(colRoutingNumber);
			ex_RoutingNumber=excelUtils.getCellData(currentRowNumber, colNumber);
		}
		
		if(data.contains("CARD") && (data.contains("Existing"))==false){
			colNumber = excelUtils.getColumnNumber(colCardNumber);
			ex_CardNumber=excelUtils.getCellData(currentRowNumber, colNumber);
		}
		
		if(data.contains("Scheduled")&&(data.contains("Ensemble"))==false){
			colNumber = excelUtils.getColumnNumber(colScheduledDate);
			ex_ScheduledDate=excelUtils.getCellData(currentRowNumber, colNumber);
		}
		
		if(data.contains("Scheduled")&&data.contains("Ensemble")){
			colNumber = excelUtils.getColumnNumber(colPaymentProcessDate);
			ex_PaymentProcessDate=excelUtils.getCellData(currentRowNumber, colNumber);
		}
		
		colNumber = excelUtils.getColumnNumber(colUserId);
		ex_UserId= excelUtils.getCellData(currentRowNumber, colNumber); 
				
	}
	
	public void setDBAndEnvironmentValues(String environment) throws EncryptedDocumentException, InvalidFormatException, IOException{
		
		excelUtils.openExcelFile(ExcelFile, envAndDBSheetName);
		
		envRowNumber=excelUtils.getRowNumber(environment);
		
		colNumber = excelUtils.getColumnNumber(colWSDL);
		ex_WSDL=excelUtils.getCellData(envRowNumber, colNumber);
	
		colNumber = excelUtils.getColumnNumber(colDBConnectionString);
		ex_DBConnectionString=excelUtils.getCellData(envRowNumber, colNumber);
		
		colNumber = excelUtils.getColumnNumber(colDBUserName);
		ex_DBUsername=excelUtils.getCellData(envRowNumber, colNumber);
		
		colNumber = excelUtils.getColumnNumber(colDBPassword);
		ex_DBPassword=excelUtils.getCellData(envRowNumber, colNumber);
		
	}
	
	public void setDBAndEnvironmentValues() throws EncryptedDocumentException, InvalidFormatException, IOException{
		
		excelUtils.openExcelFile(ExcelFile, envAndDBSheetName);
		
		envRowNumber=excelUtils.getRowNumber(executeStr);
		
		colNumber = excelUtils.getColumnNumber(colWSDL);
		ex_WSDL=excelUtils.getCellData(envRowNumber, colNumber);
	
		colNumber = excelUtils.getColumnNumber(colDBConnectionString);
		ex_DBConnectionString=excelUtils.getCellData(envRowNumber, colNumber);
		
		colNumber = excelUtils.getColumnNumber(colDBUserName);
		ex_DBUsername=excelUtils.getCellData(envRowNumber, colNumber);
		
		colNumber = excelUtils.getColumnNumber(colDBPassword);
		ex_DBPassword=excelUtils.getCellData(envRowNumber, colNumber);
		
	}
	
	//Token Code
	public void setTokenValues(String environment) throws EncryptedDocumentException, InvalidFormatException, IOException{
		excelUtils.openExcelFile(ExcelFile, TokenServiceURL);
		envRowNumber=excelUtils.getRowNumber(environment);		
		colNumber=excelUtils.getColumnNumber(getURI);	
	    ex_TokenId=excelUtils.getCellData(envRowNumber, colNumber);
	}
	
	public void setTokenValues() throws EncryptedDocumentException, InvalidFormatException, IOException{
		excelUtils.openExcelFile(ExcelFile, TokenServiceURL);
		envRowNumber=excelUtils.getRowNumber(executeStr);	
		colNumber=excelUtils.getColumnNumber(getURI);	
	    ex_TokenId=excelUtils.getCellData(envRowNumber, colNumber);
	}
	
	
	//Write data into excel
	public void writeDataIntoExcel(String data,String columnName) throws Exception{
		
		excelUtils.openExcelFile(ExcelFile, tcSheetName);
		colNumber = excelUtils.getColumnNumber(columnName);
		excelUtils.setCellData(data,currentRowNumber,colNumber);
		
	}
	
}
