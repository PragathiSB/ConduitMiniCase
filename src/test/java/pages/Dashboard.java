package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {
	@FindBy(xpath="//a[text()='New Article']")
	WebElement newArticle;
	
	@FindBy(xpath="//div[contains(text(),'pragathi')]")
	WebElement username;
	
	@FindBy(xpath="//a[text()='conduit']")
	WebElement title;
	
	public Dashboard(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void navigateToNewArticlePage()
	{
		newArticle.click();
	}
	public String username()
	{
		return username.getText();
	}
	
	public String getTitle()
	{
		return title.getText();
	}

}
