package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class NewArticlePage {
	
	
	@FindBy(xpath="(//button//a[text()=' Edit Article'])[2]")
	WebElement editBtn;
	
	@FindBy(xpath="(//button[text()=' Delete Article'])[2]")
    WebElement deleteBtn;
	
	@FindBy(xpath="//div[contains(text(),'Articles not available.')]")
	WebElement check;

	@FindBy(xpath="//h1[contains(text(),'Testing in selenium')]")
	WebElement hdr;
	
	
//	@FindBy(xpath="//p[contains(text(),'2')]")
//	WebElement upBody;

	@FindBy(xpath="//textarea[@name='body']")
	WebElement body;
	
	public NewArticlePage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void navigateToEditArticle()
	{
		editBtn.click();
	}
	
	public void deleteArticle()
	{
		deleteBtn.click();
	}
	public String getHeading()
	{
		return hdr.getText();
	}
	public String upBody()
	{
		return body.getText();
	}
}
