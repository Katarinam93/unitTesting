package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MenyBar {

	private WebDriver driver;

	public MenyBar(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement home() {
		return Utils.waitToBeClickable(driver, 10, (By.xpath(("//a[span[@translate='global.menu.home']]"))));
	}

	// Entities

	public WebElement entites() {
		return Utils.waitToBeClickable(driver, 10, (By.xpath("//a[*//span[@translate='global.menu.entities.main']]")));
	}

	public WebElement karticaStudenti() {
		return Utils.waitToBeClickable(driver, 10, (By.xpath("//span[@translate='global.menu.entities.studenti']")));
	}

	public WebElement karticaNastavnici() {
		return Utils.waitToBeClickable(driver, 10,
				(By.xpath("//a[span[@translate='global.menu.entities.nastavnici']]")));
	}

	public WebElement karticaPredmeti() {
		return Utils.waitToBeClickable(driver, 10, (By.xpath("//a[span[@translate='global.menu.entities.predmeti']]")));
	}

	public WebElement karticaISpitniRokovi() {
		return Utils.waitToBeClickable(driver, 10,
				(By.xpath("//a[span[@translate='global.menu.entities.ispitniRokovi']]")));
	}

	public WebElement karticaISpitnePrijave() {
		return Utils.waitToBeClickable(driver, 10,
				(By.xpath("//a[span[@translate='global.menu.entities.ispitnePrijave']]")));
	}

	// Administracija

	public WebElement administration() {
		return Utils.waitToBeClickable(driver, 10, By.xpath("//a[span/span[@translate='global.menu.admin.main']]"));
	}

	public WebElement userMenagment() {
		return Utils.waitToBeClickable(driver, 10,
				By.xpath("//a[span[@translate='global.menu.admin.user-management']]"));
	}
	
	public WebElement metrics(){
		return Utils.waitToBeClickable(driver, 10, By.xpath("//a[span[@translate='global.menu.admin.metrics']]"));
	}
	
	public WebElement health() {
		return Utils.waitToBeClickable(driver, 10, By.xpath("//a[span[@translate='global.menu.admin.health']]"));
	}
	
	public WebElement configuration(){
		return Utils.waitToBeClickable(driver, 10, By.xpath("//a[span[@translate='global.menu.admin.configuration']]"));
	}
	
	public WebElement audits(){
		return Utils.waitToBeClickable(driver, 10, By.xpath("//a[span[@translate='global.menu.admin.audits']]"));
	}
	
	public WebElement logs(){
		return Utils.waitToBeClickable(driver, 10, By.xpath("//a[span[@translate='global.menu.admin.logs']]"));
	}

	public WebElement api (){
		return Utils.waitToBeClickable(driver, 10, By.xpath("//a[span[@translate='global.menu.admin.apidocs']]"));
	}
	//Account kada nisi ulogovan
	
	public WebElement signIn(){
		return Utils.waitToBeClickable(driver, 10, By.xpath("//li[a/span[@translate='global.menu.account.login']]"));
	}
	
	public WebElement register(){
		return Utils.waitToBeClickable(driver, 10, By.xpath("//li[a/span[@translate='global.menu.account.register']]"));
	}
	
	
	// Account kada si ulogovan
	
	public WebElement account(){
		return Utils.waitToBeClickable(driver, 10, By.xpath("//a[span/span[@translate='global.menu.account.main']]"));
	}
	
	public WebElement setings(){
		return Utils.waitToBeClickable(driver, 10, By.xpath("//a[span[@translate='global.menu.account.settings']]"));
	}
	
	public WebElement password(){	//css selektor
		return Utils.waitToBeClickable(driver, 10, By.cssSelector("span[translate='global.menu.account.password']"));
	}
	
	public WebElement signOut(){	//css selektor
		return Utils.waitToBeClickable(driver, 10, By.cssSelector("span[translate='global.menu.account.logout']"));
	}
	
	// Language
	
	public WebElement language(){
		return Utils.waitToBeClickable(driver, 10, By.xpath("//a[*//span[@translate = 'global.menu.language']]"));
	}
	
	public WebElement english(){
		return Utils.waitToBeClickable(driver, 10, By.xpath("//li[a[contains (text(), 'English')]]"));
	}
	
	public WebElement français(){
		return Utils.waitForElementPresence(driver, 10, By.xpath("//li[a[contains (text(), 'Français')]]"));
	}
	
	// metode za pozivanje samih stranica koje ubacujem u testove

	public void goToHomePage() {
		home().click();
	}

	public void goToStudentPage() {
		entites().click();
		karticaStudenti().click();
	}

	public void goToNastavniciPage() {
		entites().click();
		karticaNastavnici().click();
	}

	public void goToPredmetiPage() {
		entites().click();
		karticaPredmeti().click();
	}

	public void goToIspitniRokPage() {
		entites().click();
		karticaISpitniRokovi().click();
	}

	public void goToIspitnePrijavePage() {
		entites().click();
		karticaISpitnePrijave().click();
	}

	// metoda za administraciju

	public void goToUserMenagment() {
		administration().click();
		userMenagment().click();
	}
	
	//metode za Account kada nisi ulogovan
	
	public void goToSignInPAge(){
		account().click();
		signIn().click();
	}
	
	public void goToRegisterPage(){
		account().click();
		register().click();
	}
	
	// metode za Account kada si ulogovan
	
	public void goToSetings(){
		account().click();
		setings().click();
	}
	
	public void goToPassword(){
		account().click();
		password().click();
	}
	
	public void logOut(){
		account().click();
		signOut().click();
	}
	

	//metode za language
	
	public void selectEnglishLang(){
		language().click();
		english().click();
	}
	
	public void selectFrançaisLang(){
		language().click();
		français().click();
	}

}
