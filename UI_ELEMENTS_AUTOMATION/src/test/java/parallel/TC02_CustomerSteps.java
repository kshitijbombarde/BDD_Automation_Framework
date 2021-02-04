package parallel;

import java.util.List;
import java.util.Map;

import com.pageObjects.TC00_DashboardObjects;
import com.pageObjects.TC01_LoginObjects;
import com.pageObjects.TC02_CustomerObjects;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class TC02_CustomerSteps {

	private TC01_LoginObjects lpObj = new TC01_LoginObjects(DriverFactory.getDriver());	
	private TC00_DashboardObjects dash;
	private TC02_CustomerObjects cust;
	
	@Given("User has Already Logged into the application")
	public void user_has_already_logged_into_the_application(DataTable dataTable) {
	   List<Map<String, String>> credList = dataTable.asMaps();
	   String userid = credList.get(0).get("username");
	   String passwd = credList.get(0).get("password");
	   
	   DriverFactory.getDriver().get("http://localhost/abante/index.php?s=kshitij");
	   try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   dash = lpObj.doLogin(userid, passwd);
	}

	@Given("User is on Dashboard")
	public void user_is_on_dashboard() {
		if(DriverFactory.getDriver().getTitle().equals("Dashboard")) {
			System.out.println("User is on Dashboard");
		}
		else {
			System.out.println("Unable to verify that User is on Dashboard >>> Terminating Flow");
			Assert.assertTrue(false);
		}
	}

	@When("User clicks on Customers Button")
	public void user_clicks_on_customers_button() {
		cust = dash.clickCustomers();
	}

	@When("clicks on Add Customer Button")
	public void clicks_on_add_customer_button() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cust.clickAddBtn();
	}

	@Then("User Toggles Approved_Switch")
	public void user_toggles_approved_switch() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cust.switchApproved();
	}

	@Then("User will Enter the Login_Name as {string}")
	public void user_will_enter_the_login_name_as(String loginName) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cust.enterLoginName(loginName);
	}

	@Then("User will Enter First_Name as {string}")
	public void user_will_enter_first_name_as(String firstName) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cust.enterFirstName(firstName);
	}
	
	@Then("User will Enter Last_Name as {string}")
	public void user_will_enter_last_name_as(String lsName) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cust.enterLastName(lsName);
	}

	@Then("User will Enter Email as {string}")
	public void user_will_enter_email_as(String email) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cust.enterEmail(email);
	}

	@Then("User will Enter Password as {string}")
	public void user_will_enter_password_as(String passwd) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cust.enterPassword(passwd);
	}

	@Then("User will confirm Password as {string}")
	public void user_will_confirm_password_as(String cpass) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cust.confirmPassword(cpass);
	}

	@Then("User will Click on Save")
	public void user_will_click_on_save() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cust.clickSaveBtn();
	}

	@Then("TransactionsTab will get Visible on UI")
	public void transactions_tab_will_get_visible_on_ui() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(cust.isTxnTabVisible()) {
			System.out.println("Transactions Tab is Visble >>> New Customer Added Successfully");
		}
		else {
			Assert.assertTrue(false);
		}
	}
	
	@When("User Deletes Customer with Id as {string}")
	public void user_deletes_customer_with_id_as(String id) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cust.deleteUser(id);
	}

	@When("Confirms the Delete Action")
	public void confirms_the_delete_action() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cust.confirmDelete();
	}
}
