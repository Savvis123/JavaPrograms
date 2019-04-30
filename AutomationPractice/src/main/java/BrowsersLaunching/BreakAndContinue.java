package BrowsersLaunching;

public class BreakAndContinue {

	
	   public static void main(String[] args)
	   {
	      for (int i = 1; i <= 10; i++)
	      {
	         if (i % 2 == 0)
	         {
	            continue;    // skip next statement if i is even
	         }

	         System.out.println(i + " ");
	      }
	   }
	}

//o/p : 1,3,5,7,9


/*
public static void main(String[] args)
{
   for (int i = 1; i <= 10; i++)
   {
      if (i % 2 == 0)
      {
         break;   
      }

      System.out.println(i + " ");
   }
}
}*/

//o/p:1