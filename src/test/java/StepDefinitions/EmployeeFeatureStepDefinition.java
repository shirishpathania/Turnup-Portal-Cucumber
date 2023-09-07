package StepDefinitions;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.TMPage;
import Utilities.CommonDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;

public class EmployeeFeatureStepDefinition extends CommonDriver {

    @When("I navigate to Employee page")
    public void iNavigateToEmployeePage() {

        System.out.println("Navigate to Employee page");
    }

    @Then("print a success message")
    public void printASuccessMessage() {

        System.out.println("Welcome to Employee page");
    }
}
