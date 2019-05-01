package tests;

import org.testng.annotations.Test;

import homepage.HomePO;
import homepage.MyAccountPO;
import homepage.RegistrationFormPO;
import utility.ConfigProperties;
import utility.Initialisation;
import utility.XlsDP;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class ValidLoginTest 
{
	HomePO homePage;
	MyAccountPO myAccountPage;
	RegistrationFormPO registrationFormPage;

		
  @Test(dataProvider = "xlsdata")
  public void validLogin(String user,String pwd) 
  {
	
	homePage.clickSignIn();
	myAccountPage.setEmail(user);
	myAccountPage.setPassword(pwd);
	myAccountPage.clickSignIn();
  }
  
  @DataProvider (name = "xlsdata")
  public Object[][] getTestData()
  {
	ConfigProperties.loadProperties();
  	String[][] testData = XlsDP.getDataFromXLSUsingJXL(ConfigProperties.getProperty("File_Path"), ConfigProperties.getProperty("Sheet_Name"), ConfigProperties.getProperty("Table_Name"));
  	return(testData);
  }

 
  
  @Parameters({"Browser","TestEnv"})
  @BeforeMethod(alwaysRun = true)
  public void beforeMethod(@Optional ("CH") String browser, @Optional ("http://localhost/Avactis/") String testEnv) 
  {
	  Initialisation.setBrowser(browser, testEnv);
	  
	  homePage = new HomePO();
	  myAccountPage = new MyAccountPO();
	  registrationFormPage = new RegistrationFormPO();
  }

  @AfterMethod
  public void afterMethod() 
  {
	  
  }
}
