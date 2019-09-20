package dataprovider;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
	WebDriver driver;

	@DataProvider
	public Object[][] setup() {
		Object[][] data = ExcelUtility.readExcel();
		return data;
	}

	@BeforeMethod
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test(dataProvider = "setup")
	public void testleaf(String url, String userid, String password) {
		driver.get(url);
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(userid);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("decorativeSubmit")).click();
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}
