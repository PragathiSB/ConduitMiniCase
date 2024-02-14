package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class NewArticlePage {
	
	@FindBy(css="h1")
	WebElement hdr;
	
	@FindBy(xpath="(//button//a[text()=' Edit Article'])[2]")
	WebElement editBtn;
	
	@FindBy(xpath="(//button[text()=' Delete Article'])[2]")
    WebElement deleteBtn;
	
	@FindBy(xpath="//div[contains(text(),'Articles not available.')]")
	WebElement check;

	
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
}
