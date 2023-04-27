package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import static org.junit.Assert.*;

import org.openqa.selenium.WebElement;

import dev.failsafe.internal.util.Assert;

public class AmazonPrimePage extends BaseClass {
	
	 
	  public AmazonPrimePage() {
		  super(driver);
		// TODO Auto-generated constructor stub
	}
	//
	  ////span[contains(text(),'Sign in to join Prime')]
	private String navigatetosigninButton = "//span[contains(text(),'Sign in')]/ancestor::button";
	private String userNameTextbox = "//input[contains(@id,'email')]";
	private String passwordTextbox = "//input[contains(@id,'pass')]";
	private String signInButton = "//input[@id='signInSubmit']";
	private String HomeButton = "//a[@class='RsC68p']/span";
	private String searchButton = "//input[@class='HBmJQt']";
	private String searchBox = "//input[@id='pv-search-nav']";
	private String searchResults ="//div[@class='K0Kf63 _9kJogN']/parent::div";
	private String movieList = "//div[@class='OKS56b']//a";
	private String moviePageHeader ="//h1";
	
	    /*private String pickThirdItem2="//div[@class='sg-col-inner']//div[@class='a-section a-spacing-small a-spacing-top-small']//div[@class='a-section a-spacing-none puis-padding-right-small s-title-instructions-style']//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']";
	    /*private String addToCart = "//input[@id='add-to-cart-button']";
	    private String addToCartMsg = "//span[contains(text(),'Agregado al carrito')]";*/
	    
	 public void navigateToAmazon(){
	       launchURL("https://www.primevideo.com/");
	    }
	 public void clickSigninButton(){
	        clickElement(navigatetosigninButton);
	    }//div[@class='OKS56b']//a
	 
	 public void SignIn(String username, String password){
		 clickElement(navigatetosigninButton);
	        type(userNameTextbox,username);
	        type(passwordTextbox,password);
	        clickElement(signInButton);
	        
	    }
	 public void enterMovieNameandSearch(String MovieName) throws AWTException{
	      
	        clickJS(searchBox);
	        typeJS(searchBox,MovieName);
	        //pressEnterKey();
	        pressEnterKeyJS(searchBox);
	        //typeEnterKey(searchBox);
	        
	        
	    }
	 public boolean verifySearchResults(String MovieName){
	      String xpath ="//span[contains(text(),'"+MovieName+"')]";
	    		  getElement(xpath);
			 return true;
	        
	    }
	
	 
	 public boolean verifyFilmsDisplayed(){
	      
	    		  getElement(searchResults);
			 return true;
	        
	    }
	 public void clickonSearchMovie(){
	      
	        clickElement(searchButton);
	        
	    }
	 
	 public boolean verifySignedIn(){
		 getElement(HomeButton);
		 return true;
	        
	    }
	 
	 public void navigateToMovie(String movieName){
		 
		 List <WebElement> movies= getElements(movieList);
	
	     for   (WebElement ele : movies)
	     {
	    	if (ele.getText().equals(movieName))
	    	{
	    		ele.click();
	    		break;
	    	}
	     }
	    }
	 
	 public void verifyNavigatedToMoviePage(String movieName){
		 String test = textFromElement(moviePageHeader);
		 if (!test.contains(movieName))
		 {
			 Assert.isTrue(false, test, null);
			 //Assert.fail(); 
		 }
		
	        
	    }
	 
}
