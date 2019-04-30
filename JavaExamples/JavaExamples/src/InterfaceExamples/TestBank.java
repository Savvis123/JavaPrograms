package InterfaceExamples;

public class TestBank {
	
	public static void main(String args[])
	{
		
		System.out.println(USBank.min_bal);
		HSBCBank bank=new HSBCBank();
		bank.credit();
		bank.debit();
		bank.transferMoney();
		bank.carLoan();
		bank.educationLoan();
		bank.netbanking();
		//dynamic polymorphism
		//chaild class object can be reffered by parent interface reference variable
		USBank u=new HSBCBank();
		u.credit();
		u.debit();
		u.transferMoney();
	}
}
