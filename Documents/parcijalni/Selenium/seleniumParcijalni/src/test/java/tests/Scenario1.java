package tests;

import org.testng.annotations.Test;

import pages.LogedInMain;
import pages.LoginPage;
import pages.MainPage;
import pages.MenyBar;
import pages.Registered;
import pages.Registration;
import pages.Setings;
import pages.Users;

import org.testng.annotations.BeforeSuite;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.MenuBar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;

public class Scenario1 {
	Registered registered;
	Registration registration;
	MainPage mainPage;
	LoginPage loginPage;
	LogedInMain logedInMain;
	MenyBar menyBar;
	Users users;
	Setings setings;
	WebDriver driver;

	// 1. Registracija novog korisnika (username: marko, password: marko, email:
	// marko@g),

	@Test
	public void registNewUser() {

		mainPage.registerClick();
		registration.registerNewAcc("marko", "marko@g", "marko", "marko");

		//

		assertTrue(registered.successReg());

	}

	@Test(dependsOnMethods = { "registNewUser" })
	public void signInFromReg() {

		// 3. Izvršiti logovanje kao administrator (admin,admin)

		registered.sighInClick();

		loginPage.login("admin", "admin");

		String ocekivano = "You are logged in as user \"admin\".";

		// 4. Potvrditi da ste ulogovani kao admin

		assertEquals(logedInMain.sucessMessage("You are logged in as user \"admin\"."), ocekivano);
	}

	@Test(dependsOnMethods = { "signInFromReg" })
	public void userEdit() {

		menyBar.goToUserMenagment();

		users.editUserClick("marko", "marko@g");

		// b. First Name na “Marko”

		users.setFirsName("Marko");

		// c. Last Name na “Markovic”

		users.setlastName("Markovic");

		// e. Dodati “mail.com” na email.

		users.setEmail("mail.com");

		// a. Activated na true (otkaciti checkbox)

		users.activate();

		// d. Selektovati oba profila (Profiles: ROLE_USER i ROLE_ADMIN)

		users.SetAdminAndUser();

		users.saveClick();

		// Logout

		menyBar.logOut();
	}

	// 8. Potvrditi da su podaci “marko” naloga tačno izmenjeni. (Account >
	// settings)

	@Test(dependsOnMethods = { "userEdit" })

	public void checkChanges() {

		mainPage.signInClick();
		loginPage.login("marko", "marko");

		menyBar.goToSetings();

		String ocekivanoIme = "Marko";
		String actualIme = setings.fistnameCheck();

		assertEquals(actualIme, ocekivanoIme);

		String ocekivanoPrezime = "Markovic";
		String actualPrezime = setings.lastNameCheck();

		assertEquals(actualPrezime, ocekivanoPrezime);

		String ocekivaniEmail = "marko@gmail.com";
		String actualEmail = setings.emailCheck();

		assertEquals(actualEmail, ocekivaniEmail);

		// System.out.println(setings.languageCheck());
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
		// studenti = new Studenti(driver);
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
