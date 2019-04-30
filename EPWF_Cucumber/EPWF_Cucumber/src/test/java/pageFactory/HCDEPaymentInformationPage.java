package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HCDEPaymentInformationPage {
	
	@FindBy(name="paymentMethod")
	private static WebElement paymentMethodComboBox;
	
	@FindBy(name = "routingNum")
	private static WebElement routingNumberTextBox;
	
	@FindBy(name = "bankAccntNum")
	private static WebElement accountNumberTextBox;
	
	@FindBy(name = "custName")
	private static WebElement cardNameTextBox;
		
	@FindBy(xpath = "//*[@name='cardNum']")
	private static WebElement cardNumberTextBox;
	
	@FindBy(name = "cardZip")
	private static WebElement zipcodeTextBox;
	
	@FindBy(name="zip")
	private static WebElement zipTextBox;
	
	@FindBy(id = "expiryMonth")
	private static WebElement expiryMonthComboBox;
	
	@FindBy(id = "expiryYear")
	private static WebElement expiryYearComboBox;
	
	@FindBy(xpath = "//input[@id='DateOfPayment']")
	private static WebElement dateOfPaymentTextbox;
	
	@FindBy(xpath="//*[contains(@onclick,'TCCheckbox')]")
	private static WebElement iAgreeCheckbox;
	
	@FindBy(name="savePaymentMethod")
	private static WebElement saveCheckbox;
	
	/*@FindBy(name = "Next")
	private static WebElement nextButton;*/
	
	@FindBy(xpath = "//input[@value='Next']")
	private static WebElement nextButton;

	
	@FindBy(id="PaymentAmount")
	private static WebElement amountPaidTextBox;
	
	@FindBy(xpath="(//input[@value='Place My Order Securely'])")
	private static WebElement placeMyOrderSecurelyBtn;
	
	@FindBy(id = "submitPayment")
	private static WebElement SubmitPayment;
	
	@FindBy(xpath = "//input[@id='Continue']")
	private static WebElement Continue;
	
	//@FindBy(xpath = "//input[@value='Save']")
		@FindBy(xpath = "//input[contains(@value,'Save')]")
		private static WebElement SaveButton;
		
		@FindBy(xpath = "(//a[contains(text(),'Cancel')])[2]")
		private static WebElement CancelButton;
		
		@FindBy(xpath = "//a[contains(text(),'use a credit or debit card')]")
		private static WebElement PaymentbyCard;
		
		@FindBy(xpath = "//a[contains(text(),'No Fee - Pay With Bank Account')]")
		private static WebElement PaymentMethod_ACH;
		
		@FindBy(xpath = "//a[contains(text(),'Fee - Pay With Credit or Debit Card')]")
		private static WebElement PaymentMethod_CARD;
		
		@FindBy(xpath = "//select[@id='MethodOfPayment']")
		private static WebElement MethodOfPayment;
		
		@FindBy(xpath = "(//a[contains(text(),'Edit')])[1]")
		private static WebElement EditButton;
		
		@FindBy(xpath = "(//a[contains(text(),'Delete')])[1]")
		private static WebElement DeleteButton;
		

		@FindBy(xpath = "//input[contains(@value,'Yes, Delete')]")
		private static WebElement YesDelete;
		
		@FindBy(id="Close")
		private static WebElement CloseButton;
		
		@FindBy(xpath = "//a[contains(.,'I Agree')]")
		private static WebElement I_Agree_Button;
		
		@FindBy(xpath = "//input[@value='Save Changes']")
		private static WebElement SaveChangesButton;
		
		@FindBy(xpath = ".//*[@id='walletForm']/div/table/tbody/tr[2]/td[2]/p[2]")
		private static WebElement UpdatedDate;
		
		@FindBy(xpath = "//input[@value='Done']")
		private static WebElement DoneButton;
		
		@FindBy(xpath = "//a[contains(.,'Update My Payment Method')]")
		private static WebElement UpdateMyPaymentMethod;
		
		//@FindBy(xpath = ".//*[@id='autoPayForm']/div[1]/a[2]")
		@FindBy(xpath = "//a[contains(.,'Replace This Payment Account')]")
		private static WebElement ReplaceThisPaymentAccount;
		
		@FindBy(xpath = "//img[contains(@id,'card-img-id')]")
		private static WebElement CreditDebit;
		
		@FindBy(xpath = "//input[@id='nameOnCard']")
		private static WebElement nameOnCard;
		
		@FindBy(xpath = "//input[@id='cardNum']")
		private static WebElement cardNum;
		
		@FindBy(xpath = "//input[contains(@id,'managePaymentForm.cardZip')]")
		private static WebElement cardZip;
		
		@FindBy(xpath = "//a[contains(.,'Next')]")
		private static WebElement Next;
		
		@FindBy(xpath = "//a[contains(.,'Submit')]")
		private static WebElement Submit;
		
		@FindBy(xpath = "//select[@id='managePaymentForm.expiryMonth']")
		private static WebElement expiryMonth;
		
		@FindBy(xpath = "//select[@id='managePaymentForm.expiryYear']")
		private static WebElement expiryYear;
		
		@FindBy(xpath = "//span[contains(@onclick,'javascript:enableTCCheckboxSpeedPay()')]")
		private static WebElement IAgreeCheckboxSpeedPay;
		
		@FindBy(xpath = "//span[contains(@onclick,'javascript:enableCardCheckbox()')]")
		private static WebElement SavethePaymentMethodCheckbox;

		public static WebElement getSavethePaymentMethodCheckbox(){
			return SavethePaymentMethodCheckbox;
		}
		
		public static WebElement getIAgreeCheckboxSpeedPay(){
			return IAgreeCheckboxSpeedPay;
		}
		
	    public static WebElement getexpiryYear(){
			return expiryYear;
		}
		
		public static WebElement getexpiryMonth(){
			return expiryMonth;
		}
		
		
		public static WebElement getSubmit(){
			return Submit;
		}
		
		public static WebElement getNext(){
			return Next;
		}
		
		public static WebElement getcardZip(){
			return cardZip;
		}
		
		public static WebElement getcardNum(){
			return cardNum;
		}
		
		public static WebElement getnameOnCard(){
			return nameOnCard;
		}
		
		public static WebElement getCreditDebit(){
			return CreditDebit;
		}
		
		public static WebElement getReplaceThisPaymentAccount(){
			return ReplaceThisPaymentAccount;
		}
		
		public static WebElement getUpdateMyPaymentMethod(){
			return UpdateMyPaymentMethod;
		}

		public static WebElement getDoneButton(){
			return DoneButton;
		}
		
		public static WebElement getUpdatedDate(){
			return UpdatedDate;
		}

		public static WebElement getSaveChangesButton(){
			return SaveChangesButton;
		}
		
		public static WebElement getI_Agree_Button (){
			return I_Agree_Button;
		}
		
		public static WebElement getCloseButton(){
			return CloseButton;
		}
		
		public static WebElement getYesDeleteButton(){
			return YesDelete;
		}
		
		public static WebElement getDeleteButton(){
			return DeleteButton;
		}
		
		public static WebElement getEditButton(){
			return EditButton;
		}
		public static WebElement getMethodOfPayment(){
			return MethodOfPayment;
		}
		
		public static WebElement getPaymentMethod_ACH(){
			return PaymentMethod_ACH;
		}

		public static WebElement getPaymentMethod_CARD(){
			return PaymentMethod_CARD;
		}
		
		public static WebElement getPaymentbyCardLink(){
			return PaymentbyCard;
		}

		public static WebElement getCancelButton(){
			return CancelButton;
		}

	public static WebElement getSaveCheckbox(){
		return saveCheckbox;
	}
	public static WebElement getCardNameTextBox(){
		return cardNameTextBox;
	}
	public static WebElement getIAgreeCheckbox() {
		return iAgreeCheckbox;
	}

	public static WebElement getDateOfPaymentTextbox() {
		return dateOfPaymentTextbox;
	}

	
	public static WebElement getAmountPaidTextBox() {
		return amountPaidTextBox;
	}


	public static WebElement getPaymentMethodComboBox() {
		return paymentMethodComboBox;
	}

	public static WebElement getRoutingNumberTextBox() {
		return routingNumberTextBox;
	}

	public static WebElement getAccountNumberTextBox() {
		return accountNumberTextBox;
	}

	public static WebElement getCardNumberTextBox() {
		return cardNumberTextBox;
	}

	public static WebElement getZipcodeTextBox() {
		return zipcodeTextBox;
	}

	public static WebElement getExpiryMonthComboBox() {
		return expiryMonthComboBox;
	}

	public static WebElement getExpiryYearComboBox() {
		return expiryYearComboBox;
	}

	
	public static WebElement getNextButton() {
		return nextButton;
	}
	
	public static WebElement getContinue() {
		return Continue;
	}
	
	public static WebElement getzipTextBox(){
		return zipTextBox;
	}
	
	public static WebElement getPlaceMyOrderSecurelyBtn(){
		return placeMyOrderSecurelyBtn;
	}
	
	public static WebElement getSubmitPaymentButton() {
		return SubmitPayment;
	}
	public static WebElement getSaveButton() {
		return SaveButton;
	}

	//------------------------------------------------------------------
		@FindBy(id="BankAcctType")
			private static WebElement accountdropdown_update;
			
			public static WebElement getaccountdropdown() {
				return accountdropdown_update;
			}
			
			@FindBy(id="reviewAch")
			   private static WebElement nextButton_PaymentInformation;
				public static WebElement clickNextButton()
				{
					return nextButton_PaymentInformation;
				}
				
				@FindBy(id="submitAch")
				   private static WebElement savebutton_PaymentInformation;
					public static WebElement clicksaveButton()
					{
						return savebutton_PaymentInformation;
					}
					
					@FindBy(id="done")
					   private static WebElement donebutton_PaymentInformation;
						public static WebElement doneButton()
						{
							return donebutton_PaymentInformation;
						}

	
}
