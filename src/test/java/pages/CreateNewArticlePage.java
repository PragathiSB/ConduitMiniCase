package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CreateNewArticlePage {
	
	@FindBy(xpath="//input[@name='title']")
	WebElement articletitle;
	
	@FindBy(xpath="//input[@name='description']")
	WebElement description;
	
	@FindBy(xpath="//textarea[@name='body']")
	WebElement body;
	
	@FindBy(xpath="//input[@name='tags']")
	WebElement tags;
	
	@FindBy(xpath="//button[text()='Publish Article']")
	WebElement publishBtn;
	
	public CreateNewArticlePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void createNewArticle(String title,String artDes,String artBody,String artTag)
	{
		articletitle.sendKeys(title);
		description.sendKeys(artDes);
		body.sendKeys(artBody);
		tags.sendKeys(artTag);
		publishBtn.click();
		
	}
	

}
