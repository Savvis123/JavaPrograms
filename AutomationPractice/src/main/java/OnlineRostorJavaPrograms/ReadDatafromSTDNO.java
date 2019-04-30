package OnlineRostorJavaPrograms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadDatafromSTDNO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> tokens=new ArrayList<>();
		
		Scanner scanner=new Scanner(System.in);
		while(scanner.hasNext())
		{
			tokens.add(scanner.next());
		}
		System.out.println(tokens);
		scanner.close();
	}

}
