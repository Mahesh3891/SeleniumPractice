package herokuappsite;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropDownClass {

	@Test	
	public void dropdown () {
	
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));							// Adding delays
		driver.manage().window().maximize();														// maximize the web browser
		
		driver.navigate().to("https://the-internet.herokuapp.com/");								//driver.get("https://the-internet.herokuapp.com/");
		
		WebElement dropDown = driver.findElement(By.xpath("//*[@id='content']/ul/li[11]/a"));		//Finding element "Drop Down" from Home Page
		dropDown.click();																			// Click to go to the drop down page
		
		WebElement dropDownTitle = driver.findElement(By.xpath("//*[@id='content']/div/h3"));		// Finding the title of the drop down page = "Dropdown List"
		String title = dropDownTitle.getText();														// Store the info in the variable "title"
		
		Assert.assertEquals(title, "Dropdown List");												// Compare/Validate the stored value with that of the actual details.
			System.out.println("Assert class validation succesful");
	
		driver.quit();
	}
	
	@Test
	public void selectDropDown() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		
		driver.navigate().to("https://the-internet.herokuapp.com/");								
		
		WebElement dropDownEle = driver.findElement(By.xpath("//*[@id='content']/ul/li[11]/a"));		
		dropDownEle.click();
		
		WebElement selectDD = driver.findElement(By.xpath("//*[@id='dropdown']"));					// finding select drop down element
		
		Select dd = new Select(selectDD);															// Using "Select class" provided by selenium.
		
		dd.selectByVisibleText("Option 2");															// Methods of Select class
		dd.selectByValue("1");
		dd.selectByIndex(2);
		
		driver.quit();
		
	}
	
	
}
