package testScripts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;

import base.TestBase;
import commonUtils.Utility;
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
      ExtentReports extentReports;
  	ExtentSparkReporter spark;
  	ExtentTest extentTest;
  
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
		public void setupExtent() {
			extentReports=new ExtentReports();
			spark=new ExtentSparkReporter("test-output/Sparkreport.html")
					   .viewConfigurer()
					   .viewOrder()
					   .as(new ViewName[] {
							 ViewName.DASHBOARD,
							 ViewName.TEST,
							 ViewName.AUTHOR,
							 ViewName.DEVICE,
							 ViewName.LOG
					   }).apply();
		    extentReports.attachReporter(spark);
		}
	
	  @BeforeTest
	  public void setup()
	  {
		  TestBase.openUrl("https://conduit-realworld-example-app.fly.dev/#/");
	  }
	  @Test(priority=1)
	  public void navigateToLoginPageTest()
	  {
		  extentTest=extentReports.createTest("Login Test");
		  homepage.login();
		  Assert.assertEquals(loginPage.getTitle(),"Sign in");
	  }
	  @Test(priority=2)
	  public void login()
	  {
		   
			loginPage.login("pragathisayee@gmail.com","pragathi8");
			String name=driver.findElement(By.xpath("//div[contains(text(),'pragathi')]")).getText();
			Assert.assertEquals(name,"pragathi");
//		  loginPage.login();
//		  Assert.assertEquals(dashboard.getTitle(),"conduit");
	  }
	  
	  @Test(priority=3)
	  public void createArticle()
	  {
		 String articletitle="Testing in selenium";
		 String description="Within your web app’s UI, there are areas where your tests interact with.";
		 String	body="Page Object is a Design Pattern that has become popular in test automation ";
		 String tags="automation";
		 dashboard.navigateToNewArticlePage(); 
		 crnwArticle.createNewArticle(articletitle,description,body,tags);
		 Assert.assertEquals(upArticle.getHeading(),"Testing in selenium");
	  }
	  
	 @Test(priority=4)
	 public void editArticle()
	 {
		 upArticle.navigateToEditArticle();
		 edpage.update();
		 Assert.assertEquals(upArticle.upBody(),"automation in testing");
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
	 
	  @AfterMethod
	  public void teardown(ITestResult result)
	  {
		  extentTest.assignAuthor("AutomationTester2-pragathiSB")
		  .assignCategory("Regression Test")
		  .assignDevice(System.getProperty("os.name"))
		  .assignDevice(System.getProperty("os.version"));
		  
		  if(ITestResult.FAILURE==result.getStatus()) {
			  extentTest.log(Status.FAIL,result.getThrowable().getMessage());
			  String strPath=Utility.getScreenshotPath(driver);
			   extentTest.fail(MediaEntityBuilder.createScreenCaptureFromPath(strPath).build());
	  }
	  }
	  
	  @AfterTest
	   public void finishExtent() {
		  extentReports.flush();
	  }
	  
	  
  
}
