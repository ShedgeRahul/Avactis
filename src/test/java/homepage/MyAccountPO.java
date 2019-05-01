package homepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

import utility.Initialisation;

public class MyAccountPO extends LoadableComponent<MyAccountPO>
{
	@FindBy (xpath = "//button[text()='Register']")
	WebElement register;

	@FindBy (id = "account_sign_in_form_email_id")
	WebElement email;
	
	@FindBy (name = "passwd")
	WebElement password;
	
	@FindBy (xpath = "//input[@class='btn btn-primary input_submit']")
	WebElement signIn;
	
	private WebDriver driver;
	private String expectedTitle = "Avactis Demo Store";
	
	public MyAccountPO()
	{
		driver = Initialisation.getDriver();
		PageFactory.initElements(driver, this);
		isLoaded();
	}
	
	public void clickRegister()
	{
		register.click();
	}

	public void setEmail(String mail)
	{
		email.sendKeys(mail);
	}
	
	public void setPassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public void clickSignIn()
	{
		signIn.click();
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
		
	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub
	Assert.assertEquals(driver.getTitle(), expectedTitle);	
	}
		
}
