package StepDefinitions;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.TMPage;
import Utils.CommonDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TMFeatureStepDefinition extends CommonDriver {

    // WebDriver driver;
    LoginPage loginPageObject = new LoginPage();
    HomePage homePageObject = new HomePage();
    TMPage tmPageObject = new TMPage();

    @Before
    public void LoginActions() {

        // Launch Chrome browser
        driver = new ChromeDriver();

    }

    @After
    public void CloseTestRun() {
        driver.quit();

    }
    @Given("I logged into turnup portal successfully")
    public void i_logged_into_turnup_portal_successfully() {

        loginPageObject.LoginSteps(driver);

    }

    @When("I navigate to time and material page")
    public void i_navigate_to_time_and_material_page() {

        homePageObject.GoToTMPage(driver);

    }

    @When("I create a new time and material record {string} {string} {string} {string}")
    public void i_create_a_new_time_and_material_record(String code, String typeCode, String description, String price) {

        tmPageObject.CreateTM(driver, code, typeCode, description, price);

    }

    @Then("The record should be created successfully {string} {string} {string} {string}")
    public void the_record_should_be_created_successfully(String code, String typeCode, String description, String price) {

        tmPageObject.CreateTMAssertion(driver, code, typeCode, description, price);

    }

    @When("I edit an existing time and material record {string} {string} {string} {string}")
    public void i_edit_an_existing_time_and_material_record(String code, String typeCode, String description, String price) {

        tmPageObject.EditTM(driver, code, typeCode, description, price);

    }

    @Then("The record should be updated successfully {string} {string} {string} {string}")
    public void the_record_should_be_updated_successfully(String code, String typeCode, String description, String price) {

        tmPageObject.EditTMAssertion(driver, code, typeCode, description, price);

    }

    @When("I delete an existing time and material record")
    public void IDeleteAnExistingTimeAndMaterialRecord() {
        tmPageObject.DeleteTM(driver);
    }

    @Then("The record should be deleted successfully {string} {string} {string}")
    public void TheRecordShouldBeDeletedSuccessfully(String typeCode, String description, String price) {
        tmPageObject.DeleteTMAssertion(driver, typeCode, description, price);
    }
}
