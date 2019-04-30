package FileExamples;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class ReadContentFileUsingBufferedReader {

	public static void main(String[] args) throws IOException {
		
		FileReader fr=new FileReader("C:\\Users\\ab64129\\Desktop\\NaveenAutomationLabsRestAPI\\JavaExamples\\writeDataFile.txt");
		BufferedReader br=new BufferedReader(fr);
		String contentLine=br.readLine();
		while(contentLine!=null)
		{
			System.out.println(contentLine);
			contentLine=br.readLine();
		}
		

	}

}
