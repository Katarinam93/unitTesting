package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Registered {
	
	private WebDriver driver;

	public Registered(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean successReg (){
		return Utils.isPresent(driver, By.xpath("//strong[contains (text(), 'Registration saved!')]"));
	}
	
	public WebElement signInLink (){
		return Utils.waitToBeClickable(driver, 10, By.xpath("//a[contains (text(),'sign in')]"));
	}
	
	public void sighInClick (){
		signInLink().click();
	}
	
	
}
