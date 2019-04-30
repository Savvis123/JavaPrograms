package BrowsersLaunching;

public class BreakAndContinueInLoop {

         public static void main(String[] args)
		   {
		      for (int i = 1; i <= 20; i++)
		      {
		    	  
		    	  if(i==10)
		    	  {
		    		  break;
		    	  }
		         if (i % 2 == 0)
		         {
		            continue;    
		         }

		         System.out.println(i + " ");
		      }
		   }
		
}
