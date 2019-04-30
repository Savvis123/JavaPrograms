package InterfaceRelatedjavaInterview;

public class InterfaceDemo implements IDemo,IDemo1 {



	@Override
	public void print() {
		System.out.println("Hello Mahesh");
	}
	
	public static void main(String[] args) {
		
		InterfaceDemo i=new InterfaceDemo();
		i.print();
		
		((IDemo)i).print();
		((IDemo1)i).print();
		
	}

}
