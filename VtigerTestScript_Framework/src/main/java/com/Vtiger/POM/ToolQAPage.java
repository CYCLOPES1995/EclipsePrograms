package com.Vtiger.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vtiger.GenericsUtils.WebDriverUtility;

public class ToolQAPage extends WebDriverUtility {
	WebDriver driver;
	public ToolQAPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
    @FindBy(id = "toolTipButton")
	private WebElement button;
    
    @FindBy(id = "toolTipTextField")
    private WebElement textbox;
    
    
	public WebElement getTextbox() {
		return textbox;
	}

	public WebElement getButton() {
		return button;
	}
	
	public void mousehoverbutton() throws Throwable {
		mouseHover(driver, button);
	    waitUntilPageLoad(driver);
		WebElement tooltip = driver.findElement(By.xpath("//div[@class='tooltip-inner']"));
		
		String tooltiptext = tooltip.getText();
		System.out.println(tooltiptext);
		getTextbox().sendKeys(tooltiptext);
		
	}
}