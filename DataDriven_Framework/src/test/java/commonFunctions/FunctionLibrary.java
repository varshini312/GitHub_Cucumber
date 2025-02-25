package commonFunctions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Reporter;

import config.AppUtil;

public class FunctionLibrary extends AppUtil {
//method for login
	public static boolean adminLogin(String user,String pass) throws Throwable
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		driver.get(conpro.getProperty("Url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//js.executeScript("document.querySelector(\"#btnreset\").click()");
		driver.findElement(By.xpath(conpro.getProperty("Objreset"))).click();
		driver.findElement(By.xpath(conpro.getProperty("Objuser"))).sendKeys(user);
		driver.findElement(By.xpath(conpro.getProperty("Objpass"))).sendKeys(pass);
		driver.findElement(By.xpath(conpro.getProperty("ObjLogin"))).click();
		Thread.sleep(2000);
		String Expected ="dashboard";
		String Actual =driver.getCurrentUrl();
		if(Actual.contains(Expected))
		{
			Reporter.log("Login success",true);
			driver.findElement(By.xpath(conpro.getProperty("Objlogout"))).click();
			return true;
		}
		else
		{
			//capture error message
			String error_mess = driver.findElement(By.xpath(conpro.getProperty("ObjErrormessage"))).getText();
			Thread.sleep(2000);
			driver.findElement(By.xpath(conpro.getProperty("ObjOk"))).click();
			Reporter.log(error_mess,true);
			return false;
		}
		
	}
	//method for login for invalid
		public static void adminLoginInvalid(String user,String pass) throws Throwable
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			driver.get(conpro.getProperty("Url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			//js.executeScript("document.querySelector(\"#btnreset\").click()");
		    driver.findElement(By.xpath(conpro.getProperty("Objreset"))).click();
			driver.findElement(By.xpath(conpro.getProperty("Objuser"))).sendKeys(user);
			driver.findElement(By.xpath(conpro.getProperty("Objpass"))).sendKeys(pass);
			driver.findElement(By.xpath(conpro.getProperty("ObjLogin"))).click();
			Thread.sleep(2000);
}
		public static boolean isErrorDispalyed()
		{
			String Error_mess = driver.findElement(By.xpath(conpro.getProperty("ObjErrormessage"))).getText();
			if(Error_mess.contains("Incorrect ") || Error_mess.contains("empty"))
			{
				return true;
			}else
			{
				return false;
			}
		}
}
