package practiceswtesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CurrencySymbol {
	
	@Test
	public void testCurrencySign() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.navigate().to("https://practicesoftwaretesting.com/");
			
		String priceText = driver.findElement(By.xpath("/html/body/app-root/div/app-overview/div[3]/div[2]/div[1]/a[1]/div[3]/span/span")).getText();
		System.out.println("Text from the element is: " + priceText);
		Assert.assertEquals(priceText.contains("$"), true);
		
		driver.quit();
	}

}
