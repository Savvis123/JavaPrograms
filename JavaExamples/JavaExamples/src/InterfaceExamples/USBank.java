package InterfaceExamples;

public interface USBank {
	/*
	 * only method declaration
       no method body - only method prototype
       in interface, we can declare the variables ,variables are by default static in nature
       variables values will not be changed
       no static methods in interface as it is part of oop
       no main method
       we can't create object for interface as interface is abstract in nature
	 */
	int min_bal=1000;
	public void credit();
	public void debit();
	public void transferMoney();
	

}
