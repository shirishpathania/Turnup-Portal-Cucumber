package StepDefinitions;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.TMPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;

public class TMFeatureStepDefinition {

    ChromeDriver driver = new ChromeDriver();

    LoginPage loginPageObject = new LoginPage();
    HomePage homePageObject = new HomePage();
    TMPage tmPageObject = new TMPage();

    @Given("I logged into turnup portal successfully")
    public void i_logged_into_turnup_portal_successfully() {

        loginPageObject.LoginSteps(driver);

    }
    @When("I navigate to time and material page")
    public void i_navigate_to_time_and_material_page() {

        homePageObject.GoToTMPage(driver);

    }
    @When("I create a new time and material record")
    public void i_create_a_new_time_and_material_record() {

        tmPageObject.CreateTM(driver);

    }
    @Then("The record should be created successfully")
    public void the_record_should_be_created_successfully() {

        tmPageObject.CreateTMAssertion(driver);
        driver.quit();

    }

    @When("I edit an existing time and material record '(.*)' '(.*)' '(.*)'")
    public void i_edit_an_existing_time_and_material_record(String description, String code, String price) {

        tmPageObject.EditTM(driver, description, code, price);

    }
    @Then("The record should be updated successfully '(.*)' '(.*)' '(.*)'")
    public void the_record_should_be_updated_successfully(String description, String code, String price) {

        tmPageObject.EditTMAssertion(driver, description, code, price);
        driver.quit();

    }

    @When("I delete an existing time and material record")
    public void IDeleteAnExistingTimeAndMaterialRecord()
    {
        tmPageObject.DeleteTM(driver);
        driver.quit();
    }

    @Then("The record should be deleted successfully")
    public void TheRecordShouldBeDeletedSuccessfully()
    {
        tmPageObject.DeleteTMAssertion(driver);
    }
}
