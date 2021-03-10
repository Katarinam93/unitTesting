package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Password {
	
	private WebDriver driver;
	
	public Password (WebDriver driver){
		this.driver = driver; 
	}
	
	public WebElement newPassword(){
		return Utils.waitForElementPresence(driver, 10, By.id("password"));
	}
	
	public void setNewPassword(String password){
		WebElement unesiNoviPass = newPassword();
		unesiNoviPass.clear();
		unesiNoviPass.sendKeys("password");
	}
	
	public WebElement confPassword(){
		return Utils.waitForElementPresence(driver, 10, By.id("confirmPassword"));
	}
	
	public void confPassSet(String cPassword){
		WebElement potvrdiLozinku = confPassword();
		potvrdiLozinku.clear();
		potvrdiLozinku.sendKeys("cPassword");
	}
	
	public WebElement saveButton(){
		return Utils.waitToBeClickable(driver, 10, By.cssSelector("button[translate = 'password.form.button']"));
	}
	
	public void changePassword(String password, String cPassword){
		setNewPassword(password);
		confPassSet(cPassword);
		saveButton().click();
	}

}
