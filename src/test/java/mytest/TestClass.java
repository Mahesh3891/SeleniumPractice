package mytest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClass {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://practicesoftwaretesting.com/");
		Thread.sleep(1000);
		
		WebElement combinationPlierEle = driver.findElement(By.xpath("/html/body/app-root/div/app-overview/div[3]/div[2]/div[1]/a[1]/div[2]/h5"));
		combinationPlierEle.click();
		Thread.sleep(1000);
		
		WebElement productHeading = driver.findElement(By.xpath("/html/body/app-root/div/app-detail/div[1]/div[2]/h1"));
		
		String headingText = productHeading.getText();
			System.out.println(headingText);
			
		if (headingText.equals("Combination Pliers")) {
			System.out.println("The Heading title is correct, Test Case Passed");
		}
		else {
			System.out.println("The Heading title is incorrect, Test Case Failed");
		}
		
		driver.quit();
	}
}
