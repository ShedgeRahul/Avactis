package tests;

import org.testng.annotations.Test;

import homepage.HomePO;
import homepage.MyAccountPO;
import homepage.RegistrationFormPO;
import utility.ConfigProperties;
import utility.Initialisation;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;

public class ValidRegistrationTest {
	
	HomePO homePage;
	MyAccountPO myAccountPage;
	RegistrationFormPO registrationFormPage;

 @Test 
  public void validRegistration() 
  {
	  
	homePage.clickSignIn();
	myAccountPage.setEmail(ConfigProperties.getProperty("CUST_Email"));
	myAccountPage.setPassword(ConfigProperties.getProperty("CUST_Password"));
	myAccountPage.clickSignIn();

	myAccountPage.clickRegister();
	registrationFormPage.setEmail(ConfigProperties.getProperty("REG_Email_ID")); 
	registrationFormPage.setPassword(ConfigProperties.getProperty("REG_PWD")); 
	registrationFormPage.setRePassword(ConfigProperties.getProperty("REG_RePWD")); 
	registrationFormPage.setFirstName(ConfigProperties.getProperty("REG_FName")); 
	registrationFormPage.setLastName(ConfigProperties.getProperty("REG_LName")); 
	registrationFormPage.selectCountry(ConfigProperties.getProperty("REG_County"));
	registrationFormPage.selectState(ConfigProperties.getProperty("REG_State"));
	registrationFormPage.setZip(ConfigProperties.getProperty("REG_Zip"));
	registrationFormPage.setCity(ConfigProperties.getProperty("REG_City"));
	registrationFormPage.setAddress1(ConfigProperties.getProperty("REG_Address1"));
	registrationFormPage.setAddress2(ConfigProperties.getProperty("REG_Address2"));
	registrationFormPage.setPhone(ConfigProperties.getProperty("REG_Phone"));
	
  }
  
  @Parameters({"Browser","TestEnv"})
  @BeforeMethod (alwaysRun=true)
  public void beforeMethod(@Optional ("CH") String browser, @Optional ("http://localhost/Avactis/") String testEnv) 
  {
	  Initialisation.setBrowser(browser, testEnv);
	  ConfigProperties.loadProperties();
	  homePage = new HomePO();
	  myAccountPage = new MyAccountPO();
	  registrationFormPage = new RegistrationFormPO();
  }

  @AfterMethod
  public void afterMethod() 
  {
	  
  }

}
