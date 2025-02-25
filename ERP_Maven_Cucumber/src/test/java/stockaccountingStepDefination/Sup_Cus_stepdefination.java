package stockaccountingStepDefination;

import org.openqa.selenium.WebDriver;

import commonFunctions.FunctionLibrary;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Sup_Cus_stepdefination {
	


		WebDriver driver;
		@Given("launch url {string} in a browser")
		public void launch_url_in_a_browser(String url) {
		   driver = FunctionLibrary.startBrowser(url);
		}

		@When("Enter username  with {string} and {string} and {string}")
		public void enter_username_with_and_and(String Ltype, String Lvalue, String Testdata) {
		    FunctionLibrary.typeAction(Ltype, Lvalue, Testdata);
		}

		@When("Enter password with {string} and {string} and {string}")
		public void enter_password_with_and_and(String Ltype, String Lvalue, String Testdata) {
		    FunctionLibrary.typeAction(Ltype, Lvalue, Testdata);
		}

		@When("click login button with {string} and {string}")
		public void click_login_button_with_and(String Ltype, String Lvalue) {
			FunctionLibrary.clickAction(Ltype, Lvalue);
		    
		}

		@Then("validate title with {string}")
		public void validate_title_with(String Exp_Title) {
		    FunctionLibrary.validateTile(Exp_Title);
		}

		@When("click suppliers link with {string} and {string}")
		public void click_suppliers_link_with_and(String Ltype, String Lvalue) {
		    FunctionLibrary.clickAction(Ltype, Lvalue);
		}

		@When("click Add icon with {string}and {string}")
		public void click_Add_icon_with_and(String Ltype, String Lvalue) {
		    FunctionLibrary.clickAction(Ltype, Lvalue);
		}

		@When("capture supplier number with {string}and {string}")
		public void capture_supplier_number_with_and(String Ltype, String Lvalue) {
		    FunctionLibrary.capturesupNum(Ltype, Lvalue);
		}

		@When("Enter in {string} with {string} and {string}")
		public void enter_in_with_and(String TestData, String Ltype, String Lvalue) {
		    FunctionLibrary.typeAction(Ltype, Lvalue, TestData);
		}

		@When("click Add with {string} and {string}")
		public void click_Add_with_and(String Ltype, String Lvalue) throws Throwable {
		    FunctionLibrary.clickAction(Ltype, Lvalue);
		    Thread.sleep(2000);
		}

		@When("click confirm ok with {string} and {string}")
		public void click_confirm_ok_with_and(String Ltype, String Lvalue) throws Throwable {
		    FunctionLibrary.clickAction(Ltype, Lvalue);
		    Thread.sleep(2000);
		}

		@When("click alert ok with {string} and {string}")
		public void click_alert_ok_with_and(String Ltype, String Lvalue) throws Throwable {
		    FunctionLibrary.clickAction(Ltype, Lvalue);
		    Thread.sleep(2000);
		}

		@Then("validate supplier table")
		public void validate_supplier_table() throws Throwable {
		   FunctionLibrary.supplierTable();
		}
		@When("close browser")
		public void close_browser() {
		    driver.quit();
		}
		@When("click Customers link with {string} and {string}")
		public void click_Customers_link_with_and(String Ltype, String Lvalue) {
		    FunctionLibrary.clickAction(Ltype, Lvalue);
		}

		@When("capture Customer number with {string}and {string}")
		public void capture_Customer_number_with_and(String Ltype, String Lvalue) {
		   FunctionLibrary.capturecusNum(Ltype, Lvalue);
		}

		@Then("validate customer table")
		public void validate_customer_table() throws Throwable {
		    FunctionLibrary.customerTable();
		}


	}


