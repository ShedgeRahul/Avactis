package tests;

import org.testng.annotations.Test;

import homepage.HomePO;
import homepage.LoginPO;
import homepage.MyAccountPO;
import utility.Initialisation;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class DemoTest {
	MyAccountPO mapo;
	LoginPO loginPage;
	HomePO homePage;
	@Test
  public void newTest() 
  {
		homePage.clickSignIn();
	 loginPage.setEmail("test@test.com");
	  loginPage.setPassword("Password");
	  loginPage.clickRegister();
	  Assert.assertEquals(mapo.getLinkTitle(), "Sign Out");
	  
  }
  @BeforeMethod
  public void beforeMethod() 
  {
	  System.out.println("Before Test");
	  Initialisation.setBrowser("CH","http://localhost/Avactis/sign-in.php");
	  mapo = new MyAccountPO();
	  loginPage = new LoginPO();
	  homePage = new HomePO();
  }

  @AfterMethod
  public void afterMethod() 
  {
	  
  }

}
