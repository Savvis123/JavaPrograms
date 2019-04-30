package FileExamples;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyOneFileContentToAnotherFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		FileInputStream fis=new FileInputStream("C:\\Users\\ab64129\\Desktop\\NaveenAutomationLabsRestAPI\\JavaExamples\\InPutFile.txt");
		FileOutputStream fos=new FileOutputStream("C:\\Users\\ab64129\\Desktop\\NaveenAutomationLabsRestAPI\\JavaExamples\\OutPutFile.txt");
		
		int length;
		
		byte[] buffer=new byte[1024];
		
		while ((length = fis.read(buffer)) > 0){
	    	fos.write(buffer, 0, length);
	    }

	}

}
