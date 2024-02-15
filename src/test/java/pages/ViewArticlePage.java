package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ViewArticlePage {
	
	WebDriver driver;
	@FindBy(xpath="(//button//a[text()=' Edit Article'])[2]")
	WebElement editBtn;
	
	@FindBy(xpath="(//button[text()=' Delete Article'])[2]")
    WebElement deleteBtn;
	
	@FindBy(xpath="//div[contains(text(),'Articles not available.')]")
	WebElement check;

	@FindBy(xpath="//h1[contains(text(),'Testing in selenium')]")
	WebElement hdr;
	@FindBy(xpath="//div[contains(text(),'Articles not available.')]")
	WebElement chck;
	
//	@FindBy(xpath="//p[contains(text(),'2')]")
//	WebElement upBody;

	@FindBy(xpath="//textarea[@name='body']")
	WebElement body;
	
	public ViewArticlePage(WebDriver driver) 
	{ 
		this.driver=driver;
	
		PageFactory.initElements(driver, this);
	}
	
	public void navigateToEditArticle()
	{
		editBtn.click();
	}
	
	public void deleteArticle()
	{
		deleteBtn.click();
		 Alert alert=driver.switchTo().alert();
		  Assert.assertEquals(alert.getText(), "Want to delete the article?");
		  alert.accept(); 
	}
	public String getHeading()
	{
		return hdr.getText();
	}
	public String upBody()
	{
		return body.getText();
	}
	public String deleteCheck()
	{
		return chck.getText();
	}
}
