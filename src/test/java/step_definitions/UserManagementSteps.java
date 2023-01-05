package step_definitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CraterDashboardPage;
import pages.CraterLoginPage;
import utils.BrowserUtils;
import utils.Driver;
import utils.TestDataReader;

public class UserManagementSteps {
	
	CraterLoginPage craterLogin = new CraterLoginPage();
	CraterDashboardPage dashboard = new CraterDashboardPage();
	BrowserUtils utils = new BrowserUtils();

	
	//valid login test
	@Given("user is on the login page")
	public void user_is_on_the_login_page() {
		Driver.getDriver().get(TestDataReader.getProperty("craterUrl"));
		Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Driver.getDriver().manage().window().maximize();

	}

	@When("user enters valid {string} and {string}")
	public void user_enters_valid_and(String useremail, String password) {
		utils.sendKeysWithActionsClass(craterLogin.useremail, useremail);
		utils.sendKeysWithActionsClass(craterLogin.password, password);
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
		craterLogin.loginButton.click();

	}

	@Then("user should be navigated to the dashboard page")
	public void user_should_be_navigated_to_the_dashboard_page() {
		utils.waitUntilElementVisible(dashboard.amountDueText);
		Assert.assertTrue(dashboard.amountDueText.isDisplayed());
	}
	
	@Then("user quits the browser")
	public void user_quits_the_browser() {
	    Driver.quitDriver();
	}

	
	
	// Invalid login steps
	boolean userEmailEmpty;
	boolean passwordEmpty;
	
	@When("user enters invalid useremail {string} and password {string}")
	public void user_enters_invalid_and(String invalidUserEmail, String invalidPassword) {
		userEmailEmpty = invalidUserEmail.isBlank();
		passwordEmpty = invalidPassword.isBlank();
		utils.sendKeysWithActionsClass(craterLogin.useremail, invalidUserEmail);
		utils.sendKeysWithActionsClass(craterLogin.password, invalidPassword);
	}

	//Invalid login scenario outline
	@Then("error messages appear")
	public void error_messages_appear() {
	    if(userEmailEmpty || passwordEmpty) {
	    	utils.waitUntilElementVisible(craterLogin.fieldRequired);
	    	Assert.assertTrue(craterLogin.fieldRequired.isDisplayed());   	
	    }
	    else {
	    	utils.waitUntilElementVisible(craterLogin.invalidUserErrorMessage);
	    	Assert.assertTrue(craterLogin.invalidUserErrorMessage.isDisplayed());
	    }
	}

	@Then("user is not logged in")
	public void user_is_not_logged_in() {
		Assert.assertEquals(TestDataReader.getProperty("craterUrl"), Driver.getDriver().getCurrentUrl());
	}
	

}
