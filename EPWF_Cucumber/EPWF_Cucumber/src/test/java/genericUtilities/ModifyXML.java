package genericUtilities;

import java.io.IOException;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;


public class ModifyXML extends GlobalVariables {
    private static Map<String, String> tagsToChange;
	private static Map<String, ArrayList<String>> tagsToChangeForMultiPayment;
	CommonMethods commonMethods = new CommonMethods();
	
	// Modify XML for submit payment
	public void modifyForSubmitPayment(String submitPaymentXMLFilePath)
			throws SQLException, ParserConfigurationException, SAXException,
			IOException, TransformerException, InterruptedException {
	
		setUpAdditionalDataUsingInputChannel(ex_InputChannel);
		setUpAdditionalDataUsingBTN(ex_BTN_BAID);
		createMapForSubmitPayment();
		commonMethods.modifyXML(submitPaymentXMLFilePath, tagsToChange);
		
		
	}
	
	public void modifyForMultiPayment(String multiPaymentXMLFilePath) throws SQLException, ParserConfigurationException, SAXException, IOException, TransformerException, InterruptedException{

		setUpAdditionalDataUsingInputChannel(ex_InputChannel);
		setUpAdditionalDataUsingMultipleBTN(ex_QportalBTN);
		//System.out.println(ex_QportalBTN);
		createMapForMultiPayment();
		commonMethods.modifyXMLForMultiPaymentBTN(multiPaymentXMLFilePath, tagsToChangeForMultiPayment);
		//commonMethods.modifyXML(multiPaymentXMLFilePath, tagsToChange);
	}

	/*// Modify XML for wallet management
	public void modifyForwalletManagement(
			String walletManagementXMLFilePath) throws SQLException,
			ParserConfigurationException, SAXException, IOException,
			TransformerException {
		setUpAdditionalDataUsingInputChannel(ex_InputChannel);
		setUpAdditionalDataUsingBTN(GlobalVariables.ex_BTN);
		createMapForWalletManagement();
		commonMethods.modifyXML(walletManagementXMLFilePath, tagsToChange);
	}
	// Modify XML for submit Payment CPAL  
	public void modifyForSubmitPaymentCPAL(String submitPaymentXMLFilePath)
			throws SQLException, ParserConfigurationException, SAXException,
			IOException, TransformerException {
		setUpAdditionalDataUsingInputChannel(ex_InputChannel);
		setUpAdditionalDataUsingBTN(ex_InputChannel);
		createMapForSubmitPaymentCPAL();
		commonMethods.modifyXML(submitPaymentXMLFilePath, tagsToChange);
	}


	// Modify XML for account lookup
	public void modifyForAccountLookup(String accountLookupXMLFilePath)
			throws SQLException, ParserConfigurationException, SAXException,
			IOException, TransformerException {
		setUpAdditionalDataUsingInputChannel(ex_InputChannel);
		setUpAdditionalDataUsingBTN(ex_BTN);
		createMapForAccountLookup();
		commonMethods.modifyXML(accountLookupXMLFilePath, tagsToChange);
	}

	// Modify XML for Refund Payment
	public void modifyForRefundPayment(String refundXMLFilePath)
			throws ParserConfigurationException, SAXException, IOException,
			TransformerException {
		createMapForRefundPayment();
		commonMethods.modifyXML(refundXMLFilePath, tagsToChange);
	}

	// Modify XML for update Payment
	public void modifyUpdatePayment(String updatePaymentXMLFilePath)
			throws ParserConfigurationException, SAXException, IOException,
			TransformerException {
		createMapForUpdatePayment();
		commonMethods.modifyXML(updatePaymentXMLFilePath, tagsToChange);
	}
	
	//Modify XML for Multi Payment
	public void modifyMultiPayment(String multiPaymentXMLFilePath,ArrayList<String> btnArrayList) throws SQLException, ParserConfigurationException, SAXException, IOException, TransformerException{
		setUpAdditionalDataUsingInputChannel(GlobalVariables.Ex_inputChannelValue);
		setUpAdditionalDataUsingBTN(btnArrayList.get(0));
		createMapForMultiPayment(btnArrayList);
		commonMethods.modifyXMLForMultiPaymentBTN(multiPaymentXMLFilePath, tagsToChangeForMultiPayment);
		commonMethods.modifyXML(multiPaymentXMLFilePath, tagsToChange);
	}
	
	// Modify XML for pos payment
			public void modifyForPOSPayment(String posPaymentXMLPAth) throws SQLException,
					ParserConfigurationException, SAXException, IOException,
					TransformerException{
				setUpAdditionalDataUsingInputChannel(GlobalVariables.Ex_inputChannelValue);
				setUpAdditionalDataUsingBTN(GlobalVariables.Ex_btnValue);
				createMapForPOSPayment();
				commonMethods.modifyXML(posPaymentXMLPAth, tagsToChange);
			}	
	
	//modify XML for POS Refund
			public void modifyForPOSRefund(String posRefundXMLPAth) throws SQLException,
			ParserConfigurationException, SAXException, IOException,
			TransformerException{
		createMapForPOSRefund();
		commonMethods.modifyXML(posRefundXMLPAth, tagsToChange);
	}	
			
	//modify XML for Autopay
			public void modifyForAutopay(String deEnrollmentXMLPath) throws SQLException,
									ParserConfigurationException, SAXException, IOException, TransformerException{
				System.out.println(GlobalVariables.Ex_inputChannelValue);
				setUpAdditionalDataUsingInputChannel(GlobalVariables.Ex_inputChannelValue);
				setUpAdditionalDataUsingBTN(GlobalVariables.Ex_btnValue);
				createMapForAutopay();
				commonMethods.modifyXML(deEnrollmentXMLPath, tagsToChange);
			}
			
			
	//modify xml for detokaniozation
			public void modifyForDetokaniztion(String deTokenizationPath) throws Exception{
				createMapForDetokenization();
				commonMethods.modifyXML(deTokenizationPath, tagsToChange);
			}
			
	//modify xml for authorize payment
			public void modifyForAuthorizePayment(String authorizePaymentPath) throws Exception{
				createMapForAuthorizePayment();
				commonMethods.modifyXML(authorizePaymentPath, tagsToChange);
			}
			
			//modify xml for void payment
			public void modifyForVoidPayment(String voidPaymentPath) throws Exception{
				createMapForVoidPayment();
				commonMethods.modifyXML(voidPaymentPath, tagsToChange);
			}
			
		//modify for payment history
			public void modifyForPaymentHistory(String paymentHistoryXMLFilePath) 
					throws SQLException, ParserConfigurationException, SAXException, 
					IOException, TransformerException{
				setUpAdditionalDataUsingBTN(GlobalVariables.Ex_btnValue);
				createMapForPaymentHistory();
				commonMethods.modifyXML(paymentHistoryXMLFilePath, tagsToChange);
			}
			
			public void modifyForUpdateWallet(String updateWalletXMLFilePath) 
					throws SQLException, ParserConfigurationException, SAXException, 
					IOException, TransformerException{
				setUpAdditionalDataUsingInputChannel(GlobalVariables.Ex_inputChannelValue);
				setUpAdditionalDataUsingBTN(GlobalVariables.Ex_btnValue);
				createMapForUpdateWallet();
				commonMethods.modifyXML(updateWalletXMLFilePath, tagsToChange);
			}
			
			
			public void modifyForRetrieveWallet(String retrieveWalletXMLFilePath) 
					throws SQLException, ParserConfigurationException, SAXException, 
					IOException, TransformerException{
				createMapForRetrieveWallet();
				commonMethods.modifyXML(retrieveWalletXMLFilePath, tagsToChange);
			}

			
			
			
			//create map for retreive wallet
			private void createMapForRetrieveWallet(){
				GlobalVariables.currDateTime = commonMethods.getCurrentDateTime("yyyyMMddHHmmss");
				tagsToChange = new HashMap<String, String>();
				tagsToChange.put(GlobalVariables.updWal_WalletRefNumTag, GlobalVariables.Ex_WalletRefNumvalue);
				tagsToChange.put(GlobalVariables.updWal_BillingAppIDTag, GlobalVariables.billAppId);
				tagsToChange.put(GlobalVariables.updWal_CustomerTypeTag, GlobalVariables.Ex_CustomerTypeValue);
				tagsToChange.put(GlobalVariables.updWal_billingAccntRegion, GlobalVariables.billAcctRegion);
				tagsToChange.put(GlobalVariables.updWal_requestIDTag,
								GlobalVariables.currDateTime);
			}
			
			//create map for payment history
			private void createMapForPaymentHistory(){
				GlobalVariables.currDateTime = commonMethods.getCurrentDateTime("yyyyMMddHHmmss");
				tagsToChange = new HashMap<String, String>();
			//	tagsToChange.put(GlobalVariables.his_paramValue, GlobalVariables.Ex_btnValue);
				tagsToChange.put(GlobalVariables.act_RequestIDTag,
						GlobalVariables.currDateTime);
			}
	
			// create map for submit payment CPAL
			private void createMapForSubmitPaymentCPAL() {
				GlobalVariables.currDateTime = commonMethods.getCurrentDateTime("yyyyMMddHHmmss");
				tagsToChange = new HashMap<String, String>();
				tagsToChange.put(GlobalVariables.subcpal_BTNTag,
						GlobalVariables.Ex_btnValue);
				tagsToChange.put(GlobalVariables.subcpal_RegionTag,
						GlobalVariables.billAcctRegion);
				tagsToChange.put(GlobalVariables.subcpal_BillingAppIDTag,
						GlobalVariables.billAppId);
				tagsToChange.put(GlobalVariables.subcpal_DestAppIDTag,
						GlobalVariables.destAppId);
				tagsToChange.put(GlobalVariables.subcpal_InputChannelIDTag,
						GlobalVariables.Ex_inputChannelValue);
				tagsToChange.put(GlobalVariables.subcpal_MsgSourceSysTag,
						GlobalVariables.msgSourceSysId);
				tagsToChange.put(GlobalVariables.subcpal_SourceAppIDTag,
						GlobalVariables.sourceAppId);
				tagsToChange.put(GlobalVariables.subcpal_CustomerTypeTag,
						GlobalVariables.Ex_CustomerTypeValue);
				tagsToChange.put(GlobalVariables.subcpal_PaymentScheduleTypeTag,
						GlobalVariables.Ex_PaymentScheduleTypeValue);
				tagsToChange.put(GlobalVariables.subcpal_RequestIDTag,
						GlobalVariables.currDateTime);
			}

	// Create map for account lookup
	private void createMapForAccountLookup() {
		GlobalVariables.currDateTime = commonMethods.getCurrentDateTime("yyyyMMddHHmmss");
		tagsToChange = new HashMap<String, String>();
		tagsToChange.put(GlobalVariables.act_BTNTag,
				GlobalVariables.Ex_btnValue);
		tagsToChange.put(GlobalVariables.act_BillingAppIDTag,
				GlobalVariables.billAppId);
		tagsToChange.put(GlobalVariables.act_InputChannelIDTag,
				GlobalVariables.Ex_inputChannelValue);
		tagsToChange.put(GlobalVariables.act_MsgSourceSysTag,
				GlobalVariables.msgSourceSysId);
		tagsToChange.put(GlobalVariables.act_SourceAppIDTag,
				GlobalVariables.sourceAppId);
		tagsToChange.put(GlobalVariables.act_RequestIDTag,
				GlobalVariables.currDateTime);
	}

	// create map for update payment
	private void createMapForUpdatePayment() {
		GlobalVariables.currDateTime = commonMethods.getCurrentDateTime("yyyyMMddHHmmss");
		tagsToChange = new HashMap<String, String>();
		tagsToChange.put(GlobalVariables.upd_paymentIDTag,
				GlobalVariables.paymentIDValue);
		tagsToChange.put(GlobalVariables.upd_requestTag,
				GlobalVariables.currDateTime);
	}*/

	// create map for submit payment
	private void createMapForSubmitPayment() {
		
		currentDateTime = commonMethods.getCurrentDateTime("yyyyMMddHHmmss");
		tagsToChange = new HashMap<String, String>();
		tagsToChange.put(tagBTN,ex_BTN_BAID);
		//for AccountLookUp
		tagsToChange.put(tagBillingAcctId,ex_BTN_BAID);
		tagsToChange.put(tagBillingAccntId,ex_BTN_BAID);
		tagsToChange.put(tagBillngAccntId,ex_BTN_BAID);
		
		tagsToChange.put(tagBillingAccountRegion,billAcctRegion);
		tagsToChange.put(tagBillingAppID,billAppId);
		tagsToChange.put(tagDestinationAppId,destAppId);
		tagsToChange.put(tagInputChannelId,ex_InputChannel);
		tagsToChange.put(tagMsgSourceSysTag,msgSourceSysId);
		tagsToChange.put(tagSourceAppID,sourceAppId);
		tagsToChange.put(tagCustomerType,ex_CustomerType);
		tagsToChange.put(tagUserID,ex_UserId);
		tagsToChange.put(tagVendorPayment,commonMethods.getRandomNumber(13));
		tagsToChange.put(tagInputChannel_Marlie,ex_InputChannel);
		tagsToChange.put(tagCustomerType_Marlie,ex_CustomerType);
		tagsToChange.put(tagPaymentID_REfund,paymentId);
        tagsToChange.put(tagPaymentScheduleType,paymentScheduleType );
		tagsToChange.put(tagPaymentInstrumentReferenceId,TokenID);
		//tagsToChange.put(tagBAID,billAppId);
		tagsToChange.put(tagPaymentAmt_REfund,PaymentAmt);
		tagsToChange.put(tagTotalTaxAmt_REfund,TotalTaxAmt);
		
		if(scenarioName.contains("TCAT_Token"))
		{
			tagsToChange.put(tagWalletRef,TokenID);
			tagsToChange.put(tagPaymentInstrumentReferenceId,TokenID);
		}

		if(scenarioName.contains("Refund")){
			tagsToChange.put(tagConvenienceFeeAmt_REfund,ConvenienceFeeAmt);
		}
		
		if(scenarioName.contains("ACH")){
			tagsToChange.put(tagPaymentMethodCode,"ACH");
		}
		else
		{
			tagsToChange.put(tagPaymentMethodCode,"CARD");
		}
        if(scenarioName.contains("CONPORT")){
			
			tagsToChange.put(tagBAID,"PPP");
		}
		else
		{
			tagsToChange.put(tagBAID,billAppId);
		}

		
		if(scenarioName.contains("Scheduled")&&scenarioName.contains("Ensemble")){
			tagsToChange.put(tagPaymentScheduleType,paymentScheduleType);
		}
		if(scenarioName.contains("Scheduled")&&scenarioName.contains("Ensemble")){
			tagsToChange.put(tagPaymentProcessDateTime,ex_PaymentProcessDate+time);
		}
		//tagsToChange.put(tagRequestID,currentDateTime);
		
	}
	
	private void createMapForMultiPayment(){
		
		tagsToChangeForMultiPayment = new HashMap<String, ArrayList<String>>();
		tagsToChange = new HashMap<String, String>();
		tagsToChangeForMultiPayment.put(mul_BillAccntIDTag,ex_QportalBTN);
		tagsToChangeForMultiPayment.put(mul_BillAccntRegionTag, ex_QportalBillAcctRegion);
		tagsToChangeForMultiPayment.put(mul_BillAppIDTag, ex_QportalBillAppId);
		tagsToChangeForMultiPayment.put(mul_DestinationAppIDTag, ex_QportalDestAppId);
		//tagsToChangeForMultiPayment.put(mul_CustomerTypeTag, ex_QportalCustomerType);
		tagsToChange.put(mul_DestinationAppIDTag,destAppId);
		tagsToChange.put(mul_InputChannelTag, ex_InputChannel);
		tagsToChange.put(mul_MsgSourceSystemTag, msgSourceSysId);
		tagsToChange.put(mul_SourceApplicationTag, sourceAppId);
		tagsToChangeForMultiPayment.put(mul_PaymentAmtTag, commonMethods.getAmountToBePaidForQportal());
		tagsToChange.put(mul_RequestIDTag, commonMethods.getCurrentDateTime("yyyyMMddHHmmss"));
		tagsToChangeForMultiPayment.put(mul_PaymentProcessDateTag, ex_QportalPaymentProcessDt);
		
	}

	/*// create Map for refund payment
	private void createMapForRefundPayment() {
		GlobalVariables.currDateTime = commonClass.getCurrentDateTime("yyyyMMddHHmmss");
		tagsToChange = new HashMap<String, String>();
		tagsToChange.put(GlobalVariables.ref_OriginalPaymentIDTag,
				GlobalVariables.Ex_originalPaymentIDValue);
		tagsToChange.put(GlobalVariables.ref_ConvinienceFeeAmtTag,
				GlobalVariables.Ex_convFeeAmtValue);
		System.out.println("Refund Amt:"+GlobalVariables.Ex_refundAmtValue);
		tagsToChange.put(GlobalVariables.ref_RefundPaymentAmtTag,
				GlobalVariables.Ex_refundAmtValue);
		tagsToChange.put(GlobalVariables.ref_TotalTaxAmtTag,
				GlobalVariables.Ex_totalTaxAmtValue);
		tagsToChange.put(GlobalVariables.ref_RefundReasonCode,
				GlobalVariables.Ex_refundReasonCodeValue);
		tagsToChange.put(GlobalVariables.ref_RequestIDTag,
				GlobalVariables.currDateTime);
	}

	// create map for wallet management
	private void createMapForWalletManagement() {
		tagsToChange = new HashMap<String, String>();
		tagsToChange.put(GlobalVariables.mng_BTNTag,
				GlobalVariables.Ex_btnValue);
		tagsToChange.put(GlobalVariables.mng_RegionTag,
				GlobalVariables.billAcctRegion);
		tagsToChange.put(GlobalVariables.mng_BillingAppIDTag,
				GlobalVariables.billAppId);
		tagsToChange.put(GlobalVariables.mng_WalletTypeTag,
				GlobalVariables.Ex_WalletTypeValue);
		tagsToChange.put(GlobalVariables.mng_MsgSourceSysTag,
				GlobalVariables.msgSourceSysId);
		tagsToChange.put(GlobalVariables.mng_RequestIDTag,
				commonClass.getCurrentDateTime("yyyyMMddHHmmss"));
	}
	
	//Create map for MultiPayment
	private void createMapForMultiPayment(ArrayList<String> btnArrayList){
		tagsToChangeForMultiPayment = new HashMap<String, ArrayList<String>>();
		tagsToChange = new HashMap<String, String>();
		tagsToChangeForMultiPayment.put(GlobalVariables.mul_BillAccntIDTag, btnArrayList);
		tagsToChange.put(GlobalVariables.mul_BillAccntRegionTag, GlobalVariables.billAcctRegion);
		tagsToChange.put(GlobalVariables.mul_BillAppIDTag, GlobalVariables.billAppId);
		tagsToChange.put(GlobalVariables.mul_CustomerTypeTag, GlobalVariables.Ex_CustomerTypeValue);
		tagsToChange.put(GlobalVariables.mul_DestinationAppIDTag, GlobalVariables.destAppId);
		tagsToChange.put(GlobalVariables.mul_InputChannelTag, GlobalVariables.Ex_inputChannelValue);
		tagsToChange.put(GlobalVariables.mul_MsgSourceSystemTag, GlobalVariables.msgSourceSysId);
		tagsToChange.put(GlobalVariables.mul_SourceApplicationTag, GlobalVariables.sourceAppId);
		tagsToChange.put(GlobalVariables.mul_PaymentAmtTag, commonClass.getRandomNumber(2)+".00");
		tagsToChange.put(GlobalVariables.mul_RequestIDTag, commonClass.getCurrentDateTime("yyyyMMddHHmmss"));
		tagsToChange.put(GlobalVariables.mul_PaymentProcessDateTag, commonClass.getCurrentDateTime("yyyy-MM-dd"));
	}
	
	
	// create map for POSPayment
			private void createMapForPOSPayment() {
				tagsToChange = new HashMap<String, String>();
				tagsToChange.put(GlobalVariables.sub_BTNTag,
						GlobalVariables.Ex_btnValue);
				tagsToChange.put(GlobalVariables.sub_RegionTag,
						GlobalVariables.billAcctRegion);
				tagsToChange.put(GlobalVariables.sub_BillingAppIDTag,
						GlobalVariables.billAppId);
				tagsToChange.put(GlobalVariables.sub_DestAppIDTag,
						GlobalVariables.destAppId);
				tagsToChange.put(GlobalVariables.sub_InputChannelIDTag,
						GlobalVariables.Ex_inputChannelValue);
				tagsToChange.put(GlobalVariables.sub_MsgSourceSysTag,
						GlobalVariables.msgSourceSysId);
				tagsToChange.put(GlobalVariables.sub_SourceAppIDTag,
						GlobalVariables.sourceAppId);
				tagsToChange.put(GlobalVariables.sub_RequestIDTag,
						commonClass.getCurrentDateTime("yyyyMMddHHmmss"));
				tagsToChange.put(GlobalVariables.pos_VendorPaymentID,
						GlobalVariables.vandorPaymentID);
			}
			
	//create mao for POSRefund
			private void createMapForPOSRefund(){
				GlobalVariables.currDateTime = commonClass.getCurrentDateTime("yyyyMMddHHmmss");
				tagsToChange = new HashMap<String, String>();
				tagsToChange.put(GlobalVariables.sub_RequestIDTag,
						commonClass.getCurrentDateTime("yyyyMMddHHmmss"));
				tagsToChange.put(GlobalVariables.pos_VendorPaymentID,
						GlobalVariables.vandorPaymentID);
			}
			
	//create map for Autopay_deEnrollment()
			private void createMapForAutopay(){
				GlobalVariables.currDateTime = commonClass.getCurrentDateTime("yyyyMMddHHmmss");
				tagsToChange = new HashMap<String, String>();
				tagsToChange.put(GlobalVariables.autopay_BTNTag,
						GlobalVariables.Ex_btnValue);
				tagsToChange.put(GlobalVariables.autopay_BillingAppIDTag,
						GlobalVariables.billAppId);
				tagsToChange.put(GlobalVariables.autopay_InputChannelIDTag,
						GlobalVariables.Ex_inputChannelValue);
				tagsToChange.put(GlobalVariables.autopay_RequestIDTag,
						GlobalVariables.currDateTime);
				tagsToChange.put(GlobalVariables.autopay_MsgSourceSysTag,
						GlobalVariables.msgSourceSysId);
				tagsToChange.put(GlobalVariables.autopay_SourceAppIDTag,
						GlobalVariables.sourceAppId);			
			}

			private void createMapForDetokenization(){
				tagsToChange = new HashMap<String, String>();
				tagsToChange.put(GlobalVariables.detoken_TokenNum,
						GlobalVariables.tokenNum);
			}
			
			private void createMapForAuthorizePayment(){
				tagsToChange = new HashMap<String, String>();
				tagsToChange.put(GlobalVariables.detoken_TokenNum,
						GlobalVariables.tokenNum);
			}
			
			private void createMapForVoidPayment(){
				tagsToChange = new HashMap<String, String>();
				tagsToChange.put(GlobalVariables.voidPay_PIDTag,
						GlobalVariables.PID);
			}
			
			private void createMapForUpdateWallet(){
				GlobalVariables.currDateTime = commonClass.getCurrentDateTime("yyyyMMddHHmmss");
				tagsToChange = new HashMap<String, String>();
				tagsToChange.put(GlobalVariables.updWal_WalletRefNumTag, GlobalVariables.Ex_WalletRefNumvalue);
				tagsToChange.put(GlobalVariables.updWal_InstrumentIDTag, GlobalVariables.Ex_InstrumentIDvalue);
				tagsToChange.put(GlobalVariables.updWal_ExpiryDateTag, GlobalVariables.Ex_ExpiryDatevalue);
				tagsToChange.put(GlobalVariables.updWal_BTNTag,GlobalVariables.Ex_btnValue);
				tagsToChange.put(GlobalVariables.sub_RequestIDTag,commonClass.getCurrentDateTime("yyyyMMddHHmmss"));
				tagsToChange.put(GlobalVariables.updWal_BillingAppIDTag, GlobalVariables.billAppId);
				tagsToChange.put(GlobalVariables.updWal_CustomerTypeTag, GlobalVariables.Ex_CustomerTypeValue);
				tagsToChange.put(GlobalVariables.updWal_billingAccntRegion, GlobalVariables.billAcctRegion);
				
			}
			*/
				
			
			
			
			
	// set up additional data using input channel
	private void setUpAdditionalDataUsingInputChannel(String InputChannel)
			throws SQLException, InterruptedException {
		
		try {
			commonMethods.queryResultFromDB(projCodeDefSourceAppQuery
						+ ex_InputChannel + "'");
		} catch (Exception e) {
			 System.out.println("got interrupted!");
		}
		while (queryResult.next()) {
			sourceAppId = queryResult
					.getString("SOURCE_APPLICATION_CD");
			msgSourceSysId = sourceAppId;
		}
		
	}

	// set up additional data using BTN
	private void setUpAdditionalDataUsingBTN(String BTN) {
		
		int BTNLength = BTN.length();
		switch (BTNLength) {
		case 13:
			billAcctRegion = "IR";
			billAppId = "CRIS";
			destAppId = "XCASH";
			break;

		case 9:
			billAcctRegion = "CTL";
			billAppId = "ENS";
			destAppId = "ENJ";
			break;

		case 8:
			billAcctRegion = "OOR";
			billAppId = "LATIS";
			destAppId = "ARMS";
			break;
		
	   case 11:
		//billAcctRegion = "OOR";
		billAppId = "PPP";
		//destAppId = "ARMS";
		break;
		}

	}
	
	
	// set up additional data using MultipleBTN
	private void setUpAdditionalDataUsingMultipleBTN(ArrayList<String> BTN) {
        
        for(int i=0; i<BTN.size(); i++)
        {    
        	int BTNLength= BTN.get(i).length();
        	     
				switch (BTNLength) {
				 
				case 13:
					ex_QportalBillAcctRegion.add("IR");
					ex_QportalBillAppId.add("CRIS");
					ex_QportalDestAppId.add("XCASH");
					break;
			
				case 9:
					ex_QportalBillAcctRegion.add("CTL");
					ex_QportalBillAppId.add("ENS");
					ex_QportalDestAppId.add("ENJ");
					break;
			
				case 8:
					ex_QportalBillAcctRegion.add("OOR");
					ex_QportalBillAppId.add("LATIS");
					ex_QportalDestAppId.add("ARMS");
					break;

				}

        }
	}
	
}
