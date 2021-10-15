package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.Vtiger.GenericsUtils.WebDriverUtility;

public class Tooltip2 {
	public static void main(String[] args) throws Throwable {
		WebDriverUtility wlib = new WebDriverUtility();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/tool-tips");
		WebElement button = driver.findElement(By.id("toolTipButton"));
		Actions a = new Actions(driver);
		a.moveToElement(button).perform();
		Thread.sleep(5000);
		WebElement tooltip = driver.findElement(By.xpath("//div[@class='tooltip-inner']"));
		String tooltext = tooltip.getText();
		System.out.println(tooltext);
		driver.findElement(By.id("toolTipTextField")).sendKeys(tooltext);
		Thread.sleep(5000);
		driver.close();
	}

}
