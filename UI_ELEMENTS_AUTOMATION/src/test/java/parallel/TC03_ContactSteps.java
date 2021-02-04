package parallel;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.By;

import com.pageObjects.TC03_ContactPage;
import com.qa.factory.DriverFactory;
import com.qa.utils.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC03_ContactSteps {

	private TC03_ContactPage contact = new TC03_ContactPage(DriverFactory.getDriver());
	
	@Given("A User navigates to ContactUs Page")
	public void a_user_navigates_to_contact_us_page() {
		DriverFactory.getDriver().get("http://localhost/abante/index.php?rt=content/contact");
		   try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("user fills the form from the given sheetname {string} and rownumber = {int}")
	public void user_fills_the_form_from_the_given_sheetname_and_rownumber_row_num(String sheetName, Integer rownumber) throws InvalidFormatException, IOException {
	    ExcelReader reader = new ExcelReader();
	    List<Map<String,String>> testData = reader.getData("src/test/resources/test_data/SampleTestData.xlsx", sheetName);
	    String name = testData.get(rownumber).get("Name");
	    String email = testData.get(rownumber).get("Email");
	    String message = testData.get(rownumber).get("Enquiry");
	    
	    contact.setName(name);
	    contact.setEmail(email);
	    contact.setEnquiry(message);
	    
	    try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@When("User Click on Send Button")
	public void user_click_on_send_button() {
		contact.clickSubmit();
	}

	@Then("It Shows a Successful Message as {string}")
	public void it_shows_a_successful_message_as(String successMsg) {
		if(DriverFactory.getDriver().findElement(By.xpath("//*[text()='Your enquiry has been successfully sent to the store owner!']")).isDisplayed()) {
			System.out.println("Web Element is Visible Text Verified Successfully");
			System.out.println("Test Pass");
			Assert.assertTrue(true);
		}
		else {
			System.out.println("Test Fail");
			Assert.assertTrue(false);
		}
	}
}
