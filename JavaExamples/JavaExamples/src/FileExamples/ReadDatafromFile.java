package FileExamples;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadDatafromFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		File file =new File("C:\\Users\\ab64129\\sample123.txt");
		FileReader fr=new FileReader(file);
		BufferedReader br=new BufferedReader(fr);
		 String st;
		  while ((st = br.readLine()) != null)
		    System.out.println(st);
		

	}

}
