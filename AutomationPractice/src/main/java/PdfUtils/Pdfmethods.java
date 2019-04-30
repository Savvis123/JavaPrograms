package PdfUtils;

import java.io.IOException;

import com.testautomationguru.utility.CompareMode;
import com.testautomationguru.utility.PDFUtil;

public class Pdfmethods {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String path="C:\\Users\\ab64129\\Desktop\\java.pdf";
		PDFUtil pdfUtil = new PDFUtil();
		System.out.println(pdfUtil.getPageCount("C:\\Users\\ab64129\\Desktop\\java.pdf"));
		System.out.println("PDF text is :"+pdfUtil.getText("C:\\Users\\ab64129\\Desktop\\java.pdf"));
		System.out.println("PDF text for 3 page is :"+pdfUtil.getText("C:\\Users\\ab64129\\Desktop\\java.pdf",3));
		System.out.println("PDF text from 5th to 8th page is :"+pdfUtil.getText("C:\\Users\\ab64129\\Desktop\\java.pdf",5,8));
	
		//set the path where we need to store the images
		 pdfUtil.setImageDestinationPath("c:/imgpath");
		 pdfUtil.extractImages(path);

		// extracts and saves the pdf content from page number 3
		pdfUtil.extractImages(path, 3);

		// extracts and saves the pdf content from page 2
		pdfUtil.extractImages(path, 2, 2);
		
		//set the path where we need to store the images
		 pdfUtil.setImageDestinationPath("c:/imgpath");
		 pdfUtil.savePdfAsImage("c:/sample.pdf");
		 
		 String file1="C:\\Users\\ab64129\\Desktop\\java.pdf";
		 String file2="C:\\Users\\ab64129\\Desktop\\java1.pdf";

		 // compares the pdf documents and returns a boolean
		 // true if both files have same content. false otherwise.
		 pdfUtil.compare(file1, file2);

		 // compare the 3rd page alone
		 pdfUtil.compare(file1, file2, 3, 3);

		 // compare the pages from 1 to 5
		 pdfUtil.compare(file1, file2, 1, 5);
		/* Copy
		 To exclude certain text while comparing PDF files in text mode
		 String file1="c:/files/doc1.pdf";
		 String file1="c:/files/doc2.pdf";*/

		 //pass all the possible texts to be removed before comparing
		 pdfUtil.excludeText("1998", "testautomation");

		 //pass regex patterns to be removed before comparing
		 // \\d+ removes all the numbers in the pdf before comparing
		 pdfUtil.excludeText("\\d+");

		 // compares the pdf documents and returns a boolean
		 // true if both files have same content. false otherwise.
		 pdfUtil.compare(file1, file2);

		 // compare the 3rd page alone
		 pdfUtil.compare(file1, file2, 3, 3);

		 // compare the pages from 1 to 5
		 pdfUtil.compare(file1, file2, 1, 5);
		 /*Copy
		 To compare PDF files in Visual mode (slower – compares PDF documents pixel by pixel – highlights pdf difference & store the result as image)
		 String file1="c:/files/doc1.pdf";
		 String file1="c:/files/doc2.pdf";*/

		 // compares the pdf documents and returns a boolean
		 // true if both files have same content. false otherwise.
		 // Default is CompareMode.TEXT_MODE
		 pdfUtil.setCompareMode(CompareMode.VISUAL_MODE);
		 pdfUtil.compare(file1, file2);

		 // compare the 3rd page alone
		 pdfUtil.compare(file1, file2, 3, 3);

		 // compare the pages from 1 to 5
		 pdfUtil.compare(file1, file2, 1, 5);

		 //if you need to store the result
		 pdfUtil.highlightPdfDifference(true);
		 pdfUtil.setImageDestinationPath("c:/imgpath");
		 pdfUtil.compare(file1, file2);
	
	
	}

}
