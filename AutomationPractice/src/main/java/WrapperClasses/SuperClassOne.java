package WrapperClasses;

public class SuperClassOne extends SuperClass {

	public SuperClassOne() {
		super(10);//it will call SuperClass constructor
		
	}

	public void SuperClassmethodTwo()
	{
		super.sample();//it will call super class method
		System.out.println("this is sub class method");
	}
}
