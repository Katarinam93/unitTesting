package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResetPassword {
	
	private WebDriver driver;

	public ResetPassword(WebDriver driver){
		this.driver= driver;
	}
	
	public boolean assertPage(){
		return Utils.isPresent(driver, By.cssSelector("h1[translate = 'reset.request.title']"));
	}
	
	public WebElement getEmail(){
		return Utils.waitForElementPresence(driver, 10, By.id("email"));
	}
	
	public void setEmail(String email){
		this.getEmail().clear();
		this.getEmail().sendKeys(email);
	}
	
	public WebElement resetPassButton(){
		return Utils.waitForElementPresence(driver, 10, By.xpath("//button[@translate='reset.request.form.button']"));
	}
	
	public boolean resetButtonEnabled(){
		return this.resetPassButton().isEnabled();
	}
	
	public void resetButtonClick(){
		this.resetPassButton().click();
	}
	
	public String emailsIsRequired(){
		return Utils.waitForElementPresence(driver, 10, By.xpath("//p[@translate='global.messages.validate.email.required']")).getText();
	}
	
	public String emailIsInvalid(){
		return Utils.waitForElementPresence(driver, 10, By.xpath("//p[@translate='global.messages.validate.email.invalid']")).getText();
	}
	
	public String minimalLengthEmailError(){
		return Utils.waitForElementPresence(driver, 10, By.xpath("//p[@translate = 'global.messages.validate.email.minlength']")).getText();
	}
	
	public String susccessMsg(){
		return Utils.waitForElementPresence(driver, 50, By.xpath("//p[@translate = 'reset.request.messages.success']")).getText();
	}
	public void clearEmailField(String email){
		setEmail(email);
		this.getEmail().clear();
		
	}
	
	public void enterEmail(String email){
		setEmail(email);
		resetButtonClick();
	}
}
