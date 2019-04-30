package FileExamples;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateNewFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		File file=new File("C:\\Users\\ab64129\\sample1.txt");
		if(file.createNewFile())
		{
			System.out.println("file created");
		}
		else
		{
			System.out.println("file not created");
		}

		
		FileWriter fw=new FileWriter(file);
		fw.write("created file successfully");
		fw.close();
	}

}
