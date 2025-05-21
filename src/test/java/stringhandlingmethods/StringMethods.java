package stringhandlingmethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import org.testng.annotations.Test;

public class StringMethods {
	
	@Test
	public void testCharAt() {							//get a specific character from a string at a given index
		
		String str = "Hello";
		char result = str.charAt(4);
		System.out.println(result);
	}
	
	@Test
	public void testCharAt1() {							//loop to print all characters in the string one by one.
		
		String str = "Hello World";
		for (int i=0; i <str.length(); i++) {
			char result = str.charAt(i);
			System.out.println(result);
		}
		
	}
	
	@Test
	public void testcharAt2() {
		
		String str = "Welcome to the world of Java Selenium";
		if (str.charAt(8) == 't') {
			System.out.println("The charater is: t ");
		}
		else
			System.out.println("The character is not t");
	}
	
	@Test
	public void testcharAt3() {
		
		String str = "Welcome to the world of Testing using TestNG and Selenium";
		
		for (int i=0; i < str.length(); i++) {
			if(str.charAt(i) == 'S')  {
				if (str.charAt(i+1) == 'e') {
					char alp1 = str.charAt(i);
					char alp2 = str.charAt(i+1);
					System.out.println("The statement consists of " + alp1 + alp2);
				}
			}
		}
	}
	
	@Test
	public void testcompareTo() {
		String str1 = "Hello";
		String str2 = "Hell0";
		
		System.out.println(str1.compareTo(str2));							//Returns 63 when the result is wrong?
	}
	
	@Test
	public void testcompareTo1() {
		String str1 = "Test example";
		String str2 = "Test Example";

		int result = str1.compareToIgnoreCase(str2);
		if (result < 0) {
			System.out.println(str1 + " is greater than " + str2);
		}
		else if (result == 0 ) {
			System.out.println(str1 + " is equal to " + str2);
		}
		else if (result > 0) {
			System.out.println(str1 + " is less than " + str2);
		}		
	}
	
	@Test
	public void testconcat() {
		
		String str1 = "Mahesh Kumar";
		String str2 = " Gubbala";
		
		System.out.println(str1.concat(str2));
	}

	@Test
	public void testconcat1() {
		
		String str1 = "Score is: ";
		int value1 = 100;
		
		String result = str1.concat(String.valueOf(value1));
		System.out.println(result);
	}
	
	@Test
	public void testcontains() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.navigate().to("https://the-internet.herokuapp.com/");
		String header = driver.findElement(By.xpath("//*[@id=\'content\']/h1")).getText();
		System.out.println(header.contains("internet"));		
		driver.quit();
	}
	
	@Test
	public void testEndsWith() {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.navigate().to("https://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//*[@id='content']/ul/li[20]/a")).click();
		
		String message = driver.findElement(By.xpath("//*[@id='content']/div/h2")).getText();
		System.out.println(message);
		System.out.print(message.endsWith("Password"));
	}

	@Test
	public void testIsEmpty() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.navigate().to("https://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//*[@id='content']/ul/li[20]/a")).click();
		
		String message = driver.findElement(By.xpath("//*[@id='email']")).getText();
		System.out.println("Email field message is: " + message);
		System.out.println(message.isEmpty());
		driver.quit();
	}
	
	@Test
	public void testIsEmpty1() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.navigate().to("https://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//*[@id='content']/ul/li[21]/a")).click();
		driver.findElement(By.id("username")).sendKeys("Mahesh");
		driver.findElement(By.id("password")).sendKeys("Kumar");
		
		String message = driver.findElement(By.id("username")).getText();
		System.out.println(message);
		System.out.println(message.isEmpty());										// Should be empty? or should have Mahesh?
		driver.quit();
	}
	
	@Test
	public void testTrim() {
		
		String str = "         Hello          ";
		String str1 = "###Hello###";
		String result = str.trim();
		System.out.println(result);
		System.out.println(str1.trim());
			
	}
	
	
}
