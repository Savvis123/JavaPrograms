package com.centurylink.statusmanager.mailUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

import org.apache.commons.codec.binary.Base64;

import com.centurylink.statusmanager.extentReports.ExtentReportConfigurations;
import com.centurylink.statusmanager.listeners.CustomListeners;
import com.centurylink.statusmanager.utilities.SeleniumDriver;
import com.centurylink.statusmanager.utilities.URLConfigs;

import javax.activation.*;

public class SendMailwithAttachment {

	FileInputStream fis;
	Properties prop = new Properties();

	String status;
	String TestEnvironment;
	
	String reportMessage = "Status Manager Automation execution is completed. Please find the detailed Report attached with the mail." ;

	final String user = "sanjay.kemmanagudde@centurylink.com";// change accordingly

	public void mailsender() throws IOException {

		fis = new FileInputStream(URLConfigs.BASE_FILE_PATH);
		prop.load(fis);

		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", "mailgate.qintra.com");
		properties.put("mail.smtp.auth", "true");

		Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				// return new PasswordAuthentication(user,password);

				String str = prop.getProperty("password");
				byte[] decodedPwdBytes = Base64.decodeBase64(str.getBytes());
				String decodedPwd = new String(decodedPwdBytes);
				return new PasswordAuthentication(user, decodedPwd);
			}
		});

		// 2) compose message
		try {
			MimeMessage message = new MimeMessage(session);
			
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailIDTO.TOList));			
			message.addRecipients(Message.RecipientType.CC, InternetAddress.parse(emailIDTO.CcList));
			
			message.setSubject(ExtentReportConfigurations.reportName);

			// 3) create MimeBodyPart object and set your message text

			String Browser = prop.getProperty("Browser").toUpperCase();

			// Get Report related information
			String BrowserInfo = Browser;
			String EnvInfo = getExecutionEnv();
			String ReportInfo = ExtentReportConfigurations.reportName;
			String TestStatus = CustomListeners.status;
			String ExecutionTime = CustomListeners.Totaltime;
			

			StringBuilder m = new StringBuilder();
			// ====================================
			
			m.append("Hi,").append(System.lineSeparator()).append(System.lineSeparator());
			m.append("<p>").append(reportMessage).append("</p>");
			m.append(System.lineSeparator());
			m.append(System.lineSeparator());
			m.append(System.lineSeparator());
			m.append("<body>");

			m.append("<div style='margin-left:10px; margin-right:10px; padding:10px 10px 10px 10px;'>");
			m.append("<table style='border-color:#114411; border:1px solid; border-collapse:collapse; overflow:scroll;'>");
			
			m.append("<tr style='border:1px solid; border-collapse:collapse; font-weight:bold; vertical-align:middle; text-align:center;'>");

			m.append("<th style='border:1px solid; padding:10px 10px 10px 10px;'>Test Report Name</th>");
			m.append("<th style='border:1px solid; border-collapse:collapse;padding:10px 10px 10px 10px;'>Automation Suite Result</th>");
			m.append("<th style='border:1px solid; border-collapse:collapse;padding:10px 10px 10px 10px;'>Browser</th>");
			m.append("<th style='border:1px solid; border-collapse:collapse;padding:10px 10px 10px 10px;'>Test Environment</th>");
			m.append("<th style='border:1px solid; border-collapse:collapse;padding:10px 10px 10px 10px;'>Execution Time</th>");

			m.append("</tr>");

			m.append("<tr style='border:1px solid; border-collapse:collapse; vertical-align:middle; text-align:center;'>");
			m.append("<td style='border:1px solid; padding:10px 10px 10px 10px;'>").append(ReportInfo).append("</td>");
			
			if (CustomListeners.status.equalsIgnoreCase("PASS")) {
				
				m.append("<td style='border:1px solid; border-collapse:collapse; padding:10px 10px 10px 10px; color:MediumSeaGreen'>").append(TestStatus).append("</td>");
				
			}else if (CustomListeners.status.equalsIgnoreCase("Fail")) {
	
				m.append("<td style='border:1px solid; border-collapse:collapse; padding:10px 10px 10px 10px; color:red'>").append(TestStatus).append("</td>");
				
			}
			m.append("<td style='border:1px solid; border-collapse:collapse; padding:10px 10px 10px 10px;'>").append(BrowserInfo).append("</td>");
			m.append("<td style='border:1px solid; border-collapse:collapse; padding:10px 10px 10px 10px;'>").append(EnvInfo).append("</td>");
			m.append("<td style='border:1px solid; border-collapse:collapse; padding:10px 10px 10px 10px;'>").append(ExecutionTime).append("</td>");

			m.append("</tr>");

			m.append("</table></div>");

			m.append(System.lineSeparator()).append(System.lineSeparator());
			m.append(System.lineSeparator());
			m.append("<p>").append("Thank You.").append("</p>");

			
			
	
			BodyPart messageBodyPart1 = new MimeBodyPart();

			messageBodyPart1.setContent(m.toString(), "text/html");

			// 4) create new MimeBodyPart object and set DataHandler object to this object
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();

			String filename = ExtentReportConfigurations.Filename; // ExtentReport path

			DataSource source = new FileDataSource(filename);
			messageBodyPart2.setDataHandler(new DataHandler(source));
			messageBodyPart2.setFileName(filename);

			// 5) create Multipart object and add MimeBodyPart objects to this object
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart1);
			multipart.addBodyPart(messageBodyPart2);

			// 6) set the multiplart object to the message object
			message.setContent(multipart);

			// 7) send message
			Transport.send(message);

			System.out.println("mail sent....");
		} catch (MessagingException ex) {
			ex.printStackTrace();
		}

	}

	public String getExecutionEnv() {

		if (SeleniumDriver.selectExecutionEnvironment().contains("test1")) {

			TestEnvironment = "Test1 - " + SeleniumDriver.selectExecutionEnvironment();

		} else if (SeleniumDriver.selectExecutionEnvironment().contains("test2")) {

			TestEnvironment = "Test2 - " + SeleniumDriver.selectExecutionEnvironment();

		} else if (SeleniumDriver.selectExecutionEnvironment().contains("test3")) {

			TestEnvironment = "Test3 - " + SeleniumDriver.selectExecutionEnvironment();

		}else {
			
			TestEnvironment = "URL - " + SeleniumDriver.selectExecutionEnvironment();
		}
		return TestEnvironment;
	}

}
