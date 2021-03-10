package tests;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.MainPage;
import pages.MenyBar;
import pages.ResetPassword;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeSuite;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

public class TestResetPassword {

	MenyBar menyBar;
	MainPage mainPage;
	LoginPage loginPage;
	ResetPassword resetPass;
	WebDriver driver;


	@Test (priority = 1)
	public void clearEmail() {
		
		menyBar.goToHomePage();
		mainPage.signInClick();
		loginPage.goToResetPassword();
		assertTrue(resetPass.assertPage());
		assertFalse(resetPass.resetButtonEnabled());

		resetPass.clearEmailField("user@localhost");

		String ocekivano = "Your e-mail is required.";
		String actual = resetPass.emailsIsRequired();

		assertEquals(actual, ocekivano);
	}

	@Test(priority = 4)
	public void pozitivanTest() {

		resetPass.enterEmail("user@localhost");

		String ocekivano = "Check your e-mails for details on how to reset your password.";
		String actual = resetPass.susccessMsg();

		assertEquals(actual, ocekivano);
	}

	@Test(dataProvider = "invalidEmail", priority = 3)
	public void invalidEmail(String email, String rezultat) {

		resetPass.enterEmail(email);

		assertFalse(resetPass.resetButtonEnabled());
		assertEquals(resetPass.emailIsInvalid(), rezultat);

	}

	@DataProvider(name = "invalidEmail")
	public Object[][] invalidEmail() {
		return new Object[][] { new Object[] { "abvgddjez", "Your e-mail is invalid." },
				new Object[] { "111111111", "Your e-mail is invalid." }, };
				
	}

	@Test(dataProvider = "emailISToShort", priority = 1)
	public void toShortEmail(String email, String rezultat) {

		resetPass.enterEmail(email);

		assertFalse(resetPass.resetButtonEnabled());
		assertEquals(resetPass.minimalLengthEmailError(), rezultat);

	}

	@DataProvider(name = "emailISToShort")
	public Object[][] emailISToShort() {
		return new Object[][] { new Object[] { "a", "Your e-mail is required to be at least 5 characters." },
				new Object[] { "aaaa", "Your e-mail is required to be at least 5 characters." },
				new Object[] { "a@a", "Your e-mail is required to be at least 5 characters." },
				new Object[] { "@", "Your e-mail is required to be at least 5 characters." },

		};
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

		mainPage = new MainPage(driver);
		loginPage = new LoginPage(driver);
		resetPass = new ResetPassword(driver);
		menyBar = new MenyBar(driver);
	}

	@AfterSuite
	public void afterSuite() {
		driver.close();
	}

}
