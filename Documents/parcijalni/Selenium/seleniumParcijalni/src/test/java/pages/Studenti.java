package pages;

import static org.testng.Assert.assertFalse;

import java.util.List;
import org.openqa.selenium.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class Studenti {
	
	private WebDriver driver;

	public Studenti(WebDriver driver) {
		this.driver = driver;
	}


	public WebElement createStudent() {
		return Utils.waitToBeClickable(driver, 30, By.xpath("//button[span[@translate='ssluzbaApp.studenti.home.createLabel']]"));
	}

	public WebElement getIndeks() {
		return Utils.waitForElementPresence(driver, 10, (By.id("field_indeks")));
	}

	public void setIndeks(String indeks) {
		WebElement inputIndeks = getIndeks();
		inputIndeks.clear();
		inputIndeks.sendKeys(indeks);

	}

	public WebElement getIme() {
		return Utils.waitForElementPresence(driver, 10, (By.id("field_ime")));
	}

	public void setIme(String ime) {
		WebElement inputIme = getIme();
		inputIme.clear();
		inputIme.sendKeys(ime);
	}

	public WebElement getPrezime() {
		return Utils.waitForElementPresence(driver, 10, (By.id("field_prezime")));
	}

	public void setPrezime(String prezime) {
		WebElement inputPrezime = getPrezime();
		inputPrezime.clear();
		inputPrezime.sendKeys(prezime);
	}

	public WebElement getGrad() {
		return Utils.waitForElementPresence(driver, 10, (By.id("field_grad")));
	}

	public void setGrad(String grad) {
		WebElement inputGrad = getGrad();
		inputGrad.clear();
		inputGrad.sendKeys(grad);
	}

	public WebElement saveStudentDugme() {
		return Utils.waitToBeClickable(driver, 10, (By.xpath("//button[span[@translate='entity.action.save']]")));
	}

	public void addNewStudent(String indeks, String ime, String prezime, String grad) {
		createStudent().click();
		setIndeks(indeks);
		setIme(ime);
		setPrezime(prezime);
		setGrad(grad);
		saveStudentDugme().click();
	}
	
	public void addMoreStudents(int br){
		
		for(int i = 1; i < br; i++){
			addNewStudent("E" + i, "ime" + i, "prezime" + i, "grad" + i);
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
	

	
	public boolean studentCheck(String indeks) {
		return Utils.isPresent(driver, (By.xpath("//tr[td/a/text()='" + indeks + "']//a[contains(text(),'" + indeks + "')]")));
				

	}
//	public void getStudentCheckText(String indeks){
//		String studentText = studentCheck(indeks).getText();
//	}

	public WebElement editStudent(String indeks) {
		return Utils.waitToBeClickable(driver, 10, (By.xpath("//tr[td/a/text()='" + indeks + "']//span[@translate='entity.action.edit']")));
	}

	public void setEditStudent(String indeks) {
		WebElement unesiBrojIndeksa = editStudent(indeks);
		unesiBrojIndeksa.click();

	}

	public WebElement noviGradEdit() {
		return Utils.waitToBeClickable(driver, 10, (By.id("field_grad")));
	}

	public void setNoviGrad(String noviGrad) {
		WebElement unesiNoviGrad = noviGradEdit();
		unesiNoviGrad.clear();
		unesiNoviGrad.sendKeys(noviGrad);
	}

	public void editNoviGrad(String noviGrad, String indeks) {
		setEditStudent(indeks);
		setNoviGrad(noviGrad);
		saveStudentDugme().click();

	}

	public String checkIzmene(String noviGrad, String indeks) {
		return Utils.waitForElementPresence(driver, 10, (By.xpath("//tr[td/a/text()='" + indeks + "']//td[contains(text(),'" + noviGrad + "')]")))
				.getText();
	}

	public WebElement deleteStudent(String indeks) {
		return Utils.waitToBeClickable(driver, 10, (By.xpath("//tr[td/a/text()='" + indeks + "']//span[@translate='entity.action.delete']")));
	}

	public WebElement confirmDeletion() {
		return Utils.waitToBeClickable(driver, 10, (By.xpath("//button[@ng-disabled='deleteForm.$invalid']//span[@translate='entity.action.delete']")));
	}

	public void studentDeletion(String indeks) {
		deleteStudent(indeks).click();
		confirmDeletion().click();

	}
	public void deleteMoreStudents(int br){
		
		for(int i = 1; i < br; i++){
			studentDeletion("E" + i);
		}
	}

	public boolean checkBrisanje(){

		Utils.isPresent(driver, By.xpath("//tr/td/a"));
		List<WebElement> deletedStudentCheck = driver.findElements(By.xpath("//tr/td/a"));
		for (WebElement indeks : deletedStudentCheck) {
			String textIndeksa = indeks.getText();
			if (textIndeksa.equals("E5652") || textIndeksa.equals("E1234")) {
				return true;
			}
		}
		return false;
	}
	

			

	public void isStudentPresent2(String indeks){
		try {
			 WebElement find = driver.findElement(By.xpath("//tr[td/a/text() = '"+ indeks +"']"));
			 //assertFalse(true, "Element still present, should be deleted E5652");;
		  } catch (NoSuchElementException e) {
			//element not found, nothing to assert
		  }
		}
	
	  
	
	public WebElement viewStudent(String indeks) {
		return Utils.waitToBeClickable(driver, 10, (By.xpath("//tr[td/a/text()='" + indeks + "']//span[@translate='entity.action.view']")));
	}

}
