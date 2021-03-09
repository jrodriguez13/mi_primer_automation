package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Tests
{
	private WebDriver driver;
@	BeforeMethod
	public void setup() {
	System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.navigate().to("http://demo.guru99.com/test/newtours/");
	try {
		Thread.sleep(5000);
		
		} catch (InterruptedException e) {
		// TODO: handle exception
		e.printStackTrace();
		}
	}
@	Test
	public void pruebaUno() {
	driver.findElement(By.name("userName")).sendKeys("user");
	driver.findElement(By.name("password")).sendKeys("user");
	driver.findElement(By.name("submit")).click();
	try {
		Thread.sleep(5000);
		} catch (InterruptedException e) {
		// TODO: handle exception
		e.printStackTrace();
		}
		Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/h3")).getText().contains("Login Successfully"));
	}
@	AfterMethod
	public void tearDown() {
	driver.close();
	}
}
