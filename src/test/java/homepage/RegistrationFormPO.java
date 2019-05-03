package homepage;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utility.Initialisation;

public class RegistrationFormPO extends LoadableComponent<RegistrationFormPO>
{
	@FindBy (name = "customer_info[Customer][Email]")
	WebElement email;
	
	@FindBy (name = "customer_info[Customer][Password]")
	WebElement password;
	
	@FindBy (name = "customer_info[Customer][RePassword]")
	WebElement rePassword;
	
	@FindBy (name = "customer_info[Customer][FirstName]")
	WebElement firstName;
	
	@FindBy (name = "customer_info[Customer][LastName]")
	WebElement lastName;
	
	@FindBy (name = "customer_info[Customer][Country]")
	WebElement country;
	
	@FindBy (name = "customer_info[Customer][State]")
	WebElement state;
	
	@FindBy (name = "customer_info[Customer][ZipCode]")
	WebElement zip;
	
	@FindBy (name = "customer_info[Customer][City]")
	WebElement city;
	
	@FindBy (name = "customer_info[Customer][Streetline1]")
	WebElement address1;
	
	@FindBy (name = "customer_info[Customer][Streetline2]")	
	WebElement address2;
	
	@FindBy (name = "customer_info[Customer][Phone]")
	WebElement phone;
	
	@FindBy (xpath = "//input[@type='submit']")
	WebElement register;
	
	private WebDriver driver;
	private String expectedTitle = "Avactis Demo Store";
	
	public RegistrationFormPO()
	{
		driver = Initialisation.getDriver();
		PageFactory.initElements(driver, this);
		isLoaded();
	}
	
	
	public void setEmail(int num)
	{
		email.sendKeys("username"+num+"@test.com");
	}
	
	public void setPassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public void setRePassword(String repwd)
	{
		rePassword.sendKeys(repwd);
	}
	
	public void setFirstName(String fname)
	{
		firstName.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		lastName.sendKeys(lname);
	}
	
	public void selectCountry(String countryname)
	{
		Select countrydropdown = new Select(country);
		countrydropdown.selectByVisibleText(countryname);
	}

	
	public void selectState(String statename)
	{
		Select statedropdown = new Select(state);
		statedropdown.selectByVisibleText(statename);		
	}
	
	/*public void selectState(String statename)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("Select statedropdown = new Select(state);statedropdown.selectByVisibleText(statename)");		
	}*/
	
	public void setZip(String postalcode)
	{
		zip.sendKeys(postalcode);
	}

	
	public void setCity(String cityname)
	{
		city.sendKeys(cityname);
	}

	public void setAddress1(String firstAddress)
	{
		address1.sendKeys(firstAddress);
	}
	
	public void setAddress2(String secoundAddress)
	{
		address2.sendKeys(secoundAddress);
	}
	
	public void setPhone(String phonenumber)
	{
		phone.sendKeys(phonenumber);
	}
	
	public void clickRegister()
	{
		register.click();
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
	protected void isLoaded() throws Error 
	{
		// TODO Auto-generated method stub
		
	}


	@Override
	protected void load() 
	{
		// TODO Auto-generated method stub
		Assert.assertEquals(driver.getTitle(), expectedTitle);
	}
	
}
