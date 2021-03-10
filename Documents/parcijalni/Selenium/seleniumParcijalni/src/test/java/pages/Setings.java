package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Setings {
	
	private WebDriver driver;
	
	public Setings (WebDriver driver){
		this.driver = driver;
	}
	
	public WebElement getfirstName(){
		return Utils.waitForElementPresence(driver, 10, By.id("firstName"));
	}
	
	public String fistnameCheck(){
		return getfirstName().getAttribute("value");
	}
	
	public WebElement getLastName (){
		return Utils.waitForElementPresence(driver, 10, By.id("lastName"));
	}

	public String lastNameCheck(){
		return getLastName().getAttribute("value");
	}
	
	public WebElement getEmail(){
		return Utils.waitForElementPresence(driver, 10, By.id("email"));
	}
	
	public String emailCheck(){
		return getEmail().getAttribute("value");
	}
	public WebElement languageSelect(){
		return Utils.waitForElementPresence(driver, 10, By.id("langKey"));
	}
	public String languageCheck(){
		return languageSelect().getAttribute("value");
	}
	
	public WebElement saveButton(){
		return Utils.waitToBeClickable(driver, 10, By.cssSelector("button[translate = 'settings.form.button']"));
	}
}
