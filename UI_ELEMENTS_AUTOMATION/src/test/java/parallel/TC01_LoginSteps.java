//package stepdefinitions;
package parallel;

import org.junit.Assert;

import com.pageObjects.TC01_LoginObjects;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC01_LoginSteps {

	private TC01_LoginObjects lpObj = new TC01_LoginObjects(DriverFactory.getDriver());
	
	@Given("User is on Admin Login Page")
	public void user_is_on_admin_login_page() {
		DriverFactory.getDriver().get("http://localhost/abante/index.php?s=kshitij");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@When("User enters username as {string}")
	public void user_enters_username_as(String userid) {
		lpObj.enterUsername(userid);
	}

	@When("Password as {string}")
	public void password_as(String passwd) {
		lpObj.enterPasswd(passwd);
	}

	@When("clicks on Login Button")
	public void clicks_on_login_button() {
		lpObj.clickLoginBtn();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("Page Title will be {string}")
	public void page_title_will_be(String expectedTitle) {
		if(expectedTitle.equals(DriverFactory.getDriver().getTitle())) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}
	
	@Then("User is able to Logout")
	public void user_is_able_to_logout() {
	    lpObj.clickAdminCaret();
	    lpObj.clickLogoutBtn();
	    try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
