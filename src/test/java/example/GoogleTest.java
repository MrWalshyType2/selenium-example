package example;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTest {
	
	ChromeDriver driver;

	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\morga\\OneDrive\\Documents\\QA\\selenium-example\\src\\test\\resources\\drivers\\chromedriver84.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void test1() {
		driver.get("https://www.google.com");
		System.out.println("SEARCHING: " + driver.getCurrentUrl());
		
		WebElement searchBar = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input"));
		WebElement searchBtn = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[3]/center/input[1]"));
		
		searchBar.sendKeys("kittens");
		searchBtn.click();
		
		String expected = "kittens - Google Search";
		
		assertEquals(expected, driver.getTitle());
		System.out.println("TESTING: " + driver.getCurrentUrl());
		System.out.println(expected + " = " + driver.getTitle());
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}
