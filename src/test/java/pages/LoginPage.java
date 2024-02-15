package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

	@FindBy(xpath="//input[@name='email']")
	WebElement email;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//button[text()='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath="//h1[text()='Sign in']")
	WebElement title;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void login(String emailid,String pswd)
	{
		email.sendKeys(emailid);
		password.sendKeys(pswd);
		loginBtn.click();
	}
	
	public String getTitle()
	{
		return title.getText();
	}
}
