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
	  @FindBy(xpath="//h1[contains(text(),'Testing in selenium')]")
	WebElement hdr;
	
	public CreateNewArticlePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void createNewArticle()
	{
		articletitle.sendKeys("Testing in selenium");
		description.sendKeys("Within your web app’s UI, there are areas where your tests interact with. A Page Object only models these as objects within the test code. This reduces the amount of duplicated code and means that if the UI changes, the fix needs only to be applied in one place.");
		body.sendKeys("Page Object is a Design Pattern that has become popular in test automation for enhancing test maintenance and reducing code duplication. A page object is an object-oriented class that serves as an interface to a page of your AUT. The tests then use the methods of this page object class whenever they need to interact with the UI of that page. The benefit is that if the UI changes for the page, the tests themselves don’t need to change, only the code within the page object needs to change. Subsequently, all changes to support that new UI are located in one place.");
		tags.sendKeys("automation");
		publishBtn.click();
		String headerName=hdr.getText();
		System.out.println("New Article Title-"+headerName);
		Assert.assertEquals(headerName,"Testing in selenium");
	}
	

}
