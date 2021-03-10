package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Registration {
	
	private WebDriver driver;

	public Registration (WebDriver driver){
		this.driver = driver;
	}
	
	public WebElement getUsername(){
		return Utils.waitForElementPresence(driver, 10, By.id("login"));
	}
	
	public void setUsername(String username){
		WebElement unesiUsername = getUsername();
		unesiUsername.clear();
		unesiUsername.sendKeys(username);
	}
	
	public WebElement getEmail(){
		return Utils.waitForElementPresence(driver, 10, By.id("email"));
	}
	
	public void setEmail(String email){
		WebElement unesiEmail = getEmail();
		unesiEmail.clear();
		unesiEmail.sendKeys(email);
	}
	
	public WebElement getPassword (){
		return Utils.waitForElementPresence(driver, 10, By.id("password"));
	}
	
	public void setPassword(String password){
		WebElement unesiPass = getPassword();
		unesiPass.clear();
		unesiPass.sendKeys(password);
	}
	
	public WebElement getConfirmPassword(){
		return Utils.waitForElementPresence(driver, 10, By.id("confirmPassword"));
	}
	
	public void setConfirmPassword(String passwordC){
		WebElement unesiPotvrduLozinke = getConfirmPassword();
		unesiPotvrduLozinke.clear();
		unesiPotvrduLozinke.sendKeys(passwordC);
	}
	
	public WebElement registerButton(){
		return Utils.waitToBeClickable(driver, 10, By.xpath("//button[@translate = 'register.form.button']"));
	}
	
	public void clickRegister (){
		registerButton().click();
	}
	
	public void registerNewAcc(String username, String email, String password, String passwordC){
		setUsername(username);
		setEmail(email);
		setPassword(password);
		setConfirmPassword(passwordC);
		clickRegister();
		
	}
	
	public WebElement signIn(){
		return Utils.waitToBeClickable(driver, 10, By.xpath("//a[contains (text(), 'sign in')]"));
	}
	
	public void signInClick(){
		this.signIn().click();
	}
	
	
	
}
