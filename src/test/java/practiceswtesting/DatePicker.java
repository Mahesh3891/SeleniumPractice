package practiceswtesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class DatePicker {

	@Test
	public void testDatepicker() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://practicesoftwaretesting.com/");
		
		driver.findElement(By.xpath("//*[@id='navbarSupportedContent']/ul/li[4]/a")).click();
		driver.findElement(By.linkText("Register your account")).click();
		String header = driver.findElement(By.xpath("/html/body/app-root/div/app-register/div/div/div/h3")).getText();
		System.out.println(header);
		
		
		driver.findElement(By.id("dob")).sendKeys("001999-12-12");
		driver.findElement(By.id("street")).sendKeys(new Faker().address().streetAddress());
		
		//driver.quit();
	}
	
}
