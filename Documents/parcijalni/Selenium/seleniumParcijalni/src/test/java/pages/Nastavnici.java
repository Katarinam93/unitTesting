package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class Nastavnici {

	private WebDriver driver;

	public Nastavnici(WebDriver driver) {
		this.driver = driver;
	}


	public WebElement createNewNastavnik() {
		return Utils.waitToBeClickable(driver, 50, (By.xpath("//button[span[@translate='ssluzbaApp.nastavnici.home.createLabel']]")));
	}

	public WebElement getIme() {
		return Utils.waitForElementPresence(driver, 10, (By.id("field_ime")));
	}

	public void setIme(String ime) {
		WebElement unesiIme = getIme();
		unesiIme.clear();
		unesiIme.sendKeys(ime);
	}

	public WebElement getPrezime() {
		return Utils.waitForElementPresence(driver, 10, By.id("field_prezime"));
	}

	public void setPrezime(String prezime) {
		WebElement unesiPrezime = getPrezime();
		unesiPrezime.clear();
		unesiPrezime.sendKeys(prezime);
	}

	public WebElement getZvanje() {
		return Utils.waitForElementPresence(driver, 10, By.id("field_zvanje"));
	}

	public void setZvanje(String zvanje) {
		WebElement unesiZvanje = getZvanje();
		unesiZvanje.clear();
		unesiZvanje.sendKeys(zvanje);
	}

	public WebElement saveNastavnik() {
		return Utils.waitToBeClickable(driver, 10, (By.xpath("//button[span[@translate='entity.action.save']]")));
	}

	public void addNewNastavnik(String ime, String prezime, String zvanje) {
		createNewNastavnik().click();
		setIme(ime);
		setPrezime(prezime);
		setZvanje(zvanje);
		saveNastavnik().click();
	}
	
	public void addMoreNastavniks(int br){
		
		for(int i = 1; i < br; i++){
			addNewNastavnik("ime" + i, "prezime" + i, "zvanje" + i);
		}
	}
	
	public int countBeforeAdd(){
		boolean postoji = Utils.isPresent(driver, By.xpath("//tr/td/a"));
		if (postoji == true){
		return  Utils.waitForElementsPresence(driver, 50, By.xpath("//tr/td/a")).size();
		}
		else{
			return 0;
		}
	}
	
	public int countAfterAdd(){
		
		boolean postoji = Utils.isPresent(driver, By.xpath("//tr/td/a"));
		
		if (postoji == true){
			
		return Utils.waitForElementsPresence(driver, 50, By.xpath("(//tr/td/a)")).size();
		}
		
		else {
			return 0;
		}
	}
	

	public WebElement redNasegNastavnika(String ime, String prezime, String zvanje) {
		return Utils.waitForElementPresence(driver, 10, (By.xpath("//tr[td/a/text()='"+ime+"'and td/text()='"+prezime+"' and td/text()='"+zvanje+"']")));
	}

//	public String redNasegNastavnikaText() {
//		return redNasegNastavnika("Milan", "Markovic", "Profesor").getText().substring(0, 23);
//	}

	public WebElement viewNastavnika (String ime, String prezime, String zvanje){
		return Utils.waitToBeClickable(driver, 10, (By.xpath("//tr[td/a/text()='"+ime+"'and td/text()='"+prezime+"' and td/text()='"+zvanje+"']//button[span[@translate='entity.action.view']]")));
	}
	
	public WebElement deleteNastavnika (String ime, String prezime, String zvanje){
		return Utils.waitToBeClickable(driver, 50, (By.xpath("//tr[td/a/text()='"+ime+"'and td/text()='"+prezime+"' and td/text()='"+zvanje+"']//button[span[@translate='entity.action.delete']]")));
	}
	public WebElement confDelete(){
		return Utils.waitToBeClickable(driver, 10, By.xpath("//form//button[span[@translate = 'entity.action.delete']]"));
	}
	
	public void deleteNastavnikClick(String ime, String prezime, String zvanje){
		deleteNastavnika(ime, prezime, zvanje).click();
		confDelete().click();
	}
	public void deleteMoreNastavniks(int br){
		
		for(int i = 1; i < br; i++){
			deleteNastavnikClick("ime" + i, "prezime" + i, "zvanje" + i);
		}
	}
}
