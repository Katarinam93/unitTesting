package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Predmeti {

	private WebDriver driver;

	public Predmeti(WebDriver driver) {
		this.driver = driver;

	}

	public WebElement createNewPredmet() {
		return Utils.waitToBeClickable(driver, 10,
				(By.xpath("//button[span[@translate='ssluzbaApp.predmeti.home.createLabel']]")));
	}

	public WebElement getNaziv() {
		return Utils.waitForElementPresence(driver, 10, (By.id("field_naziv")));
	}

	public void setNaziv(String naziv) {
		WebElement unesiNaziv = getNaziv();
		unesiNaziv.clear();
		unesiNaziv.sendKeys(naziv);
	}

	public WebElement izaberiStudenta(String student) {
		return Utils.waitToBeClickable(driver, 10, By.xpath("//option[@label='" + student + "']"));
	}

	public WebElement izaberiNastavnika(String profesor) {
		return Utils.waitToBeClickable(driver, 10, (By.xpath("//option[@label='" + profesor + "']")));
	}

	public WebElement saveDugme() {
		return Utils.waitToBeClickable(driver, 10, By.xpath("//button[span[@translate='entity.action.save']]"));
	}

	public void addPredmet(String naziv, String student, String profesor) throws InterruptedException {
		createNewPredmet().click();
		setNaziv(naziv);
		izaberiStudenta(student).click();
		izaberiNastavnika(profesor).click();
		saveDugme().click();
	}

	public WebElement getRedPRedmeta(String predmet, String student, String profesor) {
		return Utils.waitForElementPresence(driver, 10, By.xpath("//tr[td/a/text()='" + predmet
				+ "' and descendant::a[text()='" + student + "'] and descendant::a[text()='" + profesor + "']]"));
	}

	// public String proveraTabele(){
	// return getRedPRedmeta("Matematika", "Marko Markovic", "Milan
	// Markovic").getText().substring(0, 40);
	// }
	//

	public WebElement viewPredmet(String predmet, String student, String profesor) {
		return Utils.waitToBeClickable(driver, 10,
				By.xpath("//tr[td/a/text()='" + predmet + "' and descendant::a[text()='" + student
						+ "'] and descendant::a[text()='" + profesor
						+ "']]//button[span[@translate='entity.action.view']]"));
	}

	public WebElement editPredmet(String predmet, String student, String profesor) {
		return Utils.waitToBeClickable(driver, 10,
				By.xpath("//tr[td/a/text()='" + predmet + "' and descendant::a[text()='" + student
						+ "'] and descendant::a[text()='" + profesor
						+ "']]//button[span[@translate='entity.action.edit']]"));
	}

	public WebElement deletePredmet(String predmet, String student, String profesor) {
		return Utils.waitToBeClickable(driver, 10,
				By.xpath("//tr[td/a/text()='" + predmet + "' and descendant::a[text()='" + student
						+ "'] and descendant::a[text()='" + profesor
						+ "']]//button[span[@translate='entity.action.delete']]"));
	}

}
