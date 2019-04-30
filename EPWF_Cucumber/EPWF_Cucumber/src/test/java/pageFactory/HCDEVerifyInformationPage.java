package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HCDEVerifyInformationPage {
	
	@FindBy(id = "submitPayment")
	private static WebElement submitPaymentButton;
	
	@FindBy(xpath="//body[contains(text(),'$orderingInfo.creditCardInfo.setProcessCC(\"Paid\")')]")
	private static WebElement paymentConfirmationText;
	
	@FindBy(xpath = "//a[contains(@href,'cancel')]")
	private static WebElement cancelLink;
	
	@FindBy(xpath = "//a[contains(@href,'makeChanges')]")
	private static WebElement makeChangesLink;

	public static WebElement getSubmitPaymentButton() {
		return submitPaymentButton;
	}

	public static WebElement getCancelLink() {
		return cancelLink;
	}

	public static WebElement getMakeChangesLink() {
		return makeChangesLink;
	}
	
	public static WebElement getpaymentConfirmationText(){
		return paymentConfirmationText;
	}
}
