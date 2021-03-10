package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IspitnePrijave {

	private WebDriver driver;

	public IspitnePrijave(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement createIspitnaPrijava() {
		return Utils.waitToBeClickable(driver, 10,
				By.xpath("//button[span[@translate='ssluzbaApp.ispitnePrijave.home.createLabel']]"));
	}

	public WebElement getTeorija() {
		return Utils.waitForElementPresence(driver, 10, By.id("field_teorija"));
	}

	public void setTeorija(String teorija) {
		WebElement unesiBodoveTeorije = getTeorija();
		unesiBodoveTeorije.clear();
		unesiBodoveTeorije.sendKeys(teorija);
	}

	public WebElement getZadaci() {
		return Utils.waitForElementPresence(driver, 10, By.id("field_zadaci"));
	}

	public void setZadaci(String zadaci) {
		WebElement unesiBodoveZadataka = getZadaci();
		unesiBodoveZadataka.clear();
		unesiBodoveZadataka.sendKeys(zadaci);
	}

	public WebElement addRok(String rok) {
		return Utils.waitForElementPresence(driver, 10,
				By.xpath("//select[@id='field_ispitniRok']/option[text()='" + rok + "']"));
	}

	public WebElement addStudents(String indeks) {
		return Utils.waitForElementPresence(driver, 10,
				By.xpath("//select[@id='field_student']/option[contains(text(),'" + indeks + "')]"));
	}

	public WebElement addPredmet(String predmet) {
		return Utils.waitForElementPresence(driver, 10,
				By.xpath("//select[@id='field_predmet']/option[text()='" + predmet + "']"));
	}

	public WebElement saveDugme() {
		return Utils.waitToBeClickable(driver, 10, By.xpath("//button[span[@translate='entity.action.save']]"));
	}

	public void addIspitnaPrijava(String teorija, String zadaci, String indeks, String predmet, String rok) {
		createIspitnaPrijava().click();
		setTeorija(teorija);
		setZadaci(zadaci);
		addRok(rok).click();
		addStudents(indeks).click();
		addPredmet(predmet).click();
		saveDugme().click();
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


	public WebElement proveraRedaIspitnePrijave(String teorija, String zadaci, String rok, String student,
			String predmet) {
		return Utils.waitForElementPresence(driver, 10,
				By.xpath("//tr[td/text()='" + teorija + "'and //td/text()='" + zadaci + "' and //a/text()='" + rok
						+ "' and  //a/text()='" + student + "' and //a/text()='" + predmet + "']"));
	}

	// public String textIspitnePrijave(){
	// return proveraRedaIspitnePrijave("47", "39", "Aprilski", "E1234 Marko
	// Markovic", "Matematika").getText().substring(2, 48);
	// }

	public WebElement viewIspitnePrijave(String teorija, String zadaci, String rok, String student, String predmet) {
		return Utils.waitForElementPresence(driver, 10,
				By.xpath("//tr[td/text()='" + teorija + "'and //td/text()='" + zadaci + "' and //a/text()='" + rok
						+ "' and  //a/text()='" + student + "' and //a/text()='" + predmet
						+ "']//button[span[@translate='entity.action.view']]"));
	}

	public WebElement editIspitnePrijave(String teorija, String zadaci, String rok, String student, String predmet) {
		return Utils.waitForElementPresence(driver, 10,
				By.xpath("//tr[td/text()='" + teorija + "'and //td/text()='" + zadaci + "' and //a/text()='" + rok
						+ "' and  //a/text()='" + student + "' and //a/text()='" + predmet
						+ "']//button[span[@translate='entity.action.edit']]"));
	}

	public WebElement deleteIspitnePrijave(String teorija, String zadaci, String rok, String student, String predmet) {
		return Utils.waitForElementPresence(driver, 10,
				By.xpath("//tr[td/text()='" + teorija + "'and //td/text()='" + zadaci + "' and //a/text()='" + rok
						+ "' and  //a/text()='" + student + "' and //a/text()='" + predmet
						+ "']//button[span[@translate='entity.action.delete']]"));
	}

}
