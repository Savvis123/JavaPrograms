package KrishnaSakinalaSeleniumTestNG;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxProfile;

public class FileDownloadExample {

	@SuppressWarnings("unused")
	private boolean isFileDownloaded_Ext(String dirPath, String ext){
		boolean flag=false;
	    File dir = new File(dirPath);
	    File[] files = dir.listFiles();
	    if (files == null || files.length == 0) {
	        flag = false;
	    }
	    
	    for (int i = 1; i < files.length; i++) {
	    	if(files[i].getName().contains(ext)) {
	    		flag=true;
	    	}
	    }
	    return flag;
	}
	
	public boolean isFileDownloaded(String downloadPath, String fileName) {
		boolean flag = false;
	    File dir = new File(downloadPath);
	    File[] dir_contents = dir.listFiles();
	  	    
	    for (int i = 0; i < dir_contents.length; i++) {
	        if (dir_contents[i].getName().equals(fileName))
	            return flag=true;
	            }

	    return flag;
	}
	
	/* Get the latest file from a specific directory*/
	@SuppressWarnings("unused")
	private File getLatestFilefromDir(String dirPath){
	    File dir = new File(dirPath);
	    File[] files = dir.listFiles();
	    if (files == null || files.length == 0) {
	        return null;
	    }
	
	    File lastModifiedFile = files[0];
	    for (int i = 1; i < files.length; i++) {
	       if (lastModifiedFile.lastModified() < files[i].lastModified()) {
	           lastModifiedFile = files[i];
	       }
	    }
	    return lastModifiedFile;
	}
	
	
public static FirefoxProfile firefoxProfile() throws Exception {
		
	String downloadPath="";
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		firefoxProfile.setPreference("browser.download.folderList",2);
		firefoxProfile.setPreference("browser.download.manager.showWhenStarting",false);
		firefoxProfile.setPreference("browser.download.dir",downloadPath);
		firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk",
"text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
		
		return firefoxProfile;
	}


public static String getDownloadedDocumentName(String downloadDir, String fileExtension)
{	
	String downloadedFileName = null;
	boolean valid = true;
	boolean found = false;

	//default timeout in seconds
	long timeOut = 20; 
	try 
	{					
		Path downloadFolderPath = Paths.get(downloadDir);
		WatchService watchService = FileSystems.getDefault().newWatchService();
		downloadFolderPath.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);
		long startTime = System.currentTimeMillis();
		do 
		{
			WatchKey watchKey;
			watchKey = watchService.poll(timeOut,TimeUnit.SECONDS);
			long currentTime = (System.currentTimeMillis()-startTime)/1000;
			if(currentTime>timeOut)
			{
				System.out.println("Download operation timed out.. Expected file was not downloaded");
				return downloadedFileName;
			}
			
			for (WatchEvent> event : watchKey.pollEvents())
			{
				<WatchEvent.Kind> kind = event.kind();
				if (kind.equals(StandardWatchEventKinds.ENTRY_CREATE)) 
				{
					String fileName = event.context().toString();
					System.out.println("New File Created:" + fileName);
					if(fileName.endsWith(fileExtension))
					{
						downloadedFileName = fileName;
						System.out.println("Downloaded file found with extension " + fileExtension + ". File name is " + 

fileName);
						Thread.sleep(500);
						found = true;
						break;
					}
				}
			}
			if(found)
			{
				return downloadedFileName;
			}
			else
			{
				currentTime = (System.currentTimeMillis()-startTime)/1000;
				if(currentTime>timeOut)
				{
					System.out.println("Failed to download expected file");
					return downloadedFileName;
				}
				valid = watchKey.reset();
			}
		} while (valid);
	} 
	
	catch (InterruptedException e) 
	{
		System.out.println("Interrupted error - " + e.getMessage());
		e.printStackTrace();
	}
	catch (NullPointerException e) 
	{
		System.out.println("Download operation timed out.. Expected file was not downloaded");
	}
	catch (Exception e)
	{
		System.out.println("Error occured - " + e.getMessage());
		e.printStackTrace();
	}
	return downloadedFileName;
}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
