package herokuappsite;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaScriptAlerts {

	@Test
	public void testJSAlert() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.navigate().to("https://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//*[@id='content']/ul/li[29]/a")).click();

		String title = driver.findElement(By.xpath("//*[@id='content']/div/h3")).getText();
		Assert.assertEquals(title, "JavaScript Alerts", "Alert Header Page Title Validation: Pass");
		
		driver.findElement(By.xpath("//*[@id='content']/div/ul/li[1]/button")).click();
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		String resultMessage = driver.findElement(By.xpath("//*[@id='result']")).getText();
		Assert.assertEquals(resultMessage, "You successfully clicked an alert", "Result Message validation: Pass");
		
		driver.quit();
	}

	@Test
	public void testJSConfirm () {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.navigate().to("https://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//*[@id='content']/ul/li[29]/a")).click();
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button")).click();
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		
		String resultMessage = driver.findElement(By.id("result")).getText();
		Assert.assertEquals(resultMessage, "You clicked: Cancel");
		System.out.println("Result Message displayed: " + resultMessage);
		
		driver.quit();
			
	}
	
	@Test
	public void testJSPrompt() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.navigate().to("https://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//*[@id='content']/ul/li[29]/a")).click();
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button")).click();
		Alert alert = driver.switchTo().alert();
		
		alert.sendKeys("Test Message");
		alert.accept();
		
		String resultMessage = driver.findElement(By.id("result")).getText();
		Assert.assertEquals(resultMessage, "You entered: Test Message");
		System.out.println("Result Message displayed: " + resultMessage);
		
		driver.quit();
	}
	
}
