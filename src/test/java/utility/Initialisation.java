package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Initialisation 
{
	public static WebDriver driver; 
	
	public static void setBrowser(String browser, String testEnv)
	{
		//String br = browser;
		switch(browser)
		{
		
		case "CH" : 
			try {
				System.setProperty("webdriver.chrome.driver","C:\\Workspace\\Avactis\\src\\test\\java\\resources\\chromedriver.exe");
				}
			catch (Exception e) 
				{
					Log.fatal("Please check diver name and driver exe path once ");
				}
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get(testEnv);
				Log.debug("Chrome browser open ");
				break;
				
		/*case 2: if(br=="SF")
			 open safari browser
			 
			 break;*/
				
		case "IE" :
			try
			{
			System.setProperty("webdriver.ie.driver","test\\java\\resources\\IEDriverServer.exe");
			}
			catch (Exception e) {
				Log.fatal("Please check diver name and driver exe path once ");
			}
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.get(testEnv);
			Log.debug("IE browser open ");
			break;
			
		 default : 
			  driver = new FirefoxDriver();
			  driver.manage().window().maximize();
			  driver.get(testEnv);
			Log.debug("Default browser Firefox is open ");
			break;
		
		}
		
	}	
		
	
	public static WebDriver getDriver()
		{
			return driver;
		}
		
	
	public void failed(String testMethodName)
	{
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File("C:\\Workspace\\Avactis\\ScreenShots\\"+testMethodName), true);
		//(srcFile, new File("C:\\Workspace\\Avactis\\ScreenShots\\"+testMethodName+".jpg"));
			//+this.getClass().getName()+"_"
		} catch (IOException e) {

		Log.info("File not found in FileUtils please find stack trace - ");
		e.printStackTrace();
		}
	}
	
	
	public static void quitBrowser()
	{
		driver.quit();
	}
	
}
