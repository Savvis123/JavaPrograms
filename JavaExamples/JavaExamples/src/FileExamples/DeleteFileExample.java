package FileExamples;

import java.io.File;

public class DeleteFileExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		File file=new File("C:\\Users\\ab64129\\Desktop\\NaveenAutomationLabsRestAPI\\JavaExamples\\DeleteFile.txt");
	
		
		if(file.exists())
		{
			if(file.delete())
			{
				System.out.println(file.getName()+"file deleted successfully");
			}
			else
			{
				System.out.println(file.getName()+"file not deleted");
			}
		}
	
	
	}

}
