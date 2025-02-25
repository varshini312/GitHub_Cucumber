package driverFactory;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;
import org.testng.annotations.Test;

import commonFunctions.FunctionLibrary;
import config.AppUtil;
import util.ExcelUtil;

public class AppTest extends AppUtil{
String inputpath ="./FileInput/Login.xlsx";	
String outputpath ="./FileOutput/LoginResults.xlsx";
String outputpath1 ="./FileOutput/InvalidLoginResults.xlsx";
@Test(enabled = true,priority = 0)
public void startTest() throws Throwable
{
	//create reference object for Excelutil class
	ExcelUtil xl = new ExcelUtil(inputpath);
	//count no of rows in Logindata sheet
	int rc =xl.rowCount("Logindata");
	Reporter.log("No of rows are::"+rc,true);
	for(int i=1;i<=rc;i++)
	{
		//read user name and password cell from excel uitl class
		String username = xl.getCellData("Logindata", i, 0);
		String password =xl.getCellData("Logindata", i, 1);
		//call admin login method from function liabray class
		boolean res =FunctionLibrary.adminLogin(username, password);
		if(res)
		{
			//if res is true write as login success into results cell
			xl.setCellData("Logindata", i, 2, "Login Success", outputpath);
			//write as pass into status cell
			xl.setCellData("Logindata", i, 3, "Pass", outputpath);
		}
		else
		{
			//take screen shot 
			File screen =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screen, new File("./target/Screenshot/"+i+"Loginpage.png"));
			//if res is false write as login Fail into results cell
			xl.setCellData("Logindata", i, 2, "Login Fail", outputpath);
			//write as Fail into status cell
			xl.setCellData("Logindata", i, 3, "Fail", outputpath);
		}
		
	}
	
}
@Test(enabled = true,priority = 1)
public void InvalidLogin() throws Throwable
{
	//create reference object for Excel util class
	ExcelUtil xl = new ExcelUtil(inputpath);
	//count no of rows in Login data sheet
	int rc = xl.rowCount("LoginInvalid");
	Reporter.log("No of rows are::"+rc,true);
	for(int i=1;i<=rc;i++)
	{
		String username = xl.getCellData("LoginInvalid", i, 0);
		String password = xl.getCellData("LoginInvalid", i, 1);
		FunctionLibrary.adminLoginInvalid(username, password);
		boolean res =FunctionLibrary.isErrorDispalyed();
		if(res)
		{
			//take screen shot 
			File screen =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screen, new File("./target/Screenshot/"+i+"Loginpage.png"));
			xl.setCellData("LoginInvalid", i, 2, "Invalid Credentails", outputpath1);
			xl.setCellData("LoginInvalid", i, 3, "Pass", outputpath1);
		}
		else
		{
			xl.setCellData("LoginInvalid", i, 2, "valid Credentails", outputpath1);
			xl.setCellData("LoginInvalid", i, 3, "Fail", outputpath1);
		}
	}
}


}
