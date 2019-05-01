package homepage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

import utility.Initialisation;

public class AddToCartPO extends LoadableComponent<AddToCartPO>
{
	private String category = "Computers";
	private String subcategory = "Notebooks";
	private String product = "Asus Eee PC Touch";
	private double price = 0;
	
	//@FindBy (xpath = "//a[contains(text(),'"+category+"')]")
	WebElement cat;
	
	@FindBy (xpath = "//a[contains(text(),'Notebooks')]")
	WebElement subcat;
	
	@FindBy (xpath = "//div/h3[contains(text(),'Asus Eee PC Touch')]")
	WebElement prod;
	
	private WebDriver driver;
	private String expectedTitle = "http://localhost/Avactis/";
	
	/*@FindBy (xpath = "")
	WebElement menu;
	
	WebElement subMenu;
	WebElement prod;*/
	
	public AddToCartPO()
	{
		driver = Initialisation.getDriver();
		PageFactory.initElements(driver, this);
		isLoaded();
		System.out.println("PO constructor");
	}
	
	public void setProductDetails(String category, String subcategory, String product, double price)
	{
		System.out.println("inside setProductDetails");
		this.category = category;
		this.subcategory = subcategory;
		this.product = product;
		this.price = price;
	}

	public void selectProducts()
	{
		System.out.println("inside selectProducts");
		if(category!=null && subcategory!=null && product!=null)
		{
			Actions builder = new Actions(driver);
					builder.moveToElement(cat)
							.moveToElement(subcat)
							.click()
							.build()
							.perform();
	
		}
		
		
		
	}

	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub
		Assert.assertEquals(driver.getTitle(), expectedTitle);	
	}
	
}
