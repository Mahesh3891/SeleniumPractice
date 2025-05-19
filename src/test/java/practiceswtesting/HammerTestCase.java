package practiceswtesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HammerTestCase {
	
	@Test
	public void testHammerDetails() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://practicesoftwaretesting.com/");
		
		WebElement selectDD = driver.findElement(By.xpath("//*[@id='filters']/form[1]/div/select"));
		
		Select dd = new Select(selectDD);
		
		dd.selectByValue("name,asc");
		
		driver.findElement(By.xpath("//*[@id='filters']/fieldset[1]/div[1]/ul/fieldset/div[1]/label")).click();
		String priceValue = driver.findElement(By.xpath("//span[contains(text(),'$12.58')]")).getText();
		System.out.println(priceValue);
		
		driver.findElement(By.xpath("/html/body/app-root/div/app-overview/div[3]/div[2]/div[1]/a[7]/div[2]")).click();
		
		String title = driver.findElement(By.xpath("/html/body/app-root/div/app-detail/div[1]/div[2]/h1")).getText();
		Assert.assertEquals(title, "Hammer");
		System.out.println(title);
		
		String tag1 = driver.findElement(By.xpath("/html/body/app-root/div/app-detail/div[1]/div[2]/p[1]/span[1]")).getText();
		Assert.assertEquals(tag1, "Hammer");
		System.out.println(tag1);
		
		String tag2 = driver.findElement(By.xpath("/html/body/app-root/div/app-detail/div[1]/div[2]/p[1]/span[2]")).getText();
		Assert.assertEquals(tag2, "ForgeFlex Tools");
		System.out.println(tag2);
		
		String priceTag = driver.findElement(By.xpath("/html/body/app-root/div/app-detail/div[1]/div[2]/span")).getText();
		System.out.println("Product Page: " + priceTag);
		System.out.println("Main Page: " + priceValue);
		Assert.assertEquals(priceTag,priceValue);
		
		driver.findElement(By.id("btn-add-to-cart")).click();
		
		//String popupMessage = driver.findElement(By.id("toast-container")).getText();		
		//System.out.println("Message is: " + popupMessage);	
		
		WebElement toastMessage = driver.findElement(By.xpath("//div[contains(@class,'toast-message') or contains(@class,'toast')]")); 		// Capture and print the text of the toast message
        String toastText = toastMessage.getText();
        System.out.println("Toast Message: " + toastText);
		
		driver.quit();	
		
	}

}
