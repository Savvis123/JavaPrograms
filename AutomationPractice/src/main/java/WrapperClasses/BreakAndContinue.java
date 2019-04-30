package WrapperClasses;

public class BreakAndContinue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for (int i=0;i<100;i++)
		{
			
			if(i==50)
			{
				continue;
			}
			
			System.out.println(i);
			if(i==70)
			{
				break;
			}
			System.out.println(i);
		}

	}

}
