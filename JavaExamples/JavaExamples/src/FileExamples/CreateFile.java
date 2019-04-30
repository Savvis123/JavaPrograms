package FileExamples;

import java.io.File;
import java.io.IOException;

public class CreateFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		File file=new File("C:\\Users\\ab64129\\Desktop\\NaveenAutomationLabsRestAPI\\JavaExamples\\filecreate.txt");
		boolean boo=file.createNewFile();
		if(boo==true)
		{
			System.out.println("file created successfully");
		}
		else
		{
			System.out.println("file not created");
		}
	
	}

}
