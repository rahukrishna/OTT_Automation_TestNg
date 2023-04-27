import org.testng.annotations.Test;

import pages.AmazonPrimePage;
import pages.BaseClass;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.awt.AWTException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TestCase {
	
	AmazonPrimePage amazon = new AmazonPrimePage();
  @Test
  public void f2() {
	  System.out.println("Sample TestNg");
  }


  @BeforeTest
  public void beforeTest() {
	  //amazon.navigateToAmazon();
	 BaseClass.launchBrowser();
	 BaseClass.launchURL("https://www.primevideo.com/");
  }
  @Test
  public void User_able_to_login() {
	  amazon.SignIn("9074035006","#ranjini01");
	  amazon.verifySignedIn();
	  System.out.println("TC 1 Passed");
  }
  @Test
  public void User_able_to_search_a_movie() throws AWTException {
	  amazon.SignIn("9074035006","#ranjini01");
	  amazon.verifySignedIn();
	  amazon.enterMovieNameandSearch("Annabelle Comes Home");
	  amazon.verifyFilmsDisplayed();
	  System.out.println("TC 1 Passed");
  }

  @AfterTest
  public void afterTest() {
	  BaseClass.closeBrowser();
  }

}
