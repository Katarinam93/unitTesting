package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}


	public WebElement username() {
		return Utils.waitForElementPresence(driver, 10, (By.id("username")));
	}

	public WebElement password() {
		return Utils.waitForElementPresence(driver, 10, (By.id("password")));
	}

	public WebElement loginDugme() {
		return Utils.waitForElementPresence(driver, 10, (By.xpath("//button[@translate='login.form.button']")));
	}

	public void setUsername(String username) {
		WebElement userEl = username();
		userEl.clear();
		userEl.sendKeys(username);
	}

	public void setPassword(String password) {
		this.password().clear();
		this.password().sendKeys(password);

	}

	public void login(String username, String password) {
		setUsername(username);
		setPassword(password);
		loginDugme().click();
	}
	
	public WebElement forgotPasword(){
		return Utils.waitToBeClickable(driver, 10, By.xpath("//a[@translate='login.password.forgot']"));
	}
	
	public void goToResetPassword(){
		this.forgotPasword().click();
	}
	

}
