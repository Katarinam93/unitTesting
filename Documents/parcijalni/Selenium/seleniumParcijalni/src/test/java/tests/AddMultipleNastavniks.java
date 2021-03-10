package tests;

import org.testng.annotations.Test;

import pages.LogedInMain;
import pages.LoginPage;
import pages.MainPage;
import pages.MenyBar;
import pages.Nastavnici;
import pages.Registered;
import pages.Registration;
import pages.Setings;
import pages.Studenti;
import pages.Users;

import org.testng.annotations.BeforeSuite;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;

public class AddMultipleNastavniks {
	
	Registered registered;
	Registration registration;
	MainPage mainPage;
	LoginPage loginPage;
	LogedInMain logedInMain;
	MenyBar menyBar;
	Users users;
	Setings setings;
	Nastavnici nastavnici;
	Studenti studenti;
	WebDriver driver;
	
  @Test
  public void addMoreThanOneNastavnik() {
	  

	  mainPage.signInClick();
	  loginPage.login("admin", "admin");
	  
	  menyBar.goToNastavniciPage();
	  
	  nastavnici.countBeforeAdd();

	  int ocekivano = nastavnici.countBeforeAdd() + 15;
	  nastavnici.addMoreNastavniks(16);
	  
	  nastavnici.countAfterAdd();
	  
	  int actual = nastavnici.countAfterAdd();
	  
	  assertEquals(actual, ocekivano);
	 
	  
  }
  @Test(dependsOnMethods = { "addMoreThanOneNastavnik" })
  public void deleteMoreThanOneNastavnik(){
	  
	  

	  nastavnici.countBeforeAdd();
	  int ocekivano = nastavnici.countBeforeAdd() - 15;
	  
	  nastavnici.deleteMoreNastavniks(16);
	  
	  nastavnici.countAfterAdd();
	  
	  int actual = nastavnici.countAfterAdd();
	  
	  assertEquals(actual, ocekivano);
	  
  }
  
  @BeforeSuite
  public void beforeSuite() {
	  System.setProperty("webdriver.chrome.driver", "chromedriver");
		driver = new ChromeDriver();

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("http://www.localhost:8080/#/");

		loginPage = new LoginPage(driver);
		mainPage = new MainPage(driver);
		logedInMain = new LogedInMain(driver);
		studenti = new Studenti(driver);
		menyBar = new MenyBar(driver);
		registration = new Registration(driver);
		registered = new Registered(driver);
		users = new Users(driver);
		setings = new Setings(driver);
		nastavnici = new Nastavnici(driver);
  }

  @AfterSuite
  public void afterSuite() {
		driver.close();

  }

}
