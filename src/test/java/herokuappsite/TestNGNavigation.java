package herokuappsite;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestNGNavigation {
	@Test	
	public void navigation() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://the-internet.herokuapp.com/");
		WebElement dropdown = driver.findElement(By.xpath("//*[@id='content']/ul/li[11]/a"));
		dropdown.click();
		
		driver.navigate().back();
		System.out.println("Navigation key: Back is working");
		
		driver.navigate().forward();
		System.out.println("Navigation key: Forward is working");
		
		driver.navigate().refresh();
		System.out.println("Navigation key: Refresh is working");
		
		driver.quit();
	}
	
	
}
