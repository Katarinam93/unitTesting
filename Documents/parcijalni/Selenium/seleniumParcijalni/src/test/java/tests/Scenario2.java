package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.text.BreakIterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LogedInMain;
import pages.LoginPage;
import pages.MainPage;
import pages.MenyBar;
import pages.Registered;
import pages.Registration;
import pages.Setings;
import pages.Studenti;
import pages.Users;

public class Scenario2 {
	Registered registered;
	Registration registration;
	MainPage mainPage;
	LoginPage loginPage;
	LogedInMain logedInMain;
	MenyBar menyBar;
	Users users;
	Setings setings;
	Studenti studenti;
	
	WebDriver driver;
	
	
	
	@Test
	public void loginAdmin(){
		//1. Login kao administrator (admin, admin)
		
		mainPage.signInClick();
		loginPage.login("admin", "admin");

		String ocekivano = "You are logged in as user \"admin\".";

		// 4. Potvrditi da ste ulogovani kao admin

		assertEquals(logedInMain.sucessMessage("You are logged in as user \"admin\"."), ocekivano);
	}
	
	//2. Napraviti 10 novih studenataa. 
		//  Indeks se krece od E1 do E10
		//	Ime se krece od ime1 do ime103.
		//  Prezime se krece od prezime1 do prezime10
	
	@Test(dependsOnMethods = { "loginAdmin" })
	public void addStudents() {
		
		menyBar.goToStudentPage();
		
		studenti.countBeforeAdd();
		
		int ocekivano = studenti.countBeforeAdd() + 10;
		
		studenti.addMoreStudents(11);
		
		
		studenti.countAfterAdd();
		
		int actual = studenti.countAfterAdd();
				
		assertEquals(actual, ocekivano);
	}
	@Test (dependsOnMethods = { "addStudents" })
		public void deleteAllAddedStudents(){
		
		menyBar.goToStudentPage();
		
		studenti.countBeforeAdd();
		
		int ocekivani = studenti.countBeforeAdd() -10;
		
		studenti.deleteMoreStudents(11);
		

		studenti.countAfterAdd();
		
		int actual = studenti.countAfterAdd();
				
		assertEquals(actual, ocekivani);
		
		//logout
		
		menyBar.logOut();
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
	}

	@AfterSuite
	public void afterSuite() {
		driver.close();
	}

}


