package com.Vtiger.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vtiger.GenericsUtils.WebDriverUtility;

public class CreateNewLead extends WebDriverUtility {
	WebDriver driver;
	public CreateNewLead(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "salutationtype")
	private WebElement salutation;
	@FindBy(name = "firstname")
	private WebElement firstname;
	@FindBy(name = "lastname")
	private WebElement lastname;
	@FindBy(name = "company")
	private WebElement company;
	@FindBy(id = "designation")
	private WebElement title;
	@FindBy(name = "leadsource")
	private WebElement leadsource;
	@FindBy(name = "industry")
	private WebElement industry;
	@FindBy(name = "annualrevenue")
	private WebElement annualrevenue;
	@FindBy(id = "noofemployees")
	private WebElement noofemployees;
	@FindBy(id = "secondaryemail")
	private WebElement secondaryemail;
	@FindBy(id = "phone")
	private WebElement phone;
	@FindBy(id = "mobile")
	private WebElement mobile;
	@FindBy(id = "fax")
	private WebElement fax;
	@FindBy(id = "email")
	private WebElement email;
	@FindBy(name = "website")
	private WebElement website;
	@FindBy(name = "leadstatus")
	private WebElement leadstatus;
	@FindBy(name = "rating")
	private WebElement rating;
	@FindBy(xpath = "//input[@value='U']")
	private WebElement userradiobutton;
	@FindBy(xpath = "//input[@value='T']")
	private WebElement groupradiobutton;
	@FindBy(className = "small")
	private WebElement grpradiobtndrpdown;
	@FindBy(name = "lane")
	private WebElement Street;
	@FindBy(id = "pobox")
	private WebElement pobox;
	@FindBy(id = "code")
	private WebElement postalcode;
	@FindBy(id = "city")
	private WebElement city;
	@FindBy(id = "country")
	private WebElement country;
	@FindBy(id = "state")
	private WebElement state;
	@FindBy(name = "description")
	private WebElement description;
	@FindBy(name = "button")
	private WebElement savebutton;
	@FindBy(className = "crmbutton small cancel")
	private WebElement cancelbutton;



	public WebElement getSalutation() {
		return salutation;
	}
	public WebElement getFirstname() {
		return firstname;
	}
	public WebElement getLastname() {
		return lastname;
	}
	public WebElement getCompany() {
		return company;
	}
	public WebElement getTitle() {
		return title;
	}
	public WebElement getLeadsource() {
		return leadsource;
	}
	public WebElement getIndustry() {
		return industry;
	}
	public WebElement getAnnualrevenue() {
		return annualrevenue;
	}
	public WebElement getNoofemployees() {
		return noofemployees;
	}
	public WebElement getSecondaryemail() {
		return secondaryemail;
	}
	public WebElement getPhone() {
		return phone;
	}
	public WebElement getMobile() {
		return mobile;
	}
	public WebElement getFax() {
		return fax;
	}
	public WebElement getEmail() {
		return email;
	}
	public WebElement getWebsite() {
		return website;
	}
	public WebElement getLeadstatus() {
		return leadstatus;
	}
	public WebElement getRating() {
		return rating;
	}
	public WebElement getUserradiobutton() {
		return userradiobutton;
	}
	public WebElement getGroupradiobutton() {
		return groupradiobutton;
	}
	public WebElement getStreet() {
		return Street;
	}
	public WebElement getPobox() {
		return pobox;
	}
	public WebElement getPostalcode() {
		return postalcode;
	}
	public WebElement getCity() {
		return city;
	}
	public WebElement getCountry() {
		return country;
	}
	public WebElement getState() {
		return state;
	}
	public WebElement getDescription() {
		return description;
	}
	public WebElement getSavebutton() {
		return savebutton;
	}
	public WebElement getCancelbutton() {
		return cancelbutton;
	}
	public WebElement getGrpradiobtndrpdown() {
		return grpradiobtndrpdown;
	}
	
	public void LeaddropDown(String value) {
		getLeadsource().click();
		selectOption(value,leadsource);	
	}
	public void IndustrydropDown(String value) {
		getIndustry().click();
		selectOption(value,industry);
	}
	public void LeadStatusdropDown(String value) {
		getLeadstatus().click();
		selectOption(value,leadstatus);
		}
	
	public void ratingdropDown(String value) {
		getRating().click();
		selectOption(value,rating);
	}


	public void groupdropDown(String value) {
		getGrpradiobtndrpdown().click();
		selectOption(value,grpradiobtndrpdown);
	}
	
	
	public void salutationDropDown(String value) {
		getSalutation().click();
		selectOption(value, salutation);
	}
	public void readData(String firstname,String lastname,String company,String title,String annualrevnue ) {
		salutationDropDown("Mr.");
		getFirstname().sendKeys(firstname);
		getLastname().sendKeys(lastname);
		getCompany().sendKeys(company);
		getTitle().sendKeys(title);
		getAnnualrevenue().sendKeys(annualrevnue);
	}
	public void readData1(String nmbrofemployees,String secondryemail,String phone,String mobile,String fax ) {
		getNoofemployees().sendKeys(nmbrofemployees);
		getSecondaryemail().sendKeys(secondryemail);
		getPhone().sendKeys(phone);
		getMobile().sendKeys(mobile);
		getFax().sendKeys(fax);
		
	}
	public void readData2(String email,String website,String street,String pobox,String postalcode ) {
		getEmail().sendKeys(email);
		getWebsite().sendKeys(website);
		getStreet().sendKeys(street);
		getPobox().sendKeys(pobox);
		getPostalcode().sendKeys(postalcode);
		
	}
	public void readData3(String city,String country,String state,String description) {
		getCity().sendKeys(city);
		getCountry().sendKeys(country);
		getState().sendKeys(state);
		getDescription().sendKeys(description);
        LeaddropDown("Cold Call");
		IndustrydropDown("Apparel");
		LeadStatusdropDown("Attempted to Contact");
		ratingdropDown("Acquired");
		getUserradiobutton().click();
		getSavebutton().click();
	}
	
}
