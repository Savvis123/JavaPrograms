package com.centurylink.statusmanager.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;

import com.centurylink.statusmanager.utilities.URLConfigs;

public class JSONCreator {

	public String AcceptedRequest;
	public String MSRequest;
	public String MicroServiceUpdateReq;

	JSONObject obj = new JSONObject();
	JSONArray commonInfo = new JSONArray();
	public WebDriver driver;

	public void read_data_for_SDWF_Accepted() throws IOException {

		File file = new File(URLConfigs.TEST_DATA+"\\SDWF_Accepted.txt");

		FileReader filereader = new FileReader(file);
		BufferedReader br = new BufferedReader(filereader);
		StringBuffer stringb = new StringBuffer();
		String jsontext;

		while ((jsontext = br.readLine()) != null) {

			stringb.append(jsontext);

			stringb.append("\n");

		}
		filereader.close();
		AcceptedRequest = stringb.toString();
	}

	public void read_data_for_SDWF_MicroService_Invocation() throws IOException {

		File file = new File(URLConfigs.TEST_DATA+"\\SDWF_MicroserviceInvocation.txt");

		FileReader filereader = new FileReader(file);
		BufferedReader br = new BufferedReader(filereader);
		StringBuffer stringb = new StringBuffer();
		String jsontext;

		while ((jsontext = br.readLine()) != null) {

			stringb.append(jsontext);

			stringb.append("\n");

		}
		filereader.close();
		MSRequest = stringb.toString();
	}

	public void read_data_for_microservice_update() {

		try {
			File file = new File(URLConfigs.TEST_DATA+"\\MicroServiceUpdate.txt");
			FileReader fileReader = new FileReader(file);

			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				stringBuffer.append(line);
				stringBuffer.append("\n");
			}
			fileReader.close();

			MicroServiceUpdateReq = stringBuffer.toString();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
