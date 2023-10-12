package Pages;

import Utilities.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class TMPage {

    public void CreateTM(WebDriver driver, String code, String typeCode, String description, String price) {

        // Click on create new button
        WebElement createButton = driver.findElement(By.xpath("//*[@id='container']/p/a"));
        createButton.click();

        Wait.WaitToBeClickable(driver, "xpath", "//*[@id='TimeMaterialEditForm']/div/div[1]/div/span[1]", 2);

        WebElement dropdownMenu = driver.findElement(By.xpath("//span[contains(text(),'select')]"));
        dropdownMenu.click();

        // Select Material from type code dropdown
        if (typeCode.startsWith("T")) {
            WebElement typeCodeDropdown = driver.findElement(By.xpath("//li[contains(text(),'Time')]"));
            Wait.WaitToBeClickable(driver, "xpath", "//li[contains(text(),'Time')]", 2);
            typeCodeDropdown.click();

        }

        if (typeCode.startsWith("M")) {
            WebElement typeCodeDropdown = driver.findElement(By.xpath("//li[contains(text(),'Material')]"));
            Wait.WaitToBeClickable(driver, "xpath", "//li[contains(text(),'Material')]", 2);
            typeCodeDropdown.click();

        }

        // Identify code text box and enter a code
        WebElement codeTextbox = driver.findElement(By.id("Code"));
        codeTextbox.sendKeys(code);

        // Identify description text box and enter a description
        WebElement descriptionTextbox = driver.findElement(By.id("Description"));
        descriptionTextbox.sendKeys(description);

        // Identify price per unit text box and enter a code
        WebElement priceInputTag = driver.findElement(By.xpath("//*[@id='TimeMaterialEditForm']/div/div[4]/div/span[1]/span/input[1]"));
        priceInputTag.click();

        WebElement pricePerUnit = driver.findElement(By.xpath("//*[@id='Price']"));
        pricePerUnit.clear();
        pricePerUnit.sendKeys(price);

        // Click on save button
        WebElement saveButton = driver.findElement(By.id("SaveButton"));
        saveButton.click();

    }

    public void CreateTMAssertion(WebDriver driver, String code, String typeCode, String description, String price) {

        // Wait till the last page button is clickable
        Wait.WaitToBeClickable(driver, "xpath", "//*[@id='tmsGrid']/div[4]/a[4]/span", 20);

        // Click on go to last page button
        WebElement goToLastPageButton = driver.findElement(By.xpath("//*[@id='tmsGrid']/div[4]/a[4]/span"));
        goToLastPageButton.click();

        // Check if material record has been created
        Wait.WaitToBeVisible(driver, "xpath", "//*[@id='tmsGrid']/div[3]/table/tbody/tr[last()]/td[1]", 20);
        WebElement newCode = driver.findElement(By.xpath("//*[@id='tmsGrid']/div[3]/table/tbody/tr[last()]/td[1]"));
        WebElement newTypeCode = driver.findElement(By.xpath("//*[@id='tmsGrid']/div[3]/table/tbody/tr[last()]/td[2]"));
        WebElement newDescription = driver.findElement(By.xpath("//*[@id='tmsGrid']/div[3]/table/tbody/tr[last()]/td[3]"));
        WebElement newPrice = driver.findElement(By.xpath("//*[@id='tmsGrid']/div[3]/table/tbody/tr[last()]/td[4]"));

        Assert.assertEquals(newCode.getText(), code, "  Material record hasn't been created");
        Assert.assertEquals(newTypeCode.getText(), typeCode, "  Material record hasn't been created");
        Assert.assertEquals(newDescription.getText(), description, "  Material record hasn't been created");
        Assert.assertTrue(newPrice.getText().contains(price), "  Material record hasn't been created");
    }

    public void EditTM(WebDriver driver, String oldCode, String oldTypeCode, String oldDescription, String oldPrice,String newCode, String newTypeCode, String newDescription, String newPrice) {

        // Wait till the last page button is clickable
        Wait.WaitToBeClickable(driver, "xpath", "//*[@id='tmsGrid']/div[4]/a[4]", 5);

        // Click on go to last page button
        WebElement goToLastPageButton = driver.findElement(By.xpath("//*[@id='tmsGrid']/div[4]/a[4]/span"));
        goToLastPageButton.click();

        Wait.WaitToBeVisible(driver, "xpath", "//*[@id='tmsGrid']/div[3]/table/tbody/tr/td[1]", 5);

        WebElement findNewRecordCode = driver.findElement(By.xpath("//*[@id='tmsGrid']/div[3]/table/tbody/tr[last()]/td[1]"));
        WebElement findNewRecordTypeCode = driver.findElement(By.xpath("//*[@id='tmsGrid']/div[3]/table/tbody/tr[last()]/td[2]"));
        WebElement findNewRecordDescription = driver.findElement(By.xpath("//*[@id='tmsGrid']/div[3]/table/tbody/tr[last()]/td[3]"));
        WebElement findNewRecordPrice = driver.findElement(By.xpath("//*[@id='tmsGrid']/div[3]/table/tbody/tr[last()]/td[4]"));

        if (findNewRecordCode.getText().contains(oldCode) && findNewRecordTypeCode.getText().contains(oldTypeCode) && findNewRecordDescription.getText().contains(oldDescription) && findNewRecordPrice.getText().contains(oldPrice)) {

            // Click Edit button
            WebElement editButton = driver.findElement(By.xpath("//*[@id='tmsGrid']/div[3]/table/tbody/tr[last()]/td[5]/a[1]"));
            editButton.click();

        } else {
            System.out.println("Record to be edited not found.");
        }

        WebElement dropdownMenu = driver.findElement(By.xpath("//span[contains(text(),'select')]"));
        dropdownMenu.click();

        // Select Material from type code dropdown
        if (newTypeCode.startsWith("T")) {
            WebElement typeCodeDropdown = driver.findElement(By.xpath("//li[contains(text(),'Time')]"));
            Wait.WaitToBeClickable(driver, "xpath", "//li[contains(text(),'Time')]", 5);
            typeCodeDropdown.click();

        }

        if (newTypeCode.startsWith("M")) {
            WebElement typeCodeDropdown = driver.findElement(By.xpath("//li[contains(text(),'Material')]"));
            Wait.WaitToBeClickable(driver, "xpath", "//li[contains(text(),'Material')]", 5);
            typeCodeDropdown.click();

        }

        Wait.WaitToBeClickable(driver, "xpath", "//*[@id='Code']", 5);
        // update code text box value
        WebElement codeTextbox = driver.findElement(By.xpath("//*[@id='Code']"));
        codeTextbox.clear();
        codeTextbox.sendKeys(newCode);

        // update description text box value
        WebElement descriptionTextbox = driver.findElement(By.id("Description"));
        descriptionTextbox.clear();
        descriptionTextbox.sendKeys(newDescription);

        // update price per unit text box value
        WebElement priceInputTag = driver.findElement(By.xpath("//*[@id='TimeMaterialEditForm']/div/div[4]/div/span[1]/span/input[1]"));
        priceInputTag.click();

        WebElement pricePerUnit = driver.findElement(By.xpath("//*[@id='Price']"));
        pricePerUnit.clear();
        priceInputTag.click();
        pricePerUnit.sendKeys(newPrice);

        // Click on save button
        WebElement saveButton = driver.findElement(By.id("SaveButton"));
        saveButton.click();

    }

    public void EditTMAssertion(WebDriver driver, String newCode, String newTypeCode, String newDescription, String newPrice) {

        // Wait till the last page button is clickable
        Wait.WaitToBeClickable(driver, "xpath", "//*[@id='tmsGrid']/div[4]/a[4]", 5);

        // Click on go to last page button
        WebElement goToLastPageButton = driver.findElement(By.xpath("//*[@id='tmsGrid']/div[4]/a[4]/span"));
        goToLastPageButton.click();

        // Check if material record has been updated
        Wait.WaitToBeVisible(driver, "xpath", "//*[@id='tmsGrid']/div[3]/table/tbody/tr[last()]/td[1]", 5);
        WebElement updatedCode = driver.findElement(By.xpath("//*[@id='tmsGrid']/div[3]/table/tbody/tr[last()]/td[1]"));
        WebElement updatedTypeCode = driver.findElement(By.xpath("//*[@id='tmsGrid']/div[3]/table/tbody/tr[last()]/td[2]"));
        WebElement updatedDescription = driver.findElement(By.xpath("//*[@id='tmsGrid']/div[3]/table/tbody/tr[last()]/td[3]"));
        WebElement updatedPrice = driver.findElement(By.xpath("//*[@id='tmsGrid']/div[3]/table/tbody/tr[last()]/td[4]"));

        Assert.assertEquals(updatedCode.getText(), newCode, "  Material record hasn't been updated");
        Assert.assertEquals(updatedTypeCode.getText(), newTypeCode, "  Material record hasn't been updated");
        Assert.assertEquals(updatedDescription.getText(), newDescription, "  Material record hasn't been updated");
        Assert.assertTrue(updatedPrice.getText().contains(newPrice), "  Material record hasn't been updated");
    }

    public void DeleteTM(WebDriver driver) {

        // Wait till the last page button is clickable
        Wait.WaitToBeClickable(driver, "xpath", "//*[@id='tmsGrid']/div[4]/a[4]", 5);

        // Click on go to last page button
        WebElement goToLastPageButton = driver.findElement(By.xpath("//*[@id='tmsGrid']/div[4]/a[4]"));
        goToLastPageButton.click();

        // Wait till the delete button is visible
        Wait.WaitToBeVisible(driver, "xpath", "//*[@id='tmsGrid']/div[3]/table/tbody/tr[last()]/td[5]/a[2]", 5);

        // Check if material record can be deleted
        WebElement Delete = driver.findElement(By.xpath("//*[@id='tmsGrid']/div[3]/table/tbody/tr[last()]/td[5]/a[2]"));
        Delete.click();

        driver.switchTo().alert().accept();

    }

    public void DeleteTMAssertion(WebDriver driver, String code, String typeCode, String description, String price) {

        driver.navigate().refresh();

        // Check if material record has been updated
        Wait.WaitToBeVisible(driver, "xpath", "//*[@id='tmsGrid']/div[3]/table/tbody/tr[last()]/td[1]", 5);
        WebElement updatedCode = driver.findElement(By.xpath("//*[@id='tmsGrid']/div[3]/table/tbody/tr[last()]/td[1]"));
        WebElement updatedTypeCode = driver.findElement(By.xpath("//*[@id='tmsGrid']/div[3]/table/tbody/tr[last()]/td[1]"));
        WebElement updatedDescription = driver.findElement(By.xpath("//*[@id='tmsGrid']/div[3]/table/tbody/tr[last()]/td[1]"));
        WebElement updatedPrice = driver.findElement(By.xpath("//*[@id='tmsGrid']/div[3]/table/tbody/tr[last()]/td[1]"));

        Assert.assertNotEquals(updatedCode.getText(), code, "  Material record hasn't been deleted");
        Assert.assertNotEquals(updatedTypeCode.getText(), typeCode, "  Material record hasn't been deleted");
        Assert.assertNotEquals(updatedDescription.getText(), description, "  Material record hasn't been deleted");
        Assert.assertFalse(updatedPrice.getText().contains(price), "  Material record hasn't been deleted");
    }
}
