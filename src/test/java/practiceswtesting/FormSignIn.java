package practiceswtesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class FormSignIn {
	
	@Test	
	public void testRegistrationUser() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://practicesoftwaretesting.com/");
		
		driver.findElement(By.xpath("//*[@id='navbarSupportedContent']/ul/li[4]/a")).click();
		driver.findElement(By.linkText("Register your account")).click();
		String header = driver.findElement(By.xpath("/html/body/app-root/div/app-register/div/div/div/h3")).getText();
		System.out.println(header);
		
		Assert.assertEquals(header, "Customer registration");
		driver.findElement(By.id("first_name")).sendKeys(new Faker().name().firstName());
		driver.findElement(By.id("last_name")).sendKeys(new Faker().name().lastName());
		driver.findElement(By.id("dob")).sendKeys("001999-12-12");
		driver.findElement(By.id("street")).sendKeys(new Faker().address().streetAddress());
		driver.findElement(By.id("postal_code")).sendKeys(new Faker().address().zipCode());
		driver.findElement(By.id("city")).sendKeys(new Faker().address().city());
		driver.findElement(By.id("state")).sendKeys(new Faker().address().state());
		driver.findElement(By.id("country")).sendKeys(new Faker().address().country());
		driver.findElement(By.id("phone")).sendKeys(new Faker().numerify("##########"));
		String emailID = new Faker().internet().emailAddress();
		driver.findElement(By.id("email")).sendKeys(emailID);
		String passWord = new Faker().internet().password(8, 16, true, true, true);
		driver.findElement(By.id("password")).sendKeys(passWord);
		
		driver.findElement(By.xpath("/html/body/app-root/div/app-register/div/div/div/form/div/button")).click();
		System.out.println("User ID: " + emailID);
		System.out.println("Password: " + passWord);
		
		// Login using the credentials generated in the above step
		driver.get("https://practicesoftwaretesting.com/auth/login");
		driver.findElement(By.id("email")).sendKeys(emailID);
		driver.findElement(By.id("password")).sendKeys(passWord);
		
		driver.findElement(By.xpath("/html/body/app-root/div/app-login/div/div/div/form/div[3]/input")).click();
		
		//Validate the Account Home Page after successful login
		String titleName = driver.findElement(By.xpath("/html/body/app-root/div/app-overview/h1")).getText();
		Assert.assertEquals(titleName, "My account");
		System.out.println("Login Succesful");
		
		// Logout from the Account Home Page		
		driver.findElement(By.id("menu")).click();
		driver.findElement(By.xpath("//*[@id='navbarSupportedContent']/ul/li[4]/ul/li[7]/a")).click();
		System.out.println("Logout Succesful");
	}
		
}
