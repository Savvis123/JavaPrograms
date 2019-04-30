package BakkappaJavaPrograms;

public class FactorialProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int factorialNum=5;
		for(int i=factorialNum-1;i>1;i--)
		{
			factorialNum=factorialNum*i;
		}

		System.out.println(factorialNum);
	}

}
