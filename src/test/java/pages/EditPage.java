package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class EditPage {
	@FindBy(xpath="//button[text()='Update Article']")
	WebElement updateBtn;
	
	@FindBy(xpath="//input[@name='description']")
	WebElement description;
	
	@FindBy(xpath="//textarea[@name='body']")
	WebElement body;
	
	public EditPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	public void update()
	{
		body.clear();
		body.sendKeys("automation in testing");
		updateBtn.click();
		String bodycnt=body.getText();
		Assert.assertEquals(bodycnt,"automation in testing");
	}

}
