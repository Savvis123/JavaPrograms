package OnlineRostorJavaPrograms;

public class PowerOfNumberusingWhile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int number =3;
		int exponent=4;
		int result=1;
		while(exponent!=0)
		{
			result=result*number;
			--exponent;
		}
		int result1=1;
		int n=5;
		int exponent1=3;
		
		for (;exponent1 != 0; --exponent1)
        {
            result1 =result1* n;
        }
		System.out.println(result);
		System.out.println("for loop result: "+result1);
	}

}
