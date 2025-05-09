package herokuappsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckboxTest {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		Thread.sleep(3000);
		
		WebElement checkBoxEle = driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[6]/a"));
		checkBoxEle.click();
		Thread.sleep(3000);	
		
		WebElement headerTitle = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3"));
		System.out.println(headerTitle);
		
		if (headerTitle.equals("Checkboxes")) {
			System.out.println(" The header title is correct - Test Case passed");
		}
		else {
			System.out.println(" The header title is incorrect - Test Case failed");
		}
		Thread.sleep(2000);
		
		WebElement footerTitle1 = driver.findElement(By.xpath("//*[@id=\"page-footer\"]/div/div/text()"));
		System.out.println(footerTitle1);
		
		if (footerTitle1.equals("Powered by")) {
			System.out.println(" The footer note 1 is correct - Test Case passed");
		}
		else {
			System.out.println(" The footer note 1 is incorrect - Test Case failed");
		}
		
		Thread.sleep(2000);
		
		WebElement footerTitle2 = driver.findElement(By.xpath("//*[@id=\"page-footer\"]/div/div/a"));
		System.out.println(footerTitle2);
		
		if (footerTitle2.equals("Elemental Selenium")) {
			System.out.println(" The footer note 2 is correct - Test Case passed");
		}
		else {
			System.out.println(" The footer note 2 is incorrect - Test Case failed");
		}
		
		
		
		
		driver.quit();

	}

}
