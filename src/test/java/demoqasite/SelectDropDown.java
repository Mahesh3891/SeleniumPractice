package demoqasite;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectDropDown {

	@Test
	public void selectDD() {
		
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	
	driver.get("https://demoqa.com/select-menu");
	
	WebElement selectDD = driver.findElement(By.xpath("//*[@id='withOptGroup']"));
	System.out.println(selectDD.getText());
	selectDD.click();	
	System.out.println(selectDD.getText());

	WebElement optionRoot = driver.findElement(By.xpath("//*[@id='withOptGroup']/div/div[1]/div[1]"));	
	System.out.println(optionRoot.getText());
	optionRoot.click();
	
	driver.quit();
	}
	
	@Test
	public void selectdd01() {
		
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
		
	driver.get("https://demoqa.com/select-menu");
	
	WebElement oldStyleSelect = driver.findElement(By.xpath("//*[@id='oldSelectMenu']"));
	
	WebElement colourName = driver.findElement(By.xpath("//*[@id='oldSelectMenu']/option[6]"));		// Finding the title of the drop down page = "Dropdown List"
	String colourBlack = colourName.getText();
	
	Select dd = new Select(oldStyleSelect);
	
	dd.selectByValue("5");
	
	Assert.assertEquals(colourBlack, "Black");						// Actual, Expected
	System.out.println("Drop Down item selected by Value 5 is " + colourBlack);
	
	dd.selectByIndex(6);
	System.out.println(colourName.getText());
	
	
	}
	
	
}
