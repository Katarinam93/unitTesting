package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
	
	private WebDriver driver;
	
	
	public MainPage (WebDriver driver){
		this.driver=driver;
	}
	
	public WebElement signInLink (){
		return Utils.waitToBeClickable(driver, 10, By.linkText("sign in"));
	}
	
	public void signInClick (){
		signInLink().click();
	}
	
	public WebElement registerLink(){
		return Utils.waitToBeClickable(driver, 10, (By.linkText("Register a new account")));
	}
	
	public void  registerClick(){
		registerLink().click();
	}
	
	

}
