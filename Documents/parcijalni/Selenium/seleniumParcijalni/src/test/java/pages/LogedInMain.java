package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class LogedInMain {

	private WebDriver driver;

	public LogedInMain(WebDriver driver) {
		this.driver = driver;
	}
	//parametrizovala sam i succes message, iako na ovom sajtu za to nema preterane potrebe
	public String sucessMessage(String success) {
		return Utils.waitForElementPresence(driver, 10, (By.xpath("//div[contains(text(),'"+success+"')]"))).getText();	}
	
}
