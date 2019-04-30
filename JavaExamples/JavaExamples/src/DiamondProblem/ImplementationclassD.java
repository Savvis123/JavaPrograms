package DiamondProblem;

public class ImplementationclassD implements B,C{
	
	/*An ambiguity that can arise as a consequence of allowing multiple inheritance.
	 * Since Java 8 default methods have been permitted inside 	interfaces, which may cause ambiguity 
	 * in some cases.
	 * 
	 * if we have same default methods in extended interfaces also then java compiler fource us to 
	 * override the method from sub interfaces.
	 * 
	 * Always sub interface has high priority than main interface ,so if same method is there in interface A and B
	 * then method will be called from Interface B
	 * */
	
	
	@Override
	public void m() {
		// TODO Auto-generated method stub
		C.super.m();
	}


	public static void main(String[] args) {
		
		ImplementationclassD D=new ImplementationclassD();
		D.m();
	}

	
	
}
