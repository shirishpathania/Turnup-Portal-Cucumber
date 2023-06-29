package Utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CommonDriver {

    public static WebDriver driver;

    @Before
    public void LoginActions() {

        // Launch Chrome browser
        driver = new ChromeDriver();

    }

    @After
    public void CloseTestRun() {
        driver.quit();

    }
}
