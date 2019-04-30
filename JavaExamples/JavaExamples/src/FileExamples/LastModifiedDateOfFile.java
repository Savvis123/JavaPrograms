package FileExamples;

import java.io.File;
import java.text.SimpleDateFormat;

public class LastModifiedDateOfFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	File file = new File("C:\\Users\\ab64129\\Desktop\\NaveenAutomationLabsRestAPI\\JavaExamples\\InPutFile.txt");
    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	System.out.println("Last Modified Date: " + sdf.format(file.lastModified()));

	}

}
