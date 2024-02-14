package testScripts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Dashboard;
import pages.EditPage;
import pages.HomePage;
import pages.LoginPage;
import pages.CreateNewArticlePage;
import pages.NewArticlePage;

public class CondiutArticleTest {
      WebDriver driver;
      HomePage homepage;
      LoginPage loginPage;
      Dashboard dashboard;
      CreateNewArticlePage crnwArticle;
      NewArticlePage upArticle;
      EditPage edpage;
  
	  public CondiutArticleTest()
	  {
		  TestBase.initDriver();
		  driver=TestBase.getDriver();
		  homepage=new HomePage(driver);
		  loginPage=new LoginPage(driver); 
		  dashboard=new Dashboard(driver);
		  crnwArticle=new CreateNewArticlePage(driver);
		  upArticle=new NewArticlePage(driver);
		  edpage=new EditPage(driver);
	  }
	  
	  @BeforeTest
	  public void setup()
	  {
		  TestBase.openUrl("https://conduit-realworld-example-app.fly.dev/#/");
	  }
	  @Test(priority=1)
	  public void navigateToLoginPageTest()
	  {
		  homepage.login();
	  }
	  @Test(priority=2)
	  public void login()
	  {
		  loginPage.login();
	  }
	  
	  @Test(priority=3)
	  public void createArticle()
	  {
		 dashboard.navigateToNewArticlePage(); 
		 crnwArticle.createNewArticle();
	  }
	  
	 @Test(priority=4)
	 public void editArticle()
	 {
		 upArticle.navigateToEditArticle();
		 edpage.update();
	 }
	 
	 @Test(priority=5)
	 public void deleteArticle()
	 {
		 
		 upArticle.deleteArticle();
		// driver.switchTo().alert().accept();
		 Alert alert=driver.switchTo().alert();
		  Assert.assertEquals(alert.getText(), "Want to delete the article?");
		  alert.accept(); 
	 }
	 
	  
	  
  
}
