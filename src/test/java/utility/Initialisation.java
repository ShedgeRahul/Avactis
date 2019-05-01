package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Initialisation 
{
	public static WebDriver driver; 
	
	public static void setBrowser(String browser, String testEnv)
	{
		String br = browser;
		switch(br)
		{
		
		case "CH" : 
				System.setProperty("webdriver.chrome.driver","C:\\Workspace\\Avactis\\src\\test\\java\\resources\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get(testEnv);
				
				break;
				
		/*case 2: if(br=="SF")
			 open safari browser
			 
			 break;*/
				
		case "IE" :
			System.setProperty("webdriver.ie.driver","test\\java\\resources\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.get(testEnv);
			
			break;
			
		 default : 
			  driver = new FirefoxDriver();
			  driver.manage().window().maximize();
			  driver.get(testEnv);
			
			break;
		
		}
		
	}	
		
	
	public static WebDriver getDriver()
		{
			return driver;
		}
		
}
