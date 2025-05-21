package herokuappsite;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormAuthentication {
	@Test
	public void testAuth() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.navigate().to("https://the-internet.herokuapp.com/");
		
		driver.findElement(By.xpath("//*[@id='content']/ul/li[21]/a")).click();
		
		String header = driver.findElement(By.xpath("//*[@id='content']/div/h2")).getText();
		Assert.assertEquals(header, "Login Page");
		System.out.println(header);
		
		String loginID = driver.findElement(By.xpath("//*[@id='content']/div/h4/em[1]")).getText();
		String passWord = driver.findElement(By.xpath("//*[@id='content']/div/h4/em[2]")).getText();
		System.out.println("Login ID: " + loginID);
		System.out.println("Password: " + passWord);
		
		driver.findElement(By.id("username")).sendKeys(loginID);
		driver.findElement(By.id("password")).sendKeys(passWord);
				
		driver.findElement(By.xpath("//*[@id='login']/button/i")).click();
		System.out.println("Login Successful");
		
		String message = driver.findElement(By.xpath("//*[@id='flash']")).getText();
		Assert.assertEquals(message.contains("You logged into a secure area!"), true);
		System.out.println(message);
		
		driver.quit();
	}
	
	
	
}
