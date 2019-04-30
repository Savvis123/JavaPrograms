package stepDefinition;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import cucumber.api.java.en.Then;
import dataOperations.ExcelOperations;
import genericUtilities.CommonMethods;
import genericUtilities.GlobalVariables;

public class WriteTransactionResultInExcel extends GlobalVariables{
	
	ExcelOperations excelOperations = new ExcelOperations();
	
	@Then("^I write the payment_id and payment status in excel$")
	public void writePaymentIdAndStatusInExcel() throws Exception{
		
		String result=paymentId+" "+":"+" "+paymentDBStatus;
		excelOperations.writeDataIntoExcel(result,colTransactionStatus);
		
	}
	
	@Then("^I write account status to excel$")
	public void iWriteToAccountStatusToExcel() throws Exception {
		System.out.println(TransactionStatus);
		String passResult=TransactionStatus+"uccess";
		String failResult=TransactionStatus+"ailure:"+" "+ErrorMessage;
		if(TransactionStatus.equals("S"))
		{
			excelOperations.writeDataIntoExcel(passResult,colTransactionStatus);
		}
		else if(TransactionStatus.equals("F"))
		{
			excelOperations.writeDataIntoExcel(failResult,colTransactionStatus);
		}
		
	}

	@Then("^I write the RECORD_STATUS in excel$")
	public void i_write_the_RECORD_STATUS_in_excel() throws Throwable {
		String result=autopayDBStatus;
		excelOperations.writeDataIntoExcel(result,colTransactionStatus);
	}
	@Then("^I write the SERVICE ACTION STATUS in excel$")
	public void i_write_the_SERVICE_ACTION_STATUS_in_excel() throws Throwable {
		String result=autopayDBStatus;
		excelOperations.writeDataIntoExcel(result,colTransactionStatus);
	}
	
	
}
