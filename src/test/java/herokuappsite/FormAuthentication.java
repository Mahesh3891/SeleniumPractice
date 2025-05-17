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
		driver.get("https://the-internet.herokuapp.com/");
		
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
		
		//Alert alert = driver.switchTo().alert();
		//alert.dismiss();
		
		//String popText = driver.findElement(By.xpath("//*[@id='flash']")).getText();				
		String popText = driver.findElement(By.id("flash")).getText();					// ********** Facing issue at this point **********
		System.out.println(popText);
		Assert.assertEquals(popText, "You logged into a secure area!");					//(Actual,Expected)
		
		driver.quit();
	}
	
	
	
}
