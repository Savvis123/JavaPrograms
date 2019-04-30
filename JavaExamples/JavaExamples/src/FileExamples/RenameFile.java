package FileExamples;

import java.io.File;

public class RenameFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File newfile =new File("C:\\Users\\ab64129\\Desktop\\NaveenAutomationLabsRestAPI\\JavaExamples\\Renamefile.txt");


		File file=new File("C:\\Users\\ab64129\\Desktop\\NaveenAutomationLabsRestAPI\\JavaExamples\\filecreate.txt");
	
		
		boolean boo=file.renameTo(newfile);
		if(boo==true)
		{
			System.out.println("file renames successfully");
		}
		else
		{
			System.out.println("file not renamed");
		}
		
	}

}
