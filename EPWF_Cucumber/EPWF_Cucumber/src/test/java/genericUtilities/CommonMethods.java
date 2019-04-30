package genericUtilities;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class CommonMethods extends GlobalVariables {
	
	public static HTTP_Post httppost=new HTTP_Post();
	
	//implicitWait
	public void implicitWait(int time){
		
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);//follow this method in detail,what are enum
	
	}
	
	public void JavaScriptExecutorClick(WebElement dynamicElement)
	{
		JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		executor1.executeScript("arguments[0].click()", dynamicElement );
	}
	
	//explicitWait
	public void explicitWait(int time,WebElement element){
		
		WebDriverWait wait = new WebDriverWait(driver, time);
		//wait.until(ExpectedConditions.elementToBeClickable(element));
	
	}
	
	public void setVariablesAsPerScenario(String scenarioName){
		
		if(scenarioName.contains("ACH")){
			paymentType="ACH";
		}else if(scenarioName.contains("CARD")){
			paymentType="CARD";
		}else if(scenarioName.contains("Paypal")){
			paymentType="Paypal";
		}
		
		if(scenarioName.contains("Scheduled")){
			paymentScheduleType="Scheduled";
		}else{
			paymentScheduleType="OneTime";
		}
		
		if(scenarioName.contains("Consmobile")){
			msgSourceSysId="CONSMOBILE";
			sourceAppId="CONSMOBILE";
		}else if(scenarioName.contains("MYAccount")){
			msgSourceSysId="MYACCOUNT";
			sourceAppId="MYACCOUNT";
		}else if(scenarioName.contains("QHOME")){
			msgSourceSysId="QHOME";
			sourceAppId="QHOME";
		}else if(scenarioName.contains("TCAT")){
			msgSourceSysId="THUNDERCAT";
			sourceAppId="THUNDERCAT";
		}
		else if(scenarioName.contains("MARLIE")){
			msgSourceSysId="MARLIE";
			sourceAppId="MARLIE";
		}
		else if(scenarioName.contains("CONPORT")){
			msgSourceSysId="CONPORT";
			sourceAppId="CONPORT";
		}else if(scenarioName.contains("NETWORX")){
			msgSourceSysId="NETWORX";
			sourceAppId="NETWORX";
		}else if(scenarioName.contains("SIMON")){
			msgSourceSysId="SIMON";
			sourceAppId="SIMON";
		}else if(scenarioName.contains("SIMONPAY")){
			msgSourceSysId="SIMONPAY";
			sourceAppId="SIMON";
		}else if(scenarioName.contains("IREPPAY")){
			msgSourceSysId="IPS";
			sourceAppId="IREP";
		}else if(scenarioName.contains("EPP")){
			msgSourceSysId="EPP";
			sourceAppId="EPP";

		}
		if(scenarioName.contains("Account_LookUp")){
			paymentType="";
			paymentScheduleType="";
			msgSourceSysId="";
			sourceAppId="";
		}
		
	}
	
	//Get the current system datetime
	public String getCurrentDateTime(String requiredDateFormat) {
		DateFormat dateFormat = new SimpleDateFormat(requiredDateFormat);
		Calendar cal = Calendar.getInstance();
		String CurrDateTime = dateFormat.format(cal.getTime());
		return CurrDateTime;
	}
	
	//JDBC Connectivity
	public void queryResultFromDB(String query) throws SQLException{
		
		try{
			Class.forName ("oracle.jdbc.driver.OracleDriver");
		}catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		dBConn = DriverManager.getConnection(ex_DBConnectionString,ex_DBUsername,ex_DBPassword);
		//preparedStatement = dBConn.prepareStatement(query);
		statement=dBConn.createStatement();
		queryResult = statement.executeQuery(query);
		
	}
	
	public void launchBrowser(){
		
			switch(ex_Browser){
			
			case "Firefox":
				
				System.setProperty("webdriver.gecko.driver",
						"..\\EPWF_Test\\Resources\\geckodriver.exe");
				DesiredCapabilities capa = DesiredCapabilities.firefox();
				capa.setCapability("marionette", false);
				driver = new FirefoxDriver(capa);
				implicitWait(60);
				driver.get(sessionURL);
				break;
			
			case "Chrome":
				
				System.setProperty("webdriver.chrome.driver",
						"..\\EPWF_Test\\Resources\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.get(sessionURL);
				break;
				
			default:
				
				System.out.println("Browser Not Working");
		
			}
			driver.manage().window().maximize();

		}
	
	//Modify XML Tag Values
	public void modifyXML(String XMLfilePath,Map<String,String> tagsToChange) throws ParserConfigurationException, SAXException, IOException, TransformerException{
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		Document doc = docBuilder.parse(XMLfilePath);
	    
		for(Map.Entry<String, String> mapEntry : tagsToChange.entrySet()){
			int noOfKeys = doc.getElementsByTagName(mapEntry.getKey()).getLength();
			for(int i=0;i<noOfKeys;i++){
			Node FirstName = doc.getElementsByTagName(mapEntry.getKey())
					.item(i);
			FirstName.setTextContent(mapEntry.getValue());
			}
		}
	    
	    TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(XMLfilePath));
		transformer.transform(source, result);
	}
	
	//Modify XML Tag Values for multipayment
	public void modifyXMLForMultiPaymentBTN(String XMLfilePath,Map<String,ArrayList<String>> tagsToChange) throws ParserConfigurationException, SAXException, IOException, TransformerException{
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		Document doc = docBuilder.parse(XMLfilePath);
		
		for(Map.Entry<String, ArrayList<String>> mapEntry : tagsToChange.entrySet()){
			int noOfKeys = doc.getElementsByTagName(mapEntry.getKey()).getLength();
			for(int i=0;i<noOfKeys;i++){
				
				Node FirstName = doc.getElementsByTagName(mapEntry.getKey())
						.item(i);
				FirstName.setTextContent(mapEntry.getValue().get(i));
			}
		}
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(XMLfilePath));
		transformer.transform(source, result);
	}
	
	
	public void invokeWebService() throws KeyManagementException, NoSuchAlgorithmException

	{
        /*if(sysOut) 
		System.out.println("CALLING WEBSERVICE..\\n uri:"+ex_WSDL+"\\n"+ "request:"+genericXMLFilePath+ex_XMLFileName);*/
		try {
			/*//httppost.setXMLStringValue(completeXMLPath);
			httppost.createTrustedCertificate();
			httppost.setHttpClient();*/
			
			//below statement requires WSDL and request XML
			httppost.setHTTPPost();
			
			httppost.sendHTTPPostRequest();
			httppost.formatResponseToString();
		} catch (MalformedURLException e) {
			//if(sysOut) 
			System.out.println("Error occured.....while invoking webservice uri:"+ex_WSDL);
			e.printStackTrace();
		} catch (IOException e) {
			//if(sysOut) 
			System.out.println("Error occured.....while invoking webservice uri:"+ex_WSDL);
			e.printStackTrace();
		}
		
		//if(sysOut) 
		System.out.println("Response XML --");
		System.out.println();
		System.out.println(responseXML);

	}
	
	
	public static void captureScreenshot(String screenshotName) 
	{
		
		try 
		{
			
			TakesScreenshot ts=(TakesScreenshot)driver;
		
			File source=ts.getScreenshotAs(OutputType.FILE);		
		
			FileUtils.copyFile(source, new File("target/Reports/Screenshot/"+scenarioName+"/"+screenshotName+".png"));
			
			System.out.println("Screenshot taken");
			
	
		} 
		catch (IOException e) 
		{
			System.out.println("Exception whilte taking screenshot");
		}	
		
	} 
	

	
	
	
	public boolean CheckElementVisibility(WebElement dynamicElement){
		int openIndex,closeIndex;
		try{
			dynamicElement.getSize();	  
			return true;
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			openIndex = e.getMessage().indexOf("{");
			closeIndex = e.getMessage().indexOf("}");
			elementNotFound = elementNotFound+e.getMessage().substring(openIndex+1, closeIndex);
			return false;
		}
	}
	
	//getting Payment Amount Generated
	public String getAmountToBePaid(){
		String number="";
		String randomInteger="";
		Random rnd = new Random();
	    float nextFloat = Math.abs(rnd.nextFloat());
	    long nextLong = Math.abs(rnd.nextLong());
	    randomInteger=String.valueOf(nextLong).substring(0, 2);
	    number=String.valueOf(Integer.parseInt(randomInteger)+nextFloat);
	    return number.substring(0,5);
	}
	
	public ArrayList<String> getAmountToBePaidForQportal(){
		String number="";
		String randomInteger="";
		int amount=0;
		Random rnd = new Random();
	    float nextFloat = Math.abs(rnd.nextFloat());
	    long nextLong = Math.abs(rnd.nextLong());
	    randomInteger=String.valueOf(nextLong).substring(0, 2);
	    number=String.valueOf(Integer.parseInt(randomInteger)+nextFloat);
	    exactAmount=number.substring(0,5);
		while(amount<3){
			qportalAmounts.add(String.valueOf(Float.parseFloat(exactAmount)+amount));
			++amount;
		}
		return qportalAmounts;
	}
	//Create a Random number with given length
	public String getRandomNumber(int length) {
		String number="";
		Random rnd = new Random();
		long nextLong = Math.abs(rnd.nextLong());
		number=String.valueOf(nextLong).substring(0, length);
		return number;
	}
	
	
	
}
