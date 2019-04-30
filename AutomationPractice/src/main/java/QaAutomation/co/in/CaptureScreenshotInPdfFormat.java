package QaAutomation.co.in;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import KrishnaSakinalaSeleniumTestNG.TakeScreenShotOfEntirePage;

public class CaptureScreenshotInPdfFormat {
	
/*	For this purpose we would be using Java inbuilt libraries along with iTextPDF Jar which provides the facility to 
    capture screenshot and save them in PDF file.
	In the code we have following the below sequence:

		Capturing the screenshot and store it in byte[] array format.
		Initiate and open PDF writer.
		Process and set the size of image
		Add Image to PDF and close the File.
		
		<dependency>
			<groupId>com.itextpdf</groupId>
			<artifactId>itextpdf</artifactId>
			<version>5.0.6</version>
		</dependency>*/

	public static void main(String[] args) throws DocumentException, MalformedURLException, IOException {
		
		//String path = System.getProperty("user.dir")+"/Desktop/AutomationPractice/Driverfiles/chromedriver.exe";
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ab64129\\Desktop\\AutomationPractice\\Driverfiles\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.get("https://www.google.com");

		// Capture screenshot and store it in byte[] array format
		byte[] input = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		Document document = new Document();
		String output = "D://Googel" + "Image" + ".pdf";
		FileOutputStream fos = new FileOutputStream(output);

		// Instantiate the PDF writer
		PdfWriter writer = PdfWriter.getInstance(document, fos);

		// open the pdf for writing
		writer.open();
		document.open();

		// process content into image
		Image im = Image.getInstance(input);

		//set the size of the image
		im.scaleToFit(PageSize.A4.getWidth()/2, PageSize.A4.getHeight()/2);

		// add the captured image to PDF
		document.add(im);
		document.add(new Paragraph(" "));

		//close the files and write to local system
		document.close();
		writer.close();

	}

}
