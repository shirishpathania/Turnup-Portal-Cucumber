package Utils;

import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CommonDriver {

    public static WebDriver driver;


    // Page object initialization
    LoginPage loginPageObject = new LoginPage();

    public void LoginActions()
    {
        // open chrome browser
        driver = new ChromeDriver();

        // login page object initialization and definition

        loginPageObject.LoginSteps(driver);

    }

    public void CloseTestRun()
    {
        driver.quit();

    }
}
