package pages;

import javax.swing.plaf.basic.BasicTreeUI.CellEditorHandler;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Users {

	WebDriver driver;

	public Users(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement createUser() {
		return Utils.waitToBeClickable(driver, 10,
				By.xpath("//button[span[@translate = 'user-management.home.createLabel']]"));
	}

	public boolean findRow(String login, String email) {
		return Utils.isPresent(driver, By.xpath("//tr[td[text()='" + login + "'] and td[text()='" + email + "']]"));
	}

	// a. Activated na true (otkaciti checkbox)

	public WebElement getActivateUser(String login, String email) {
		return Utils.waitForElementPresence(driver, 10, By.xpath("//tr[td[text()='" + login + "'] and td[text()='"
				+ email + "']]//span[@translate='user-management.deactivated']"));
	}

	public void activateUser(String login, String email) {
		getActivateUser(login, email).click();
	}

	// b. First Name na “Marko”

	public WebElement geteditUser(String login, String email) {
		return Utils.waitToBeClickable(driver, 10,
				By.xpath("//tr[td[text()='" + login + "'] and td[text()='" + email + "']]//button[2]"));
	}

	public void editUserClick(String login, String email) {
		geteditUser(login, email).click();
	}

	public WebElement getLogin() {
		return Utils.waitForElementPresence(driver, 10, By.name("login"));
	}

	public void setLogin(String login) {
		WebElement unesiNoviLogin = getLogin();
		unesiNoviLogin.clear();
		unesiNoviLogin.sendKeys(login);
	}

	public WebElement saveChanges() {
		return Utils.waitToBeClickable(driver, 10, By.xpath("//button[span[@translate='entity.action.save']]"));
	}
	public void saveClick(){
		saveChanges().click();
	}

	public WebElement getFirstName() {
		return Utils.waitForElementPresence(driver, 10, By.name("firstName"));
	}

	public void setFirsName(String firstName) {
		WebElement unesiNovoIme = getFirstName();
		unesiNovoIme.clear();
		unesiNovoIme.sendKeys(firstName);
	}

	public WebElement getLastName() {
		return Utils.waitForElementPresence(driver, 10, By.name("lastName"));
	}

	public void setlastName(String lastName) {
		WebElement unesiNovoPrezime = getLastName();
		unesiNovoPrezime.clear();
		unesiNovoPrezime.sendKeys(lastName);
	}

	public WebElement getEmail() {
		return Utils.waitForElementPresence(driver, 10, By.name("email"));
	}

	public void setEmail(String email) {
		WebElement unesiNoviEmail = getEmail();
		//unesiNoviEmail.clear();
		unesiNoviEmail.sendKeys(email);
	}

	public WebElement checkActive() {
		return Utils.waitToBeClickable(driver, 10, By.id("activated"));
	}

	public void activate() {
		checkActive().click();
	}
	
	public WebElement getlanguage (String lang){
		return Utils.waitToBeClickable(driver, 10, By.xpath("//option[text()='"+lang+"']"));
	}
	public void setLanguage(String lang){
		getlanguage(lang).click();
	}
	
	public WebElement getRoleUser(){
		return Utils.waitToBeClickable(driver, 10, By.xpath("//option[@label='ROLE_USER']"));
	}
	
	public void setRoleUser(){
		getRoleUser().click();
	}
	
	public WebElement getRoleAdmin(){
		return Utils. waitToBeClickable(driver, 10, By.xpath("//option[@label='ROLE_ADMIN']"));
	}

	public void setRoleAdmin(){
		getRoleAdmin().click();
	}
	
	public void SetAdminAndUser(){
		Actions builder = new Actions(driver);
		Action multipleSelect = builder.keyDown(Keys.CONTROL).click(getRoleAdmin()).keyUp(Keys.CONTROL).build();
		multipleSelect.perform();
	}
	
	//primer sedam sa termina 17
}// ubaciti delete i view
