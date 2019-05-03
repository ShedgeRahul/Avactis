package tests;

import org.testng.annotations.Test;

import utility.RandomData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class DemoTest {
  @Test
  public void newTest() 
  {
	  RandomData.randomEmail();
	  
  }
  @BeforeMethod
  public void beforeMethod() 
  {
	  System.out.println("Before Test");
  }

  @AfterMethod
  public void afterMethod() 
  {
	  
  }

}
