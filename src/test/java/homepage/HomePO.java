package homepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

import utility.Initialisation;

public class HomePO extends LoadableComponent<HomePO>

{
	@FindBy (xpath = "//a[text()='Sign In']")
	private WebElement signin;
	
	@FindBy (xpath = "//a[text()='My Account']")
	private WebElement myaccount;
	
	@FindBy (xpath = "//a[text()='My cart']")
	private WebElement mycart;
	
	@FindBy (xpath = "//a[text()='Checkout']")
	private WebElement checkout;
	
	private WebDriver driver;
	private String expectedTitle = "Avactis Demo Store";
	
	public HomePO()
	{	
		driver = Initialisation.getDriver();
		PageFactory.initElements(driver, this);
		isLoaded();
	}
	
	public void clickSignIn()
	{
		signin.click();
	}
	
	public void clickMyAccount()
	{
		myaccount.click();
	}

	public void clickMyCart()
	{
		mycart.click();
	}

	public void clickCheckout()
	{
		checkout.click();
	}

	
	public String getTitle()
	{
		return driver.getTitle();
	}
	
	public void close()
	{
		driver.quit();
	}
	
	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub
		driver.get("http://localhost/Avactis/");
	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub
		Assert.assertEquals(driver.getTitle(), expectedTitle) ;
		
	}

}



















