package com.wordpress.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wordpress.qa.actiondriver.Action;
import com.wordpress.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath = "//*[@id='wp-admin-bar-my-account']/a/span[contains(text(),'opensourcecms')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//*[@id='menu-posts']//a[contains(text(),'Add New')]")
	WebElement addNewPostLink;
	
	@FindBy(xpath="//*[@id='menu-posts']/a/div[contains(text(),'Posts')]")
	WebElement PostLink;
	
	@FindBy(xpath="//div[contains(text(),'Users')]")
	WebElement usersLink;
	
	@FindBy(xpath="//*[@id='menu-users']//a[contains(text(),'Add New')]")
	WebElement addNewUserLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCorrectUsername() {
		return userNameLabel.isDisplayed();
	}
	
	public PostPage clickonPostLink() throws Throwable {
		Action.click(driver, PostLink);
		return new PostPage();
	}
	
	public UserPage clickOnUserLink() throws Throwable {
		Action.click(driver, usersLink);
		return new UserPage();
	}
	
	public UserPage clickOnAddNewUser() throws Throwable {
     Action.click(driver, usersLink);
     Action.click(driver, addNewUserLink);
     return new UserPage();
	}
	
	public PostPage clickOnAddNewLink() throws Throwable {
	     Action.click(driver, PostLink);
	     Action.click(driver, addNewPostLink);
	     return new PostPage();
		}
	public boolean postLinkIsdisplayed() {
		PostLink.isDisplayed();
		return true;
		
	}

	public boolean userLinkIsdisplayed() {
		usersLink.isDisplayed();
		return true;
	}	
	
}
