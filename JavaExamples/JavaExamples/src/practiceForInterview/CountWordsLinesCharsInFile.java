package practiceForInterview;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CountWordsLinesCharsInFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		BufferedReader reader=null;
		int wordscount=0;
		int linescount=0;
		int charscount=0;
		
	
			FileReader fr=new FileReader("C:\\Users\\ab64129\\Desktop\\Imp TXT Files\\sample.txt");
			
			reader=new BufferedReader(fr);
			
			String currentLine=reader.readLine();
			
			while(currentLine!=null)
			{
				linescount++;
				String words[]=currentLine.split(" ");
				wordscount=wordscount+words.length;
				
				for(String word:words){
					
					charscount=charscount+word.length();
				}
				currentLine=reader.readLine();
			}
			
		System.out.println("length of chars:"+charscount);
		System.out.println("words count:"+wordscount);
		System.out.println("lines count :"+linescount);
	}

}
