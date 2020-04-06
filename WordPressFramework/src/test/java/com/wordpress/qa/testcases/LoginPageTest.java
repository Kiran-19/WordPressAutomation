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
import com.wordpress.qa.utils.ExtentClass;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() {
		super();
	}
	
	@BeforeTest(groups= {"Smoke","Regression","SystemTest"})
	public void startTest() {
		ExtentClass.setExtent();
	}
	
	@BeforeMethod(groups= {"Smoke","Regression","SystemTest"})
	public void setup() {
		initialization();
		loginPage=new LoginPage();
	}
	
	@Test(groups= {"Smoke","SystemTest"})
	public void loginPageTitleTest() {
		ExtentClass.extentTest=ExtentClass.extent.startTest("VerifyloginPageTitleTest");
		log.debug("loginPageTitleTest start");
		log.info("Login");
		String title=loginPage.validateLoginpagetitle();
		Assert.assertEquals(title, "Log In ‹ opensourcecms — WordPress");
		log.debug("loginPageTitleTest ends");
	}
	
	@Test(groups= {"Smoke","SystemTest"})
	public void loginWordPresslogoTest() throws Throwable {
		ExtentClass.extentTest=ExtentClass.extent.startTest("VerifyloginWordPressLogoTest");
		log.debug("loginWordPresslogoTest start");
		log.info("Logo");
		boolean flag=loginPage.logo();
		Assert.assertTrue(flag);
		log.debug("loginWordPresslogoTest ends");
	}
	
	@Test(groups= {"Smoke","Regression","SystemTest"})
	public void loginTest() throws Throwable {
		ExtentClass.extentTest=ExtentClass.extent.startTest("VerifyloginTest");
		log.debug("loginTest start");
		log.info("Login");
		  homePage=loginPage.login(prop.getProperty("username"),(prop.getProperty("password")));
		  Assert.assertTrue(homePage.postLinkIsdisplayed());
		log.debug("loginTest ends");
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
