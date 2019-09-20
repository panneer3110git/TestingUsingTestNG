package parameterization;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ParamaterPractice {
	WebDriver driver;
	
	@Test
	@Parameters({"url","userid","password"})
	public void testleaf(String url,String userid,String password) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(userid);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("decorativeSubmit")).click();
	}

}
