package FileExamples;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteDataIntoFile {


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String str="i am entering data into file";
		
		File file;
		FileOutputStream fos = null;
		try{
			file =new File("C:\\Users\\ab64129\\Desktop\\NaveenAutomationLabsRestAPI\\JavaExamples\\writeDataFile.txt");
			
			fos=new FileOutputStream(file);
		
		if(!file.exists())
		{
			file.createNewFile();
		}
		
		byte[] mybytes=str.getBytes();
		fos.write(mybytes);
		fos.flush();
		System.out.println("file write successfully");
		
			
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}

		finally{
			if(fos!=null)
			{
			fos.close();	
			}
			
			
		}
	}

}
