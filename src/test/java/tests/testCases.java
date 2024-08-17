package tests;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Driver;


public class testCases {


	
	
	public static void main(String[] args) throws InterruptedException {
		
		amazon_TestCase2();
		
	}
	
	
	
	public static void amazon_TestCase1() throws InterruptedException {
		
		
		Driver.getDriver().manage().window().maximize();
		
		Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
		
		Driver.getDriver().get("https://amazon.com");
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchDropdownBox")));
		
		WebElement dept = Driver.getDriver().findElement(By.xpath("//*[@id=\"searchDropdownBox\"]"));
		
		Select selectDept = new Select(dept);
		Thread.sleep(500);
	
		List <WebElement> allDepts = selectDept.getOptions();
		System.out.println("We have: " + allDepts.size() + " departments in Amazon");
		System.out.println("=================================");
		
		
		for (int i=0; i<allDepts.size(); i++) {
			System.out.println("Department #" + (i+1) + ": " + allDepts.get(i).getText());
			
		}
		
	}

	public static void amazon_TestCase2() throws InterruptedException {
		
		
		//WebDriver driver = new FirefoxDriver();
		Driver.getDriver().manage().window().maximize();
		
		Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
		
		Driver.getDriver().get("https://amazon.com");
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchDropdownBox")));
		
		//Thread.sleep(2000);
		//wait.until(ExpectedConditions.elementToBeSelected(driver.findElement(By.xpath("//*[@id=\"searchDropdownBox\"]"))));		
		
		if (Driver.getDriver().getTitle().equals("Amazon.com. Spend less. Smile more.")) {
			System.out.println("TITLE of a Page is CORRECT!");
		} else {
			
			System.out.println("Title is WRONG");
			
		} 
		
		Select selectDept = new Select(Driver.getDriver().findElement(By.id("searchDropdownBox")));
		
		if (selectDept.getFirstSelectedOption().getText().equals("All Departments")) {

			System.out.println("DEFAULT dropdown value is CORRECT!");
		
		} else {
			
			System.out.println("NO ANSWER about DropDown Select");
			
		} 
//		selectDept.selectByIndex(35);
//		selectDept.selectByVisibleText("Home & Kitchen");
		
		
		Driver.getDriver().findElement(By.id("twotabsearchtextbox")).sendKeys("coffee mug" + Keys.ENTER);
		Thread.sleep(2000);
		
		//wait.until(ExpectedConditions.elementToBeSelected(driver.findElement(By.id("searchDropdownBox"))));
		
		System.out.println(Driver.getDriver().getTitle());
		
		if (Driver.getDriver().getTitle().contains("coffee mug")) {
			
			System.out.println("Page TITLE - 'coffee mug' is OK");
			
		} else {
			
			System.out.println("Page TITLE - 'coffee mug' is FAILED");

		}
		
		
		
	}
	
	
	
}
