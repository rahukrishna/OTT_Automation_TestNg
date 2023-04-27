package OTT_Automation.TestNg;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import pages.AmazonPrimePage;
import pages.BaseClass;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.awt.AWTException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;
import org.testng.annotations.*;

public class TestCase {
	
	
	static ExtentTest test;
	static ExtentReports report;
	static DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	static Date date = new Date();
	
	
	@BeforeSuite
	public static void startTest()
	{
	
	try {
		report = new ExtentReports(System.getProperty("user.dir")+"\\HTML_Reports\\ExtentReportResults.html");
	} 
	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println(report.toString());
	test = report.startTest("ExtentDemo");
	}
	
	AmazonPrimePage amazon = new AmazonPrimePage();
 

  @BeforeTest
  public void beforeTest() {
	  //amazon.navigateToAmazon();
	 BaseClass.launchBrowser();
	 BaseClass.launchURL("https://www.primevideo.com/");
  }
  @Parameters({ "username", "password" })
  @Test(enabled =true)
  public void User_able_to_login(String username, String password) {
	  try
	  {
		  amazon.SignIn(username,password);
		  amazon.verifySignedIn();
		  System.out.println("TC 1 Passed");
		  test.log(LogStatus.PASS, "Verified that user able to Login");
	  }
	  catch (Exception e)
	  {
		  test.log(LogStatus.FAIL, "Issue with login"+ e.getMessage());
	  }
	
  }
  @Parameters({ "username", "password" ,"movieName"})
  @Test(enabled =false)
  public void User_able_to_search_a_movie(String username, String password, String movieName) throws AWTException {
	  try
	  {

		  amazon.SignIn(username,password);
		  amazon.verifySignedIn();
		  amazon.enterMovieNameandSearch(movieName);
		  amazon.verifyFilmsDisplayed();		  
		  test.log(LogStatus.PASS, "Verified that user able to search a movie");
	  }
	  catch (Exception e)
	  {
		  test.log(LogStatus.FAIL, "Test Failed"+ e.getMessage());
	  }
  }
  @Parameters({ "username", "password" ,"movieName"})
  @Test(enabled =false)
  public void User_able_to_goto_detail_page(String username, String password, String movieName) throws AWTException {
	  try
	  {

		  amazon.SignIn(username,password);
		  amazon.verifySignedIn();
		  amazon.enterMovieNameandSearch(movieName);
		  amazon.verifyFilmsDisplayed();
		  amazon.navigateToMovie(movieName);
		  amazon.verifyNavigatedToMoviePage(movieName);
		  test.log(LogStatus.PASS, "Verified that user able to go to detail page");
	  }
	  catch (Exception e)
	  {
		  test.log(LogStatus.FAIL, "Test Failed"+ e.getMessage());
	  }
  }
  @Parameters({ "username", "password" ,"movieName"})
  @Test(enabled =false)
  public void User_able_to_Play_a_movie(String username, String password, String movieName) {
	  try
	  {
		  amazon.SignIn(username,password);
		  amazon.verifySignedIn();
		  amazon.enterMovieNameandSearch(movieName);
		  amazon.verifyFilmsDisplayed();
		  amazon.navigateToMovie(movieName);
		  amazon.verifyNavigatedToMoviePage(movieName);
		  amazon.clickOnPlayButton();
		  test.log(LogStatus.PASS, "Verified that user able to go to detail page and Play the movie");
		   }
	  catch (Exception e)
	  {
		  test.log(LogStatus.FAIL, "Test Failed"+ e.getMessage());
	  }
	  
  }
  
  @AfterTest
  public void afterTest() {
	  BaseClass.closeBrowser();
  }
  
  @AfterSuite
  public static void endTest()
  {
  report.endTest(test);
  report.flush();
  }

}
