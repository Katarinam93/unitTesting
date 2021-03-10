package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IspitniRok {

	private WebDriver driver;

	public IspitniRok(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement createISpitniRok() {
		return Utils.waitToBeClickable(driver, 10,
				By.xpath("//button[span[@translate='ssluzbaApp.ispitniRokovi.home.createLabel']]"));
	}

	public WebElement getNaziv() {
		return Utils.waitForElementPresence(driver, 10, By.id("field_naziv"));
	}

	public void setNaziv(String naziv) {
		WebElement unesiNaziv = getNaziv();
		unesiNaziv.clear();
		unesiNaziv.sendKeys(naziv);
	}

	public WebElement getPocetak() {
		return Utils.waitForElementPresence(driver, 10, By.id("field_pocetak"));
	}

	public void setPocetak(String pocetak) {
		WebElement unesiPocetak = getPocetak();
		unesiPocetak.clear();
		unesiPocetak.sendKeys(pocetak);
	}

	public WebElement getKraj() {
		return Utils.waitForElementPresence(driver, 10, By.id("field_kraj"));
	}

	public void setKraj(String kraj) {
		WebElement unesiKraj = getKraj();
		unesiKraj.clear();
		unesiKraj.sendKeys(kraj);
	}

	public WebElement saveDugme() {
		return Utils.waitToBeClickable(driver, 10, By.xpath("//button[span[@translate='entity.action.save']]"));
	}

	public void addIspitniRok(String naziv, String pocetak, String kraj)  {

		createISpitniRok().click();
		setNaziv(naziv);
		setPocetak(pocetak);
		setKraj(kraj);
		saveDugme().click();
	}
	
	
	public void addMoreIspitniRokovi(int br){
		
		for(int i = 1; i < br; i++){
			addIspitniRok("naziv" + i, "pocetak", "kraj");
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
	
	public List<WebElement> countAfterAdd(){
		return Utils.waitForElementsPresence(driver, 50, By.xpath("(//tr/td/a)"));
	}
	
	public int countAfterAddInt(){
		return countAfterAdd().size();   
	}
	

	public WebElement proveraRedaIspitnogRoka(String rok, String pocetak, String kraj) {
		return Utils.waitForElementPresence(driver, 10, By.xpath(
				"//tr[td/a/text()='" + rok + "' and //td/text()='" + pocetak + "'  and //td/text()='" + kraj + "']"));
	}
	
	public WebElement viewIspitniRok(String rok, String pocetak, String kraj){
		return Utils.waitForElementPresence(driver, 10, By.xpath("//tr[td/a/text()='" + rok + "' and //td/text()='" + pocetak + "'  and //td/text()='" + kraj + "']//button[span[@translate='entity.action.view']]"));
	}
	
	public WebElement editIspitniRok(String rok, String pocetak, String kraj){
		return Utils.waitForElementPresence(driver, 10, By.xpath("//tr[td/a/text()='" + rok + "' and //td/text()='" + pocetak + "'  and //td/text()='" + kraj + "']//button[span[@translate='entity.action.edit']]"));
	}

	public WebElement deleteIspitniRok(String rok, String pocetak, String kraj){
		return Utils.waitForElementPresence(driver, 10, By.xpath("//tr[td/a/text()='" + rok + "' and //td/text()='" + pocetak + "'  and //td/text()='" + kraj + "']//button[span[@translate='entity.action.delete']]"));
	}
}