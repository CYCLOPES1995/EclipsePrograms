package testscript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Vtiger.GenericsUtils.FileUtility;
import com.Vtiger.GenericsUtils.WebDriverUtility;

public class TC_11 {

	public static void main(String[] args) throws Throwable {
		WebDriverUtility w = new WebDriverUtility();
		WebDriver driver = new ChromeDriver();
		w.waitUntilPageLoad(driver);
		driver.get("http://localhost:8888/");
		FileUtility f = new FileUtility();
		String username = f.getJsonKeyValue("username");
		String password = f.getJsonKeyValue("password");
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.xpath("(//img[contains(@src,'themes/softed/')])[8]")).click();
		WebElement prefix = driver.findElement(By.name("salutationtype"));
		w.selectOption("Mr.", prefix);
		driver.findElement(By.name("firstname")).sendKeys("GAURAV");
		driver.findElement(By.name("lastname")).sendKeys("singh");
		driver.findElement(By.name("company")).sendKeys("TESTYANTRA");
		driver.findElement(By.id("designation")).sendKeys("Manager");
		WebElement leadsource = driver.findElement(By.name("leadsource"));
		w.selectOption("Trade Show", leadsource);
		WebElement industry = driver.findElement(By.name("industry"));
		w.selectOption("Apparel", industry);
		driver.findElement(By.name("annualrevenue")).sendKeys("10000000");
		driver.findElement(By.id("noofemployees")).sendKeys("5000");
		driver.findElement(By.id("secondaryemail")).sendKeys("abcd@gmail.com");
		driver.findElement(By.id("phone")).sendKeys("1234567890");
		driver.findElement(By.id("mobile")).sendKeys("1234567890");
		driver.findElement(By.id("fax")).sendKeys("1234567890");
		driver.findElement(By.id("email")).sendKeys("qweerty@gmail.com");
		driver.findElement(By.xpath("(//input[contains(@class,'detailedViewTextBox')])[10]")).sendKeys("testyantra.com");
		WebElement leadstatus = driver.findElement(By.name("leadstatus"));
		w.selectOption("Attempted to Contact", leadstatus);
		WebElement rating = driver.findElement(By.name("rating"));
		w.selectOption("Acquired", rating);
		driver.findElement(By.xpath("(//input[contains(@type,'radio')])[1]")).click();
		driver.findElement(By.id("pobox")).sendKeys("12345");
		driver.findElement(By.id("code")).sendKeys("34566");
		driver.findElement(By.xpath("(//textarea[contains(@onblur,'this.className')])[1]")).sendKeys("ndia(Global Delivery & Engineering Center)");
		driver.findElement(By.id("city")).sendKeys("BANGALORE");
		driver.findElement(By.id("country")).sendKeys("INDIA");
		driver.findElement(By.id("state")).sendKeys("KARNATAKA");
		driver.findElement(By.name("description")).sendKeys("cbxcbncbjc,dsihdidchdjdkcdsocidsndcdscua");
		driver.findElement(By.name("button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[contains(@type,'button')])[29]")).click();
		driver.close();
	}

}
