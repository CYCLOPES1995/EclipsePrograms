package com.Vtiger.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vtiger.GenericsUtils.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Organizations")
	private WebElement OrganizationLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminstratorImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement SignOutLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement ContactLink;
	
	@FindBy(linkText = "Leads")
	private WebElement LeadsLink;
	
	

	public WebElement getLeadsLink() {
		return LeadsLink;
	}

	public WebElement getContactLink() {
		return ContactLink;
	}

	public WebElement getOrganizationLink() {
		return OrganizationLink;
	}
	
	public WebElement getAdminstratorImg() {
		return adminstratorImg;
	}
	public WebElement getSignOutLink() {
		return SignOutLink;
	}

	public void signout() {
		mouseHover(driver, adminstratorImg);
		waitForElementVisibility(driver, adminstratorImg);
		SignOutLink.click();
		
	}
		
	
	
	}
		
	

