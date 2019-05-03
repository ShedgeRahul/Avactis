package tests;

import org.testng.annotations.Test;

import homepage.AddToCartPO;
import utility.ConfigProperties;
import utility.Initialisation;
import utility.XlsDP;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class GuestEndToEndTest 
{
	AddToCartPO addToCart;
	private String category;
	private String subcategory;
	private String product;
	private double price;
	
  @Test(dataProvider = "productDetails")
  public void guestEndToEndTest(String menu, String subMenu, String product, double cost) 
  {
	//  this.category = menu;
	 // this.subcategory = subMenu;
	 // this.product = product;
	//  this.price = cost;
	  
	  addToCart.setProductDetails(category, subcategory, product, price);
	  addToCart.selectProducts();  
  }
  
  @Parameters({"Browser","TestEnv"})
  @BeforeMethod
  public void beforeMethod(@Optional ("CH") String browser, @Optional ("http://localhost/Avactis/") String testEnv) 
  {
	  Initialisation.setBrowser(browser, testEnv);
	  addToCart = new AddToCartPO();
  }

  @AfterMethod
  public void afterMethod() 
  {
	  
  }


  @DataProvider(name = "productsDetails")
  public Object[][] getTestData()
  {
	ConfigProperties.loadProperties();
  	String[][] testData = XlsDP.getDataFromXLSUsingJXL(ConfigProperties.getProperty("File_Path"), "ProductDetails", ConfigProperties.getProperty("Table_Name"));
  	return(testData);
  }

}
