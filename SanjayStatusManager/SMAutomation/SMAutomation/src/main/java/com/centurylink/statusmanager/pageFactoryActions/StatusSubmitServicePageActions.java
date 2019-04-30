package com.centurylink.statusmanager.pageFactoryActions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import com.centurylink.statusmanager.utilities.CommonMethods;
import com.centurylink.statusmanager.utilities.JSONCreator;
import com.centurylink.statusmanager.utilities.MicroService;
import com.centurylink.statusmanager.utilities.SeleniumDriver;
import com.centurylink.statusmanager.utilities.URLConfigs;

public class StatusSubmitServicePageActions {

	WebDriver driver;

	JSONObject json;

	String SDWF_Accepted_TestData = null;
	public static String MicroService_Invocation_TestData = null;
	String microservice_update_TestData = null;

	JSONCreator jc = new JSONCreator();
	HomePageActions homePageActions = new HomePageActions(driver);
	RequestDetailsPageActions requestDetailsPageActions = new RequestDetailsPageActions(driver);

	private final static org.slf4j.Logger Log = LoggerFactory.getLogger(StatusSubmitServicePageActions.class);

	public StatusSubmitServicePageActions(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(SeleniumDriver.getDriver(), this);
	}

	// *********** Page variables begin from here ************

	public String correlationIDcommoninfo = null;
	public String publicUserIDcommoninfo = null;
	public String customerNamecommoninfo = null;
	String postalStatecommoninfo = null;
	String territoryCodecommoninfo = null;
	String offeringcommoninfo = null;
	String workgroupcommoninfo = null;
	String notBeforeDatecommoninfo = null;
	String customerCommitmentDatecommoninfo = null;
	String completionDatecommoninfo = null;
	String requestStatuscommoninfo = null;
	String requestStatusCodecommoninfo = null;
	String requestStatusMessagecommoninfo = null;
	String commentIDcommoninfo = null;
	String requestActionTypecommoninfo = null;

	String originatornameoriginatorinfo = null;
	String statusbackurloriginatorinfo = null;
	String commentoriginatorinfo = null;

	String NamecustomerDetailsMap = null;
	String ValuecustomerDetailsMap = null;

	String custname = "";
	String custvalue = "";

	public String microserviceretryrequrl = null;
	public String microservicename = null;
	public String microserstatus = null;
	public String microservicecode = null;
	public String microservicestatusmsg = null;
	public String transactionID = null;

	public String microservicecomment = null;

	public String microservicereqcomment = null;
	public String microservicereqrawcontent = null;
	public String microservicereqrawcontenttype = null;
	public String microservicereqtooltips = null;

	public String statusLinkName = null;

	public String statusLinkType = null;
	public String statusLinkTitle = null;
	public String statusLinkLabel = null;
	public String statusLinkUrl = null;
	public String statusLinkTarget = null;

	String statusmessage = "Micro Service Updated Successfully.";

	// *********** Page xpath's begin from here ************

	// ######## CommonInfo section xpath's #######

	@FindBy(xpath = ".//*[@ng-model='StatusSubmitService.commonInfo.correlationID']")
	public WebElement correlationid_tbx;

	@FindBy(xpath = ".//*[@ng-model='StatusSubmitService.commonInfo.publicUserID']")
	public WebElement publicuserId_tbx;

	@FindBy(xpath = ".//*[@ng-model='StatusSubmitService.commonInfo.customerName']")
	public WebElement customername_tbx;

	@FindBy(xpath = ".//*[@ng-model='StatusSubmitService.commonInfo.postalState']")
	public WebElement postalState_tbx;

	@FindBy(xpath = ".//*[@ng-model='StatusSubmitService.commonInfo.territoryCode']")
	public WebElement territoryCode_tbx;

	@FindBy(xpath = ".//*[@ng-model='StatusSubmitService.commonInfo.offering']")
	public WebElement offering_tbx;

	@FindBy(xpath = ".//*[@ng-model='StatusSubmitService.commonInfo.notBeforeDate']")
	public WebElement notbeforedate_tbx;

	@FindBy(xpath = ".//*[@ng-model='StatusSubmitService.commonInfo.customerCommitmentDate']")
	public WebElement customerCommitmentDate_tbx;

	@FindBy(xpath = ".//*[@ng-model='StatusSubmitService.commonInfo.workgroup']")
	public WebElement workgroup_tbx;

	@FindBy(xpath = ".//*[@ng-model='StatusSubmitService.commonInfo.assignedTo']")
	public WebElement assignedto_tbx;

	@FindBy(xpath = ".//*[@ng-model='StatusSubmitService.commonInfo.requestStatus']")
	public WebElement requestStatus_tbx;

	@FindBy(xpath = ".//*[@ng-model='StatusSubmitService.commonInfo.requestStatusCode']")
	public WebElement requestStatusCode_tbx;

	@FindBy(xpath = ".//*[@ng-model='StatusSubmitService.commonInfo.requestStatusMessage']")
	public WebElement requestStatusMessage_tbx;

	@FindBy(xpath = ".//*[@ng-model='StatusSubmitService.commonInfo.comment']")
	public WebElement comment_tbx;

	@FindBy(xpath = ".//*[@ng-model='StatusSubmitService.commonInfo.orderingSystem']")
	public WebElement orderingSystem_tbx;

	@FindBy(xpath = ".//*[@ng-model='StatusSubmitService.commonInfo.orderRefId']")
	public WebElement orderRefId_tbx;

	@FindBy(xpath = ".//*[@ng-model='StatusSubmitService.commonInfo.requestActionType']")
	public WebElement requestActionType_tbx;

	@FindBy(xpath = ".//*[@ng-model='StatusSubmitService.commonInfo.isParentRequest']")
	public WebElement isParentRequest_tbx;

	@FindBy(xpath = ".//*[@ng-model='StatusSubmitService.commonInfo.parentCorrelationID']")
	public WebElement parentCorrelationID_tbx;

	// ######## Originator section xpath's #######

	@FindBy(xpath = ".//*[@ng-model='StatusSubmitService.originatorInfo.originatorName']")
	public WebElement originatorname_tbx;

	@FindBy(xpath = ".//*[@ng-model='StatusSubmitService.originatorInfo.statusBackURLs']")
	public WebElement statusbackurl_tbx;

	@FindBy(xpath = ".//*[@ng-model='StatusSubmitService.originatorInfo.comment']")
	public WebElement origninfocomment_txtarea;

	// ######## Customer Details section xpath's #######

	@FindBy(xpath = ".//*[@alt='add customerDetailsMap']")
	public WebElement customerdetailAdd_btn;

	@FindBy(xpath = ".//*[@ng-show='StatusSubmitService.customerDetailsMap.length>0' and contains(text(),'Remove')]")
	public WebElement customerdetailRemove_btn;

	@FindBy(xpath = ".//*[@ng-model='item.name']")
	public WebElement customerdetailName_tbx;

	@FindBy(xpath = ".//*[@ng-model='item.value']")
	public WebElement customerdetailValue_tbx;

	// ######## MicroService Details section xpath's #######

	@FindBy(xpath = "//div[div[strong[text()='microServiceDetailsList']]]/div[2]/button")
	public WebElement AddMicroServiceDetailList_btn;

	@FindBy(xpath = "(//div[label[text()='microServiceName*']]/div/input)[position()=last()]")
	public WebElement microservicename_tbx;

	@FindBy(xpath = "//div[div[strong[text()='microServiceDetailsList']]]/div[2]/div/div/div[1]/div/input")
	public WebElement microserviceTransactionid_tbx;

	@FindBy(xpath = "(//div[label[text()='microServiceStatus*']]/div/input)[position()=last()]")
	public WebElement microservicestatus_tbx;

	@FindBy(xpath = "(//div[label[text()='microServiceStatusCode*']]/div/input)[position()=last()]")
	public WebElement microServiceStatusCode_tbx;

	@FindBy(xpath = "(//div[label[text()='microServiceStatusMessage*']]/div/input)[position()=last()]")
	public WebElement microServiceStatusMessage_tbx;

	@FindBy(xpath = "(//div[label[text()='dueDate']]/div/input)[position()=last()]")
	public WebElement MicroServicedueDate_tbx;

	@FindBy(xpath = "(//div[label[text()='notBeforeDate']]/div/input)[position()=last()]")
	public WebElement MicroServiceNotBefore_tbx;

	@FindBy(xpath = "(//div[label[text()='completeDate']]/div/input)[position()=last()]")
	public WebElement MicroServicecompleteDate_tbx;

	@FindBy(xpath = "(//div[label[text()='customerCommitmentDate']]/div/input)[position()=last()]")
	public WebElement MicroServicecustomercommitmentDate_tbx;

	@FindBy(xpath = "(//div[div[strong[contains(text(),'microServiceDetailsList')]]]/div[2]/div/div/div[8]/div/textarea)[position()=last()]")
	public WebElement MicroServicecomment_tbx;

	@FindBy(xpath = "//input[@placeholder='retryRequestURL']")
	public WebElement MicroServiceretryrequesturl_tbx;

	// ######## MicroService Request Details section xpath's #######

	@FindBy(xpath = "//button[@alt='add microServiceRequestDetailsList']")
	public WebElement AddmicroServiceRequestDetailsList_btn;

	@FindBy(xpath = "//div[div[strong[text()='microServiceRequestDetailsList']]]/div[2]/div/div/div[1]/div/input")
	public WebElement MicroServicerequestTranscationid_tbx;

	@FindBy(xpath = ".//textarea[@placeholder='rawRequestContent']")
	public WebElement MicroServicerawrequestcontent_txtarea;

	@FindBy(xpath = "//input[@placeholder='rawRequestContentType']")
	public WebElement MicroServicerawrequestcontenttype_tbx;

	@FindBy(xpath = ".//textarea[@placeholder='comment']")
	public WebElement MicroServicerequestcomment_txtarea;

	@FindBy(xpath = ".//input[@placeholder='toolTips']")
	public WebElement MicroServicerequestTooltips_tbx;

	// ######## Customer Details section xpath's #######

	// ######## MicroService Status Link Details section xpath's #######

	@FindBy(xpath = "//button[@alt='add microServiceStatusLinksList']")
	public WebElement MicroServiceStatusLinksListAdd_btn;

	@FindBy(xpath = "//div[div[strong[contains(text(),'microServiceStatusLinksList')]]]/div[2]/div/div/div[1]/div/input")
	public WebElement MicroServiceStatusLinksListtransactionid_tbx;

	@FindBy(xpath = "//input[@placeholder='statusLinkName']")
	public WebElement MicroServiceStatusLinkname_tbx;

	@FindBy(xpath = "//input[@placeholder='statusLinkType']")
	public WebElement MicroServiceStatusLinktype_tbx;

	@FindBy(xpath = "//input[@placeholder='statusLinkTitle']")
	public WebElement MicroServiceStatusLinktitle_tbx;

	@FindBy(xpath = "//input[@placeholder='statusLinkLabel']")
	public WebElement MicroServiceStatusLinklabel_tbx;

	@FindBy(xpath = "//input[@placeholder='statusLinkUrl']")
	public WebElement MicroServiceStatusLinkurl_tbx;

	@FindBy(xpath = "//input[@placeholder='statusLinkTarget']")
	public WebElement MicroServiceStatusLinktarget_tbx;

	// ###################################################

	//@FindBy(xpath = ".//button[@alt='add StatusSubmitService']")
	@FindBy(how=How.XPATH, using = ".//button[text()='Submit']")
	public WebElement submit_btn;

	// ***************** Response section *****************

	@FindBy(xpath = "//div[label[(text()='Response')]]/div/pre/p")
	public WebElement responseparagraph;

	// ***************** End of Response section *****************

	@FindBy(xpath = "//tab-heading[span[text()='Status Submit Service']]/a/img[1]")
	public WebElement closeStatusSubmitServiceTab_img;

	// *********** Page method's begin from here ***********

	public void readJsonData(String Data) throws JSONException, IOException, InterruptedException {

		if ("sdwf Accepted".equalsIgnoreCase(Data)) {

			jc.read_data_for_SDWF_Accepted();
			SDWF_Accepted_TestData = jc.AcceptedRequest;
			assingDatatovariables(SDWF_Accepted_TestData);

		}
		if ("microservice Invocation".equalsIgnoreCase(Data)) {

			jc.read_data_for_SDWF_MicroService_Invocation();
			MicroService_Invocation_TestData = jc.MSRequest;

			System.out.println("MicroService_Invocation_TestData  = " + MicroService_Invocation_TestData);
		}
		if ("microservice_update".equalsIgnoreCase(Data)) {

			jc.read_data_for_microservice_update();
			microservice_update_TestData = jc.MicroServiceUpdateReq;

		}

	}

	public void fillStatusSubmitServiceForm(String Data) throws IOException, JSONException, InterruptedException {

		if ("sdwf Accepted".equalsIgnoreCase(Data)) {

			jc.read_data_for_SDWF_Accepted();
			SDWF_Accepted_TestData = jc.AcceptedRequest;
			fillSdwfAcceptedForm(SDWF_Accepted_TestData);

		}
		if ("microservice Invocation".equalsIgnoreCase(Data)) {

			assingDatatovariables(MicroService_Invocation_TestData);
			fillSdwfAcceptedForm(MicroService_Invocation_TestData);
			fillMicroserviceDetailsSection(MicroService_Invocation_TestData);

		}
		if ("microservice_update".equalsIgnoreCase(Data)) {

			fill_microservice_update_form(microservice_update_TestData);
		}

	}

	public void statussubmitserviceResponseValidation(String Data)
			throws IOException, JSONException, InterruptedException {

		if ("sdwf Accepted".equalsIgnoreCase(Data)) {

			validateSdwfAcceptedResponse();

		}
		if ("microservice Invocation".equalsIgnoreCase(Data)) {

			validateMicroserviceDetailsSectionResponse();

		}
		if ("microservice_update".equalsIgnoreCase(Data)) {

			validate_microservice_update_response();
		}
	}

	public void statussubmitserviceUIValidationScenario(String Data)
			throws JSONException, InterruptedException, IOException {

		if ("sdwf Accepted".equals(Data)) {

			jc.read_data_for_SDWF_Accepted();
			SDWF_Accepted_TestData = jc.AcceptedRequest;
			validateStatusSubmitServiceDataonUI(SDWF_Accepted_TestData, Data);

		}
		if ("microservice Invocation".equals(Data)) {

			jc.read_data_for_SDWF_MicroService_Invocation();
			MicroService_Invocation_TestData = jc.MSRequest;
			validateStatusSubmitServiceDataonUI(MicroService_Invocation_TestData, Data);

		}
		if ("microservice_update".equals(Data)) {

			jc.read_data_for_microservice_update();
			microservice_update_TestData = jc.MicroServiceUpdateReq;
			validateStatusSubmitServiceDataonUI(microservice_update_TestData, Data);

		}

	}

	// ***********************

	public void assingDatatovariables(String Data) throws JSONException {

		json = new JSONObject(Data);
		System.out.println("JSON Object is = " + json);

		if (json.getJSONObject("commonInfo").has("correlationID")) {

			correlationIDcommoninfo = json.getJSONObject("commonInfo").getString("correlationID");
		}
		if (json.getJSONObject("commonInfo").has("publicUserID")) {

			publicUserIDcommoninfo = json.getJSONObject("commonInfo").getString("publicUserID");
		}
		if (json.getJSONObject("commonInfo").has("customerName")) {

			customerNamecommoninfo = json.getJSONObject("commonInfo").getString("customerName");
		}
		if (json.getJSONObject("commonInfo").has("offering")) {
			
			offeringcommoninfo = json.getJSONObject("commonInfo").getString("offering");
		}
		if (json.getJSONObject("commonInfo").has("workgroup")) {
			
			workgroupcommoninfo = json.getJSONObject("commonInfo").getString("workgroup");
		}
		if (json.getJSONObject("commonInfo").has("notBeforeDate")) {
			
			notBeforeDatecommoninfo = json.getJSONObject("commonInfo").getString("notBeforeDate");
		}
		if (json.getJSONObject("commonInfo").has("customerCommitmentDate")) {
			
			customerCommitmentDatecommoninfo = json.getJSONObject("commonInfo").getString("customerCommitmentDate");
		}
		if (json.getJSONObject("commonInfo").has("requestStatus")) {
			
			requestStatuscommoninfo = json.getJSONObject("commonInfo").getString("requestStatus");
		}
		if (json.getJSONObject("commonInfo").has("requestStatusCode")) {
			
			requestStatusCodecommoninfo = json.getJSONObject("commonInfo").getString("requestStatusCode");
		}
		if (json.getJSONObject("commonInfo").has("requestStatusMessage")) {
			
			requestStatusMessagecommoninfo = json.getJSONObject("commonInfo").getString("requestStatusMessage");
		}
		if (json.getJSONObject("commonInfo").has("comment")) {
			
			commentIDcommoninfo = json.getJSONObject("commonInfo").getString("comment");
		}
		if (json.getJSONObject("commonInfo").has("postalState")) {

			postalStatecommoninfo = json.getJSONObject("commonInfo").getString("postalState");
		}

		if (json.getJSONObject("commonInfo").has("territoryCode")) {

			territoryCodecommoninfo = json.getJSONObject("commonInfo").getString("territoryCode");
		}

		if (json.getJSONObject("commonInfo").has("requestActionType")) {

			requestActionTypecommoninfo = json.getJSONObject("commonInfo").getString("requestActionType");
		}
		if (json.getJSONObject("commonInfo").has("originatorName")) {
			
			originatornameoriginatorinfo = json.getJSONObject("originatorInfo").getString("originatorName");
		}
		if (json.getJSONObject("commonInfo").has("requestActionType")) {
			
			statusbackurloriginatorinfo = json.getJSONObject("originatorInfo").getString("statusBackURLs");
		}
		if (json.getJSONObject("commonInfo").has("requestActionType")) {
			
			commentoriginatorinfo = json.getJSONObject("originatorInfo").getString("comment");
		}
	
	}

	public void fillSdwfAcceptedForm(String Data) throws JSONException, InterruptedException {

		// CommonInfo Details section
		if (correlationIDcommoninfo != null && !correlationIDcommoninfo.isEmpty()) {

			correlationid_tbx.sendKeys(correlationIDcommoninfo);
		}
		if (publicUserIDcommoninfo != null && !publicUserIDcommoninfo.isEmpty()) {

			publicuserId_tbx.sendKeys(publicUserIDcommoninfo);
		}
		if (customerNamecommoninfo != null && !customerNamecommoninfo.isEmpty()) {

			customername_tbx.sendKeys(customerNamecommoninfo);
		}
		if (postalStatecommoninfo != null && !postalStatecommoninfo.isEmpty()) {

			postalState_tbx.sendKeys(postalStatecommoninfo);
		}
		if (territoryCodecommoninfo != null && !territoryCodecommoninfo.isEmpty()) {

			territoryCode_tbx.sendKeys(territoryCodecommoninfo);
		}
		if (offeringcommoninfo != null && !offeringcommoninfo.isEmpty()) {

			offering_tbx.sendKeys(offeringcommoninfo);
		}
		if (workgroupcommoninfo != null && !workgroupcommoninfo.isEmpty()) {

			workgroup_tbx.sendKeys(workgroupcommoninfo);
		}
		if (notBeforeDatecommoninfo != null && !notBeforeDatecommoninfo.isEmpty()) {

			notbeforedate_tbx.sendKeys(notBeforeDatecommoninfo);
		}
		if (customerCommitmentDatecommoninfo != null && !customerCommitmentDatecommoninfo.isEmpty()) {

			customerCommitmentDate_tbx.sendKeys(customerCommitmentDatecommoninfo);
		}
		if (requestStatuscommoninfo != null && !requestStatuscommoninfo.isEmpty()) {

			requestStatus_tbx.sendKeys(requestStatuscommoninfo);
		}
		if (requestStatusCodecommoninfo != null && !requestStatusCodecommoninfo.isEmpty()) {

			requestStatusCode_tbx.sendKeys(requestStatusCodecommoninfo);
		}
		if (requestStatusMessagecommoninfo != null && !requestStatusMessagecommoninfo.isEmpty()) {

			requestStatusMessage_tbx.sendKeys(requestStatusMessagecommoninfo);
		}
		if (commentIDcommoninfo != null && !commentIDcommoninfo.isEmpty()) {

			comment_tbx.sendKeys(commentIDcommoninfo);
		}
		if (requestActionTypecommoninfo != null && !requestActionTypecommoninfo.isEmpty()) {

			requestActionType_tbx.sendKeys(requestActionTypecommoninfo);
		}

		// Originator info Details section
		if (originatornameoriginatorinfo != null && !originatornameoriginatorinfo.isEmpty()) {

			originatorname_tbx.sendKeys(originatornameoriginatorinfo);
		}
		if (statusbackurloriginatorinfo != null && !statusbackurloriginatorinfo.isEmpty()) {

			statusbackurl_tbx.sendKeys(statusbackurloriginatorinfo);
		}
		if (commentoriginatorinfo != null && !commentoriginatorinfo.isEmpty()) {

			origninfocomment_txtarea.sendKeys(commentoriginatorinfo);
		}

		// Customer Details section
		JSONArray cust = json.getJSONArray("customerDetailsMap");

		for (int i = 0; i < cust.length(); i++) {

			custname = cust.getJSONObject(i).getString("name");
			custvalue = cust.getJSONObject(i).getString("value");

			customerdetailAdd_btn.click();
			SeleniumDriver.getDriver().findElement(By.xpath("(.//*[@placeholder='name' ])[" + (i + 1) + "]"))
					.sendKeys(custname);
			SeleniumDriver.getDriver().findElement(By.xpath("(.//*[@placeholder='value' ])[" + (i + 1) + "]"))
					.sendKeys(custvalue);

		}

	}

	public void fillMicroserviceDetailsSection(String Data) throws JSONException, InterruptedException {

		json = new JSONObject(Data);
		JSONArray recs = json.getJSONArray("microServiceDetailsList");

		MicroService[] microServiceArray = new MicroService[recs.length()];
		for (int i = 0; i < microServiceArray.length; i++) {
			JSONObject rec = recs.getJSONObject(i);

			microServiceArray[i] = new MicroService();

			microServiceArray[i].setMicroservicename(rec.getString("microServiceName"));
			microServiceArray[i].setMicroserstatus(rec.getString("microServiceStatus"));
			microServiceArray[i].setMicroservicecode(rec.getString("microServiceStatusCode"));
			microServiceArray[i].setMicroservicecomment(rec.getString("comment"));
			microServiceArray[i].setMicroservicecompdate(rec.getString("completeDate"));
			microServiceArray[i].setMicroserviceduedate(rec.getString("dueDate"));
			microServiceArray[i].setMicroservicenotbeforedate(rec.getString("notBeforeDate"));
			microServiceArray[i].setMicroservicecustomercommitmentdate(rec.getString("customerCommitmentDate"));
			microServiceArray[i].setMicroservicestatusmsg(rec.getString("microServiceStatusMessage"));
		}
		Thread.sleep(1000);

		for (int i = 0; i < microServiceArray.length; i++) {
			System.out.println("Micro Service No:" + i);

			CommonMethods.WaitforElement(AddMicroServiceDetailList_btn);
			AddMicroServiceDetailList_btn.click();

			microservicename_tbx.sendKeys(microServiceArray[i].getMicroservicename());
			microservicestatus_tbx.sendKeys(microServiceArray[i].getMicroserstatus());
			microServiceStatusCode_tbx.sendKeys(microServiceArray[i].getMicroservicecode());
			microServiceStatusMessage_tbx.sendKeys(microServiceArray[i].getMicroservicestatusmsg());
			MicroServiceNotBefore_tbx.sendKeys(microServiceArray[i].getMicroservicenotbeforedate());
			MicroServicecustomercommitmentDate_tbx
					.sendKeys(microServiceArray[i].getMicroservicecustomercommitmentdate());
			MicroServicecomment_tbx.sendKeys(microServiceArray[i].getMicroservicecomment());
		}
	}

	public void fill_microservice_update_form(String Data) throws JSONException {

		Log.info("Fetching Data from Data File");
		JSONObject json = new JSONObject(Data);

		// Reading the CommonInfo section from data file

		correlationIDcommoninfo = json.getJSONObject("commonInfo").getString("correlationID");

		publicUserIDcommoninfo = json.getJSONObject("commonInfo").getString("publicUserID");

		customerNamecommoninfo = json.getJSONObject("commonInfo").getString("customerName");

		offeringcommoninfo = json.getJSONObject("commonInfo").getString("offering");

		requestStatuscommoninfo = json.getJSONObject("commonInfo").getString("requestStatus");

		requestStatusCodecommoninfo = json.getJSONObject("commonInfo").getString("requestStatusCode");

		requestStatusMessagecommoninfo = json.getJSONObject("commonInfo").getString("requestStatusMessage");

		commentIDcommoninfo = json.getJSONObject("commonInfo").getString("comment");

		// Reading the microServiceDetailsList sub section from data file

		JSONArray recs = json.getJSONArray("microServiceDetailsList");

		for (int i = 0; i < recs.length(); ++i) {
			JSONObject rec = recs.getJSONObject(i);

			transactionID = rec.getString("transactionID");
			microservicename = rec.getString("microServiceName");
			microserstatus = rec.getString("microServiceStatus");
			microservicecode = rec.getString("microServiceStatusCode");
			microservicestatusmsg = rec.getString("microServiceStatusMessage");
			microservicecomment = rec.getString("comment");
			microserviceretryrequrl = rec.getString("retryRequestURL");

		}

		// Reading the microServiceRequestDetailsList sub section from data file

		JSONArray recs1 = json.getJSONArray("microServiceRequestDetailsList");

		for (int i = 0; i < recs1.length(); ++i) {
			JSONObject rec = recs1.getJSONObject(i);

			transactionID = rec.getString("transactionID");
			microservicereqcomment = rec.getString("comment");
			microservicereqrawcontent = rec.getString("rawRequestContent");
			microservicereqrawcontenttype = rec.getString("rawRequestContentType");
			microservicereqtooltips = rec.getString("toolTips");

		}

		// Reading the microServiceStatusLinksList sub section from data file

		JSONArray microServiceStatusLinksList = json.getJSONArray("microServiceStatusLinksList");

		for (int i = 0; i < microServiceStatusLinksList.length(); ++i) {
			JSONObject rec = microServiceStatusLinksList.getJSONObject(i);

			statusLinkName = rec.getString("statusLinkName");
			statusLinkType = rec.getString("statusLinkType");
			statusLinkTitle = rec.getString("statusLinkTitle");
			statusLinkLabel = rec.getString("statusLinkLabel");
			statusLinkUrl = rec.getString("statusLinkUrl");
			statusLinkTarget = rec.getString("statusLinkTarget");

		}

		correlationid_tbx.sendKeys(correlationIDcommoninfo);
		publicuserId_tbx.sendKeys(publicUserIDcommoninfo);
		customername_tbx.sendKeys(customerNamecommoninfo);
		offering_tbx.sendKeys(offeringcommoninfo);

		CommonMethods.WaitforElement(requestStatus_tbx);

		requestStatus_tbx.sendKeys(requestStatuscommoninfo);

		CommonMethods.WaitforElement(requestStatusCode_tbx);

		requestStatusCode_tbx.sendKeys(requestStatusCodecommoninfo);

		CommonMethods.WaitforElement(requestStatusMessage_tbx);

		requestStatusMessage_tbx.sendKeys(requestStatusMessagecommoninfo);

		CommonMethods.WaitforElement(comment_tbx);

		comment_tbx.sendKeys(commentIDcommoninfo);

		CommonMethods.WaitforElement(AddMicroServiceDetailList_btn);

		AddMicroServiceDetailList_btn.click();

		microserviceTransactionid_tbx.sendKeys(transactionID);
		microservicename_tbx.sendKeys(microservicename);
		microservicestatus_tbx.sendKeys(microserstatus);
		microServiceStatusCode_tbx.sendKeys(microservicecode);
		microServiceStatusMessage_tbx.sendKeys(microservicestatusmsg);

		CommonMethods.WaitforElement(MicroServicecomment_tbx);
		MicroServicecomment_tbx.sendKeys(microservicecomment);

		CommonMethods.WaitforElement(MicroServiceretryrequesturl_tbx);
		MicroServiceretryrequesturl_tbx.sendKeys(microserviceretryrequrl);

		fillMicroServiceRequestDetailList(Data);

		fillMicroServiceStatusLinksListsection(Data);

	}

	public void fillMicroServiceRequestDetailList(String data) {

		AddmicroServiceRequestDetailsList_btn.click();

		MicroServicerequestTranscationid_tbx.sendKeys(transactionID);

		CommonMethods.WaitforElement(MicroServicerawrequestcontent_txtarea);
		MicroServicerawrequestcontent_txtarea.sendKeys(microservicereqrawcontent);

		CommonMethods.WaitforElement(MicroServicerawrequestcontenttype_tbx);
		MicroServicerawrequestcontenttype_tbx.sendKeys(microservicereqrawcontenttype);

		CommonMethods.WaitforElement(MicroServicerequestcomment_txtarea);
		MicroServicerequestcomment_txtarea.sendKeys(microservicereqcomment);

		CommonMethods.WaitforElement(MicroServicerequestTooltips_tbx);
		MicroServicerequestTooltips_tbx.sendKeys(microservicereqtooltips);

	}

	public void fillMicroServiceStatusLinksListsection(String data) {

		CommonMethods.WaitforElement(MicroServiceStatusLinksListAdd_btn);
		CommonMethods.scrollintoview(MicroServiceStatusLinksListAdd_btn);

		MicroServiceStatusLinksListAdd_btn.click();

		CommonMethods.WaitforElement(MicroServiceStatusLinksListtransactionid_tbx);
		CommonMethods.scrollintoview(MicroServiceStatusLinksListtransactionid_tbx);

		MicroServiceStatusLinksListtransactionid_tbx.sendKeys(transactionID);

		CommonMethods.WaitforElement(MicroServiceStatusLinkname_tbx);
		CommonMethods.scrollintoview(MicroServiceStatusLinkname_tbx);

		MicroServiceStatusLinkname_tbx.sendKeys(statusLinkName);

		CommonMethods.WaitforElement(MicroServiceStatusLinktype_tbx);
		CommonMethods.scrollintoview(MicroServiceStatusLinktype_tbx);

		MicroServiceStatusLinktype_tbx.sendKeys(statusLinkType);

		MicroServiceStatusLinktitle_tbx.sendKeys(statusLinkTitle);
		MicroServiceStatusLinklabel_tbx.sendKeys(statusLinkLabel);

		CommonMethods.WaitforElement(MicroServiceStatusLinkurl_tbx);
		CommonMethods.scrollintoview(MicroServiceStatusLinkurl_tbx);

		MicroServiceStatusLinkurl_tbx.sendKeys(statusLinkUrl);

		CommonMethods.WaitforElement(MicroServiceStatusLinktarget_tbx);
		CommonMethods.scrollintoview(MicroServiceStatusLinktarget_tbx);

		MicroServiceStatusLinktarget_tbx.sendKeys(statusLinkTarget);

	}

	// ------------ Click to submit the request -----------------

	public void clickOnSubmitButton() {

		CommonMethods.WaitforElement(submit_btn);
	//	CommonMethods.WaitforElementtobeClickable(submit_btn);
		CommonMethods.scrollintoviewAndClickonWebElement(submit_btn);
		System.out.println("Submit button Enabled = " + submit_btn.isEnabled());
		submit_btn.click();
	}

	// ----------------- Response validation ----------------

	public void validateSdwfAcceptedResponse() throws InterruptedException, JSONException {

		Thread.sleep(7000);

		CommonMethods.WaitforElement(responseparagraph);

		CommonMethods.scrollintoview(responseparagraph);
		Thread.sleep(1000);

		String response = responseparagraph.getText();
		// System.out.println("Service accepted response" + response);
		Log.info("Service accepted response" + response);

		String ExpectedSuccessmessage = "SM Details Updated successfully";
		String ExpectedPartialSuccessmessage = "Request's CommonInfo Details Update Ignored as current originator is not matching with First originator.";

		CommonMethods.captureScreenshot(
				URLConfigs.SCREENSHOT_PATH + "\\sdwf accepted response" + "_" + SeleniumDriver.timestamp() + ".png");

		JSONObject json = new JSONObject(response);

		String Statusmsgresponse = json.getJSONObject("commonResponseInfo").getString("statusMessage");

		if (Statusmsgresponse.startsWith("SM Details Updated successfully")) {
			System.out.println("SM details updated successfully");
			// Assert.assertEquals(ExpectedSuccessmessage, Statusmsgresponse);
		} else if (Statusmsgresponse.startsWith(
				"Request's CommonInfo Details Update Ignored as current originator is not matching with First originator.")) {
			// System.out.println("Error Message =>" + Statuserrormsgresponse);
			System.out.println("Partial Success");
			// Assert.assertEquals(ExpectedPartialSuccessmessage, Statusmsgresponse);
		}
	}

	public void validateMicroserviceDetailsSectionResponse() throws JSONException, InterruptedException {

		CommonMethods.WaitforElement(responseparagraph);

		CommonMethods.scrollintoview(responseparagraph);

		String response = responseparagraph.getText();
		// System.out.println("Service accepted response" + response);
		System.out.println("SDWF_MicroserviceInvocation Response" + response);
		Log.info("SDWF_MicroserviceInvocation Response" + response);

		String commonResponseInfo_ExpectedSuccessmessage = "SM Details submitted successfully.";

		CommonMethods.captureScreenshot(URLConfigs.SCREENSHOT_PATH + "\\SDWF_MicroService_Invocation_Response" + "_"
				+ SeleniumDriver.timestamp() + ".png");

		JSONObject json = new JSONObject(response);

		String commonResponseInfo_Statusmsgresponse = json.getJSONObject("commonResponseInfo")
				.getString("statusMessage");

		if (commonResponseInfo_Statusmsgresponse.startsWith("SM Details submitted successfully")) {
			// System.out.println("SM details updated successfully");
			System.out.println("SM details updated successfully");
			Assert.assertEquals(commonResponseInfo_ExpectedSuccessmessage, commonResponseInfo_Statusmsgresponse);
		}

		JSONArray recs = json.getJSONArray("microServiceResponseDetailsList");
		List<String> transactionIds = new ArrayList<String>();

		for (int i = 0; i < recs.length(); i++) {
			JSONObject rec = recs.getJSONObject(i);
			transactionIds.add(i, rec.getString("transactionID"));
			// System.out.println("transactionID "+i+" = " + transactionIds.get(i));
			System.out.println("transactionID " + i + " = " + transactionIds.get(i));
		}

	}

	public void validate_microservice_update_response() throws InterruptedException, JSONException {

		CommonMethods.WaitforElement(responseparagraph);

		CommonMethods.scrollintoview(responseparagraph);

		String response = responseparagraph.getText();
		System.out.println("Micro Service Update response" + response);
		Log.info("Micro Service Update response" + response);

		CommonMethods.captureScreenshot(
				URLConfigs.SCREENSHOT_PATH + "\\microservice_update" + "_" + SeleniumDriver.timestamp() + ".png");

		JSONObject json = new JSONObject(response);

		String statusmessageactualresp = json.getJSONArray("microServiceResponseDetailsList").getJSONObject(0)
				.getString("statusMessage");

		if (statusmessage.equals(statusmessageactualresp)) {
			System.out.println("Micro service update successfully");
			Log.info("Micro service update successfully");

		} else {
			System.out.println("Micro service update not successful");
			Log.error("Micro service update not successful");
		}

	}

	// ---------------------- UI validation ---------------------

	public void validateStatusSubmitServiceDataonUI(String Data, String Servicetype)
			throws JSONException, InterruptedException {

		json = new JSONObject(Data);
		System.out.println("JSON Object is = " + json);

		correlationIDcommoninfo = json.getJSONObject("commonInfo").getString("correlationID");
		publicUserIDcommoninfo = json.getJSONObject("commonInfo").getString("publicUserID");
		customerNamecommoninfo = json.getJSONObject("commonInfo").getString("customerName");

		homePageActions.SearchSlider_CorrelationID_tbx.sendKeys(correlationIDcommoninfo);
		homePageActions.clickonSearchbutton();
		homePageActions.clickonViewEditIcon();
		requestDetailsPageActions.waitForRequestPageToLoad();

		String Customername_UI = SeleniumDriver.getDriver()
				.findElement(By.xpath("//tab-heading[span[contains(text(),'Request Details')]]//span[contains(text(),'"
						+ customerNamecommoninfo + "')]"))
				.getText();
		String Request_tab_title = SeleniumDriver.getDriver()
				.findElement(By.xpath("//tab-heading[span[contains(text(),'Request Details')]]")).getText();

		if (Request_tab_title.contains(customerNamecommoninfo)) {
			System.out.println("Tab title contains Customer Name");
			Log.info("Tab title contains Customer Name");

		} else if (Request_tab_title.contains(publicUserIDcommoninfo)) {
			System.out.println("Tab title contains PublicUserID");
			Log.info("Tab title contains PublicUserID");

		} else if (Request_tab_title.contains(correlationIDcommoninfo)) {
			System.out.println("Tab title contains CorrelationID");
			Log.info("Tab title contains CorrelationID");
		} else {
			// System.out.println("Tab title : " + Request_tab_title);
			// Log.info("Tab title : " + Request_tab_title);
			System.err.println(
					"Tab title doesn't contain Customer Name/ CorrelationID/PublicUserID  " + Request_tab_title);
			Log.error("Tab title doesn't contain Customer Name/ CorrelationID/PublicUserID  " + Request_tab_title);

		}

		CommonMethods.captureScreenshot(URLConfigs.SCREENSHOT_PATH + "\\" + Servicetype + " - Request Details Page"
				+ "_" + SeleniumDriver.timestamp() + ".png");
	}
}
