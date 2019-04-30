package InterfaceExamples;

public class HSBCBank implements USBank,UKBank{//multiple inheritance 
	//Is a relationship class and interface using implements
	//has a relation ----between classes using extends 
	
	//if a class is implementing interface then it should define/override all the methods from the interface
	
	public void credit(){
		System.out.println("Amount credited");
	}

	public void debit(){
		System.out.println("Amount debited");
	}
	public void transferMoney(){
		System.out.println("Amount transfered");
	}

	
	public void carLoan(){
		System.out.println("Car lona given");
	}
	public void educationLoan(){
		System.out.println("education loan given");
	}

	
	public void netbanking() {
		System.out.println("netbanking option is available to UKBanks");	
	}
}
