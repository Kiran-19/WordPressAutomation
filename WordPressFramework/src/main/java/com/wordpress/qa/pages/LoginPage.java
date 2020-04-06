package com.wordpress.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wordpress.qa.actiondriver.Action;
import com.wordpress.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(id="user_login")
	WebElement username;
	
	@FindBy(id="user_pass")
	WebElement password;
	
	@FindBy(id="wp-submit")
	WebElement loginbutton;
	
	@FindBy(xpath="//a[contains(text(),'Lost your password?')]")
	WebElement lostpassword;
	
	@FindBy(xpath="//a[contains(text(),'Powered by WordPress')]")
	WebElement wordpresslogo;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginpagetitle() {
		return driver.getTitle();
	}
	
	public boolean logo() throws Throwable {
	     //	return wordpresslogo
		return Action.isDisplayed(driver, wordpresslogo);
		//return wordpresslogo.isDisplayed();
	}
	
	public HomePage login(String un, String  pwd) throws Throwable {
		Action.type(username, un);
		Action.type(password, pwd);
		Action.click(driver,loginbutton );
		return new HomePage();
	}

}
