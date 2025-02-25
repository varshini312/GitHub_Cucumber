package commonFunctions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;



public class FunctionLibrary {
public static WebDriver driver;
public static String Expected="";
public static String Actual="";
//method for launching browser
public static WebDriver startBrowser(String url)
{
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.get(url);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	return driver;
}
//method form textboxes
public static void typeAction(String LocatorType,String LocatorValue,String testData)
{
	if(LocatorType.equalsIgnoreCase("name"))
	{
		driver.findElement(By.name(LocatorValue)).clear();
		driver.findElement(By.name(LocatorValue)).sendKeys(testData);
		
	}
	if(LocatorType.equalsIgnoreCase("xpath"))
	{
		driver.findElement(By.xpath(LocatorValue)).clear();
		driver.findElement(By.xpath(LocatorValue)).sendKeys(testData);
	}
	if(LocatorType.equalsIgnoreCase("id"))
	{
		driver.findElement(By.id(LocatorValue)).clear();
		driver.findElement(By.id(LocatorValue)).sendKeys(testData);
	}
}
//method for buttons,checkbox,radio buttons,links and images
public static void clickAction(String LocatorType,String LocatorValue)
{
	if(LocatorType.equalsIgnoreCase("xpath"))
	{
		driver.findElement(By.xpath(LocatorValue)).click();
	}
	if(LocatorType.equalsIgnoreCase("name"))
	{
		driver.findElement(By.name(LocatorValue)).click();
	}
	if(LocatorType.equalsIgnoreCase("id"))
	{
		driver.findElement(By.id(LocatorValue)).sendKeys(Keys.ENTER);
	}
}
//method for validate title
public static void validateTile(String Expected_Title)
{
	String Actual_title =driver.getTitle();
	try {
		Assert.assertEquals(Actual_title, Expected_Title,"Title is Not Matching");
	} catch (AssertionError e) {
		System.out.println(e.getMessage());
	}
	
}
//method for capture supplier number
public static void capturesupNum(String Locatortype,String Locatorvalue)
{
	if(Locatortype.equalsIgnoreCase("name"))
	{
		Expected = driver.findElement(By.name(Locatorvalue)).getAttribute("value");
	}
	if(Locatortype.equalsIgnoreCase("xpath"))
	{
		Expected = driver.findElement(By.xpath(Locatorvalue)).getAttribute("value");
	}
	if(Locatortype.equalsIgnoreCase("id"))
	{
		Expected = driver.findElement(By.id(Locatorvalue)).getAttribute("value");
	}
}
//method for validate supllier number 
public static void supplierTable() throws Throwable
{
	if(!driver.findElement(By.xpath("//input[@id='psearch']")).isDisplayed())
		//if search textbox not displayed click search panel button
		driver.findElement(By.xpath("//span[@data-caption='Search']")).click();
	driver.findElement(By.xpath("//input[@id='psearch']")).clear();
	driver.findElement(By.xpath("//input[@id='psearch']")).sendKeys(Expected);
	driver.findElement(By.xpath("//button[@id='btnsubmit']")).click();
	Thread.sleep(3000);
	//capture supplier number from specific row cell data
	Actual =driver.findElement(By.xpath("//table[@class='table ewTable']/tbody/tr[1]/td[6]/div/span/span")).getText();
	if(Actual.equals(Expected))
	{
		Reporter.log("Supplier Number found in Table::"+Expected+"      "+Actual,true);
		
	}
	else
	{
		Reporter.log("Supplier Number Not found in Table::"+Expected+"      "+Actual,true);
	}
}
//method for capture customer number
public static void capturecusNum(String Locatortype,String Locatorvalue)
{
	if(Locatortype.equalsIgnoreCase("name"))
	{
		Expected = driver.findElement(By.name(Locatorvalue)).getAttribute("value");
	}
	if(Locatortype.equalsIgnoreCase("xpath"))
	{
		Expected = driver.findElement(By.xpath(Locatorvalue)).getAttribute("value");
	}
	if(Locatortype.equalsIgnoreCase("id"))
	{
		Expected = driver.findElement(By.id(Locatorvalue)).getAttribute("value");
	}
}
//method for validate supllier number 
public static void customerTable() throws Throwable
{
	if(!driver.findElement(By.xpath("//input[@id='psearch']")).isDisplayed())
		//if search textbox not displayed click search panel button
		driver.findElement(By.xpath("//span[@data-caption='Search']")).click();
	driver.findElement(By.xpath("//input[@id='psearch']")).clear();
	driver.findElement(By.xpath("//input[@id='psearch']")).sendKeys(Expected);
	driver.findElement(By.xpath("//button[@id='btnsubmit']")).click();
	Thread.sleep(3000);
	//capture supplier number from specific row cell data
	Actual =driver.findElement(By.xpath("//table[@class='table ewTable']/tbody/tr[1]/td[5]/div/span/span")).getText();
	if(Actual.equals(Expected))
	{
		Reporter.log("Supplier Number found in Table::"+Expected+"      "+Actual,true);
		
	}
	else
	{
		Reporter.log("Supplier Number Not found in Table::"+Expected+"      "+Actual,true);
	}
}
}
