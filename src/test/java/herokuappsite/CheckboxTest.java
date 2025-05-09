package herokuappsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckboxTest {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");													// S1: Open the website
		Thread.sleep(1000);
		
		WebElement checkBoxElement = driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[6]/a"));		// Find the element based on Xpath of the required field "Checkboxes" from S1  
		checkBoxElement.click();																			// S2: Click on "Checkboxes" link on main page
		Thread.sleep(1000);	
		
		WebElement headerElement = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3"));				// Find the element based on Xpath of the required field Header Text after S2
		String headerText = headerElement.getText();														// S3: Get Header Text from xpath
		System.out.println(headerText);
		
		if (headerText.equals("Checkboxes")) {																// S4: Verify the Header Text
			System.out.println(" The header title is correct - Test Case passed");
		}
		else {
			System.out.println(" The header title is incorrect - Test Case failed");
		}
		Thread.sleep(1000);
		
		WebElement footerElement = driver.findElement(By.xpath("//*[@id=\"page-footer\"]/div/div"));		// Repeat S3 for footer text	
		String footerText1 = footerElement.getText();
		System.out.println(footerText1);
		
		if (footerText1.equals("Powered by Elemental Selenium")) {											// Repeat S4 for footer text
			System.out.println(" The footer note 1 is correct - Test Case passed");
		}
		else {
			System.out.println(" The footer note 1 is incorrect - Test Case failed");
		}
		Thread.sleep(1000);
		
		WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
		
		if(checkbox1.isSelected()) {																		// Check checkbox1 if it is already checked
			System.out.println("Checkbox1 is already tick marked - Ignore");
		}
		else {
			checkbox1.click();																				// Click the checkbox to mark tick if it is uncheck
			System.out.println("Checkbox1 is tick marked now - Test case passed");
		}
		Thread.sleep(1000);
		
		WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
		
		if(checkbox2.isSelected()) {																		// Check checkbox1 if it is already checked 
			checkbox2.click();																				// Click to checkbox tp mark tick if it is already checked
			System.out.println("Checkbox2 is tick marked now- Test case passed");
		}
		else {
			System.out.println("Checkbox2 is already tick marked - Ignore");
		}
		Thread.sleep(3000);
				
		driver.quit();

	}

}
