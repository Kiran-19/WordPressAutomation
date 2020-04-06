
package com.wordpress.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import com.wordpress.qa.base.TestBase;
import com.wordpress.qa.pages.HomePage;
import com.wordpress.qa.pages.LoginPage;
import com.wordpress.qa.pages.PostPage;
import com.wordpress.qa.pages.UserPage;
import com.wordpress.qa.utils.ExtentClass;
import com.wordpress.qa.utils.TestUtil;

public class HomePageTest extends TestBase {

    LoginPage loginPage;
	HomePage homePage;
	PostPage newpostpage;
	UserPage newuserpage;

	public HomePageTest() {
		super();
	}

	@BeforeTest(groups= {"Smoke","Regression","SystemTest"})
	public void startTest() {
		ExtentClass.setExtent();
	}

	@BeforeMethod(groups= {"Smoke","Regression","SystemTest"})
	public void setup() throws Throwable {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(groups = { "Regression","SystemTest" })
	public void homePageTitleTest() {
		ExtentClass.extentTest = ExtentClass.extent.startTest("VerifyhomePageTitleTest");
		String title = homePage.validateHomePageTitle();
		Assert.assertEquals(title, "Dashboard ‹ opensourcecms — WordPress");
	}

	@Test(groups = { "Regression","SystemTest" })
	public void verifyUserNameTest() {
		ExtentClass.extentTest = ExtentClass.extent.startTest("verifyUserNameTest");
		boolean title = homePage.validateCorrectUsername();
		Assert.assertTrue(title);
	}

	@Test(groups = { "Smoke","SystemTest" })
	public void verifyAddNewPostLinkTest() throws Throwable {
		ExtentClass.extentTest = ExtentClass.extent.startTest("verifyAddNewPostLinkTest");
		newpostpage = homePage.clickonPostLink();
		newpostpage = homePage.clickOnAddNewLink();
		Assert.assertTrue(true);
	}
	
	@Test(groups = { "Smoke","SystemTest" })
	public void verifyAddNewUserLinkTest() throws Throwable {
		ExtentClass.extentTest = ExtentClass.extent.startTest("verifyAddNewUserLinkTest");
		newuserpage = homePage.clickOnUserLink();
		newuserpage = homePage.clickOnAddNewUser();
		Assert.assertTrue(true);
	}

	@AfterMethod(groups= {"Smoke","Regression","SystemTest"})
	public void tearDown(ITestResult result) throws IOException {
		ExtentClass.setResult(driver, result);
		driver.quit();
	}

	@AfterTest(groups= {"Smoke","Regression","SystemTest"})
	public void endTest() {
		ExtentClass.endExtent();
		ExtentClass.closeExtent();
	}
}
