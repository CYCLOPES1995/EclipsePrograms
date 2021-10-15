package com.Vtiger.GenericsUtils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
		/**
		 * 
		 * @param driver
		 */
		public void waitUntilPageLoad(WebDriver driver) {
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		}
		/**
		 * 
		 * @param driver
		 * @param element
		 */
		public void waitForElementVisibility(WebDriver driver,WebElement element) {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		/**
		 * 
		 * @param element
		 * @throws Throwable
		 */
		public void waitAndClick(WebElement element) throws Throwable {
			int count = 0;
			while(count<40) {
				try {
					element.click();
					break;
				}
				catch(Throwable e) {
					Thread.sleep(1000);
					count++;
				}
			}
		}
		/**
		 * 
		 * @param element
		 * @param option
		 */
		public void selectOption(WebElement element,String option ) {
			Select select = new Select(element);
			select.selectByVisibleText(option);
			
		}
		/**
		 * 
		 * @param element
		 * @param index
		 */
		public void selectOption(WebElement element,int index) {
			Select  select = new Select(element);
			select.selectByIndex(index);
		}
		public void selectOption(String value,WebElement element) {
			Select  select = new Select(element);
			select.selectByValue(value);
			
		}
		/**
		 * 
		 * @param driver
		 * @param element
		 */
		public void mouseHover(WebDriver driver,WebElement element) {
			Actions act = new Actions(driver);
			act.moveToElement(element).perform();
		}
		/**
		 * 
		 * @param driver
		 * @param element
		 */
		public void rightClick(WebDriver driver,WebElement element) {
			Actions act = new Actions(driver);
			act.contextClick(element).perform();
		}
		/**
		 * 
		 * @param driver
		 * @param partialWinTitle
		 */
		public void SwitchToWimdow(WebDriver driver,String partialWinTitle) {
			Set<String> window = driver.getWindowHandles();
			Iterator<String> itr = window.iterator();
			while(itr.hasNext()) {
				String winId = itr.next();
				String title = driver.switchTo().window(winId).getTitle();
				if(title.contains(partialWinTitle)) {
					break;
				}
			}
		}
		/**
		 * 
		 * @param driver
		 */
		public void acceptAlert(WebDriver driver) {
			driver.switchTo().alert().accept();
		}
		/**
		 * 
		 * @param driver
		 */
		public void cancelAlert(WebDriver driver) {
			driver.switchTo().alert().dismiss();
			
		}
		/**
		 * 
		 * @param driver
		 * @param element
		 */
	public void scrolltoWebElement(WebDriver driver,WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		int y = element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")",element);
	}
	/**
	 * 
	 * @param driver
	 * @param Index
	 */
	public void switchFrame(WebDriver driver,int Index) {
		driver.switchTo().frame(Index);
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void switchFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);

	}
	/**
	 * 
	 * @param driver
	 * @param idOrName
	 */
	public void switchFrame(WebDriver driver,String idOrName) {
		driver.switchTo().frame(idOrName);
	}
	/**
	 * 
	 * @param driver
	 * @param ScreenshotName
	 * @return
	 */
	public String takeScreenshot(WebDriver driver,String ScreenshotName) {
		String screenshotPath="./screenshot/"+ScreenshotName+JavaUtility.getCurrentDate()+".PNG";
		return screenshotPath;
		}
	/**
	 * 
	 * @throws AWTException
	 */
	public void pressEntryKey() throws AWTException {
		Robot rc = new Robot();
		rc.keyPress(KeyEvent.VK_ENTER);
		rc.keyRelease(KeyEvent.VK_ENTER);
	}


}
