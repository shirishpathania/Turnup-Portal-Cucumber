package Pages;

import Utils.WaitHelpers;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TMPage {

    public void CreateTM(WebDriver driver, String code, String typeCode, String description, String price) {

        // Click on create new button
        WebElement createButton = driver.findElement(By.xpath("//*[@id='container']/p/a"));
        createButton.click();

        WaitHelpers.WaitToBeClickable(driver, "xpath", "//*[@id='TimeMaterialEditForm']/div/div[1]/div/span[1]", 2);

        // Select Material from type code dropdown
        WebElement typeCodeDropdown = driver.findElement(By.xpath("//*[@id='TimeMaterialEditForm']/div/div[1]/div/span[1]"));
        typeCodeDropdown.click();

        WaitHelpers.WaitToBeClickable(driver, "xpath", "//*[@id='TypeCode_listbox']/li[1]", 2);

        WebElement materialOption = driver.findElement(By.xpath("//*[@id='TypeCode_listbox']/li[1]"));
        materialOption.click();

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

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // Wait till the last page button is clickable
        WaitHelpers.WaitToBeClickable(driver, "xpath", "//*[@id='tmsGrid']/div[4]/a[4]/span", 20);

        // Click on go to last page button
        WebElement goToLastPageButton = driver.findElement(By.xpath("//*[@id='tmsGrid']/div[4]/a[4]/span"));
        goToLastPageButton.click();

        // Check if material record has been created
        WaitHelpers.WaitToBeVisible(driver, "xpath", "//*[@id='tmsGrid']/div[3]/table/tbody/tr[last()]/td[1]", 20);
        WebElement newCode = driver.findElement(By.xpath("//*[@id='tmsGrid']/div[3]/table/tbody/tr[last()]/td[1]"));
        WebElement newTypeCode = driver.findElement(By.xpath("//*[@id='tmsGrid']/div[3]/table/tbody/tr[last()]/td[2]"));
        WebElement newDescription = driver.findElement(By.xpath("//*[@id='tmsGrid']/div[3]/table/tbody/tr[last()]/td[3]"));
        WebElement newPrice = driver.findElement(By.xpath("//*[@id='tmsGrid']/div[3]/table/tbody/tr[last()]/td[4]"));

        System.out.println(newCode.getText());
        Assert.isTrue(newCode.getText().contains(code), "Material record hasn't been created");
        Assert.isTrue(newTypeCode.getText().contains(typeCode), "Material record hasn't been created");
        Assert.isTrue(newDescription.getText().contains(description), "Material record hasn't been created");
        Assert.isTrue(newPrice.getText().contains(price), "Material record hasn't been created");
    }

    public void EditTM(WebDriver driver, String code, String typeCode, String description, String price) {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // Wait till the last page button is clickable
        WaitHelpers.WaitToBeClickable(driver, "xpath", "//*[@id='tmsGrid']/div[4]/a[4]", 5);

        // Click on go to last page button
        WebElement goToLastPageButton = driver.findElement(By.xpath("//*[@id='tmsGrid']/div[4]/a[4]/span"));
        goToLastPageButton.click();

        WaitHelpers.WaitToBeVisible(driver, "xpath", "//*[@id='tmsGrid']/div[3]/table/tbody/tr/td[1]", 5);

        WebElement findNewRecord = driver.findElement(By.xpath("//*[@id='tmsGrid']/div[3]/table/tbody/tr[last()]/td[1]"));

        if (findNewRecord.getText().contains("Keyboard")) {

            // Check if material record has been updated
            WebElement editButton = driver.findElement(By.xpath("//*[@id='tmsGrid']/div[3]/table/tbody/tr[last()]/td[5]/a[1]"));
            editButton.click();

        } else {
            System.out.println("Record to be edited not found.");
        }

        WaitHelpers.WaitToBeClickable(driver, "xpath", "//*[@id='Code']", 5);
        // update code text box value
        WebElement codeTextbox = driver.findElement(By.xpath("//*[@id='Code']"));
        codeTextbox.clear();
        codeTextbox.sendKeys(code);

        // update description text box value
        WebElement descriptionTextbox = driver.findElement(By.id("Description"));
        descriptionTextbox.clear();
        descriptionTextbox.sendKeys(description);

        // update price per unit text box value
        WebElement priceInputTag = driver.findElement(By.xpath("//*[@id='TimeMaterialEditForm']/div/div[4]/div/span[1]/span/input[1]"));
        priceInputTag.click();

        WebElement pricePerUnit = driver.findElement(By.xpath("//*[@id='Price']"));
        pricePerUnit.clear();
        priceInputTag.click();
        pricePerUnit.sendKeys(price);

        // Click on save button
        WebElement saveButton = driver.findElement(By.id("SaveButton"));
        saveButton.click();

    }

    public void EditTMAssertion(WebDriver driver, String code, String typeCode, String description, String price) {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // Wait till the last page button is clickable
        WaitHelpers.WaitToBeClickable(driver, "xpath", "//*[@id='tmsGrid']/div[4]/a[4]", 5);

        // Click on go to last page button
        WebElement goToLastPageButton = driver.findElement(By.xpath("//*[@id='tmsGrid']/div[4]/a[4]/span"));
        goToLastPageButton.click();

        // Check if material record has been updated
        WebElement updatedTypeCode = driver.findElement(By.xpath("//*[@id='tmsGrid']/div[3]/table/tbody/tr[last()]/td[1]"));
        WebElement updatedDescription = driver.findElement(By.xpath("//*[@id='tmsGrid']/div[3]/table/tbody/tr[last()]/td[3]"));
        WebElement updatedPrice = driver.findElement(By.xpath("//*[@id='tmsGrid']/div[3]/table/tbody/tr[last()]/td[4]"));

        Assert.isTrue(updatedTypeCode.getText().contains(typeCode), "Material record hasn't been created");
        Assert.isTrue(updatedDescription.getText().contains(description), "Material record hasn't been created");
        Assert.isTrue(updatedPrice.getText().contains(price), "Material record hasn't been created");
    }

    public void DeleteTM(WebDriver driver) {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // Wait till the last page button is clickable
        WaitHelpers.WaitToBeClickable(driver, "xpath", "//*[@id='tmsGrid']/div[4]/a[4]", 5);

        // Click on go to last page button
        WebElement goToLastPageButton = driver.findElement(By.xpath("//*[@id='tmsGrid']/div[4]/a[4]"));
        goToLastPageButton.click();

        // Wait till the delete button is visible
        WaitHelpers.WaitToBeVisible(driver, "xpath", "//*[@id='tmsGrid']/div[3]/table/tbody/tr[last()]/td[5]/a[2]", 5);

        // Check if material record can be deleted
        WebElement Delete = driver.findElement(By.xpath("//*[@id='tmsGrid']/div[3]/table/tbody/tr[last()]/td[5]/a[2]"));
        Delete.click();

        driver.switchTo().alert().accept();

    }

    public void DeleteTMAssertion(WebDriver driver, String typeCode, String description, String price) {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Check if material record has been updated
        WebElement updatedTypeCode = driver.findElement(By.xpath("//*[@id='tmsGrid']/div[3]/table/tbody/tr[last()]/td[1]"));
        WebElement updatedDescription = driver.findElement(By.xpath("//*[@id='tmsGrid']/div[3]/table/tbody/tr[last()]/td[1]"));
        WebElement updatedPrice = driver.findElement(By.xpath("//*[@id='tmsGrid']/div[3]/table/tbody/tr[last()]/td[1]"));

        Assert.isTrue(updatedTypeCode.getText() != typeCode, "Material record hasn't been deleted");
        Assert.isTrue(updatedDescription.getText() != description, "Material record hasn't been deleted");
        Assert.isTrue(updatedPrice.getText() != price, "Material record hasn't been deleted");

    }
}
