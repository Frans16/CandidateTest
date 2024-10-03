package compass.stepDefinitions;

import java.util.List;
import java.util.Map;

import compass.pageObjects.Homepage;
import compass.pageObjects.Login;
import compass.utils.HelperClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Glue {
	
	Homepage homepage;
	Login login;
	
	public Glue() {
		homepage = new Homepage();
		login = new Login();
	}
	
	@Given("User is on site {string}")
	public void user_is_on_site(String pageUrl) {
	    HelperClass.openPage(pageUrl);
	}
	@When("User enters valid credentials for my account")
	public void user_enters_valid_credentials_for_my_account(DataTable dataTable) {
		homepage.checkModal();
		homepage.enterProfile();
		
        List<Map<String, String>> credentials = dataTable.asMaps(String.class, String.class);
        
        for(Map<String, String> row:credentials) {
        	String email = row.get("email");
        	String password = row.get("password");
        	
        	login.inputEmail(email);
        	login.inputPassword(password);
        }
	}
	@When("User clicks the {string} button")
	public void user_clicks_the_button(String buttonType) {
	    login.clickButton(buttonType);
	}
	@Then("User should be redirected to the homepage")
	public void user_should_be_redirected_to_the_homepage() {
		homepage.verifyHomepage();
	}
}
