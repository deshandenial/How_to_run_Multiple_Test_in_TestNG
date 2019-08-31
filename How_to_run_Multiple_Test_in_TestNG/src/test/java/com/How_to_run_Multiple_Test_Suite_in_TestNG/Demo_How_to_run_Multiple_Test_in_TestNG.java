package com.How_to_run_Multiple_Test_Suite_in_TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Demo_How_to_run_Multiple_Test_in_TestNG
{

	WebDriver driver;
	
  @Test
  public void Double_clicks_onElement() 
  {
	  	driver.get("https://artoftesting.com/sampleSiteForSelenium.html");
		WebElement element=driver.findElement(By.xpath("//button[@id='dblClkBtn']"));
		Actions action=new Actions(driver);
		//action.doubleClick(element).build().perform();
		// (or)
		action.moveToElement(element).doubleClick().build().perform();
		Alert alert=driver.switchTo().alert();
		alert.accept();
		
  }
  
  @Test
  public void Keyboard_Events_keyDown() 
  {
	  	
		driver.get("https://www.github.com");
		Actions action=new Actions(driver);
		action.keyDown(Keys.CONTROL).sendKeys("a").build().perform();
		
  }
  
  
  @Test
  public void dragAndDrop() 
  {
	  	driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(0);
		WebElement source=driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement destination=driver.findElement(By.xpath("//div[@id='droppable']"));
		Actions action=new Actions(driver);
		action.dragAndDrop(source, destination).build().perform();
		
  }
  @BeforeMethod
  public void beforeMethod() 
  {
	  System.out.println("hai this is @BeforeMethod Annotation");
  }

  @AfterMethod
  public void afterMethod() 
  {
	  System.out.println("hai this is @AfterMethod Annotation");
  }

  @BeforeClass
  public void beforeClass() 
  {
	  System.out.println("hai this is @BeforeClass Annotation");
  }

  @AfterClass
  public void afterClass() 
  {
	  System.out.println("hai this is @AfterClass Annotation");
  }

  @BeforeTest
  public void beforeTest()
  {
	  	System.out.println("hai this is @BeforeTest Annotation");
	  	System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("---disable-notification---");
		driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
  }

  @AfterTest
  public void afterTest()
  {
	  System.out.println("hai this is @AfterTest Annotation");
	  driver.close();
	 
  }

  @BeforeSuite
  public void beforeSuite()
  {
	  System.out.println("hai this is @BeforeSuite Annotation");
  }

  @AfterSuite
  public void afterSuite() 
  {
	  System.out.println("hai this is @AfterSuite Annotation");
	  
  }

}
