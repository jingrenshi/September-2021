package homeWork1;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddAccount {

	WebDriver driver;
	
	@Before
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.techfios.com/billing/?ng=admin/");
	}
	
	@Test
	public void AddNewAccount() {
		//step 1 login
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("demo@techfios.com ");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("abc123");
		driver.findElement(By.xpath("//button[@name='login']")).click();
		
		//step 2 find new account form
		driver.findElement(By.xpath("//span[text()='Bank & Cash']")).click();//click"Bank & Cash" 
		driver.findElement(By.xpath("//a[text()='New Account']")).click();//click"New Account"
		
		//step 3 fill out the blanks
		driver.findElement(By.xpath("//input[@id='account']")).sendKeys("Mocha2022");
		driver.findElement(By.xpath("//input[@id='description']")).sendKeys("Checking Account");
		driver.findElement(By.xpath("//input[@id='balance']")).sendKeys("2,000.00");
		driver.findElement(By.xpath("//input[@id='account_number']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@id='contact_person']")).sendKeys("Mr.XYZ");
		driver.findElement(By.xpath("//input[@id='contact_phone']")).sendKeys("123-456-7890");
		
		//step 4 submit
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
	}

	//@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}		
	
}
