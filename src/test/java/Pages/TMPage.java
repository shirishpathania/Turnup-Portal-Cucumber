package Pages;

import Utils.WaitHelpers;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TMPage {

    public void CreateTM(WebDriver driver)
    {

        // Click on create new button
        WebElement createButton = driver.findElement(By.xpath("//*[@id='container']/p/a"));
        createButton.click();

        WaitHelpers.WaitToBeClickable(driver, "xpath", "//*[@id='TimeMaterialEditForm']/div/div[1]/div/span[1]", 2);

        // Select Material from typecode dropdown
        WebElement typeCodeDropdown = driver.findElement(By.xpath("//*[@id='TimeMaterialEditForm']/div/div[1]/div/span[1]"));
        typeCodeDropdown.click();

        WaitHelpers.WaitToBeClickable(driver, "xpath", "//*[@id='TypeCode_listbox']/li[1]", 2);

        WebElement materialOption = driver.findElement(By.xpath("//*[@id='TypeCode_listbox']/li[1]"));
        materialOption.click();

        // Identify code textbox and enter a code
        WebElement codeTextbox = driver.findElement(By.id("Code"));
        codeTextbox.sendKeys("Keyboard");

        // Identify description textbox and enter a description
        WebElement descriptionTextbox = driver.findElement(By.id("Description"));
        descriptionTextbox.sendKeys("Unknown Material");

        // Identify price per unit textbox and enter a code
        WebElement priceInputTag = driver.findElement(By.xpath("//*[@id='TimeMaterialEditForm']/div/div[4]/div/span[1]/span/input[1]"));
        priceInputTag.click();
//        Thread.Sleep(1000);

        WebElement pricePerUnit = driver.findElement(By.xpath("//*[@id='Price']"));
        pricePerUnit.clear();
        pricePerUnit.sendKeys("20");

        // Click on save button
        WebElement saveButton = driver.findElement(By.id("SaveButton"));
        saveButton.click();

//        Thread.Sleep(2000);

    }

    public void CreateTMAssertion(WebDriver driver)
    {
        // Wait till the last page button is clickable
        WaitHelpers.WaitToBeVisible(driver, "xpath", "//*[@id='tmsGrid']/div[4]/a[4]/span", 20);

        // Click on go to last page button
        WebElement goToLastPageButton = driver.findElement(By.xpath("//*[@id='tmsGrid']/div[4]/a[4]/span"));
        goToLastPageButton.click();

        // Check if material record has been created
        WaitHelpers.WaitToBeVisible(driver, "xpath", "//*[@id='tmsGrid']/div[3]/table/tbody/tr[last()]/td[1]", 20);
        WebElement newCode = driver.findElement(By.xpath("//*[@id='tmsGrid']/div[3]/table/tbody/tr[last()]/td[1]"));
        WebElement newTypeCode = driver.findElement(By.xpath("//*[@id='tmsGrid']/div[3]/table/tbody/tr[last()]/td[2]"));
        WebElement newDescription = driver.findElement(By.xpath("//*[@id='tmsGrid']/div[3]/table/tbody/tr[last()]/td[3]"));
        WebElement newPrice = driver.findElement(By.xpath("//*[@id='tmsGrid']/div[3]/table/tbody/tr[last()]/td[4]"));

        //if (newCode.getText() == "AAA111")
        //{
        //    Assert.Pass("New material record created successfully");
        //}
        //else
        //{
        //    Assert.Fail("Material record hasn't been created");
        //}

        System.out.println(newCode.getText());
        Assert.isTrue(newCode.getText().contains("Keyboard"), "Material record hasn't been created");
        Assert.isTrue(newTypeCode.getText().contains("M"), "Material record hasn't been created");
        Assert.isTrue(newDescription.getText().contains("Unknown Material"), "Material record hasn't been created");
        Assert.isTrue(newPrice.getText().contains("$20.00"), "Material record hasn't been created");
    }

    public void EditTM(WebDriver driver, String description, String code, String price)
    {

        // Wait till the last page button is clickable
        //WaitHelpers.WaitToBeClickable(driver, "xpath", "//*[@id='tmsGrid']/div[4]/a[4]", 5);
//        Thread.Sleep(2000);

        // Click on go to last page button
        WebElement goToLastPageButton2 = driver.findElement(By.xpath("//*[@id='tmsGrid']/div[4]/a[4]/span"));
        goToLastPageButton2.click();

        WaitHelpers.WaitToBeVisible(driver, "xpath", "//*[@id='tmsGrid']/div[3]/table/tbody/tr[last()]/td[2]", 2);

        WebElement findNewRecord = driver.findElement(By.xpath("//*[@id='tmsGrid']/div[3]/table/tbody/tr[last()]/td[2]"));
//        Console.Write(findNewRecord.getText());

        if (findNewRecord.getText() == "M")
        {

            // Check if material record has been updated
            WebElement editButton = driver.findElement(By.xpath("//*[@id='tmsGrid']/div[3]/table/tbody/tr[last()]/td[5]/a[1]"));
            editButton.click();

        }
        else
        {
            System.out.println("Record to be edited not found.");
        }

        // update code textbox value
        WebElement codeTextbox2 = driver.findElement(By.id("Code"));
        codeTextbox2.clear();
        codeTextbox2.sendKeys(code);

        // update description textbox value
        WebElement descriptionTextbox2 = driver.findElement(By.id("Description"));
        descriptionTextbox2.clear();
        descriptionTextbox2.sendKeys(description);

        // update price per unit textbox value
        WebElement priceInputTag2 = driver.findElement(By.xpath("//*[@id='TimeMaterialEditForm']/div/div[4]/div/span[1]/span/input[1]"));
        priceInputTag2.click();
//        Thread.Sleep(1000);

        WebElement pricePerUnit2 = driver.findElement(By.xpath("//*[@id='Price']"));
        pricePerUnit2.clear();
        pricePerUnit2.click();
        pricePerUnit2.sendKeys(price);

        // Click on save button
        WebElement saveButton2 = driver.findElement(By.id("SaveButton"));
        saveButton2.click();

//        Thread.Sleep(5000);


    }

    public void EditTMAssertion(WebDriver driver, String description, String code, String price)
    {
        // Click on go to last page button
        WebElement goToLastPageButton3 = driver.findElement(By.xpath("//*[@id='tmsGrid']/div[4]/a[4]/span"));
        goToLastPageButton3.click();

        // Check if material record has been updated
        WebElement updatedTypeCode = driver.findElement(By.xpath("//*[@id='tmsGrid']/div[3]/table/tbody/tr[last()]/td[1]"));
        WebElement updatedDescription = driver.findElement(By.xpath("//*[@id='tmsGrid']/div[3]/table/tbody/tr[last()]/td[1]"));
        WebElement updatedPrice = driver.findElement(By.xpath("//*[@id='tmsGrid']/div[3]/table/tbody/tr[last()]/td[1]"));

        //if (updatedCode.getText() == "BBB222")
        //{
        //    Assert.Pass("Existing material record updated successfully");
        //}
        //else
        //{
        //    Assert.Fail("Existing material record hasn't been updated");
        //}

        Assert.isTrue(updatedTypeCode.getText() == code, "Material record hasn't been created");
        Assert.isTrue(updatedDescription.getText() == description, "Material record hasn't been created");
        Assert.isTrue(updatedPrice.getText() == price, "Material record hasn't been created");
    }

    public void DeleteTM(WebDriver driver)
    {

        // Wait till the last page button is clickable
//        Thread.Sleep(2000);

        // Click on go to last page button
        WebElement goToLastPageButton = driver.findElement(By.xpath("//*[@id='tmsGrid']/div[4]/a[4]"));
        goToLastPageButton.click();

        // Wait till the delete button is visible
        WaitHelpers.WaitToBeVisible(driver, "xpath", "//*[@id='tmsGrid']/div[3]/table/tbody/tr[last()]/td[5]/a[2]", 5);

        // Check if material record can be deleted
        WebElement Delete = driver.findElement(By.xpath("//*[@id='tmsGrid']/div[3]/table/tbody/tr[last()]/td[5]/a[2]"));
        Delete.click();

//        Thread.Sleep(2000);

        driver.switchTo().alert().accept();
//        Thread.Sleep(2000);


    }

    public void DeleteTMAssertion(WebDriver driver)
    {

        driver.navigate().refresh();

        // Check if material record has been updated
        WebElement updatedTypeCode = driver.findElement(By.xpath("//*[@id='tmsGrid']/div[3]/table/tbody/tr[last()]/td[1]"));
        WebElement updatedDescription = driver.findElement(By.xpath("//*[@id='tmsGrid']/div[3]/table/tbody/tr[last()]/td[1]"));
        WebElement updatedPrice = driver.findElement(By.xpath("//*[@id='tmsGrid']/div[3]/table/tbody/tr[last()]/td[1]"));

        //if (updatedCode.getText() == "BBB222")
        //{
        //    Assert.Pass("Existing material record updated successfully");
        //}
        //else
        //{
        //    Assert.Fail("Existing material record hasn't been updated");
        //}

        Assert.isTrue(updatedTypeCode.getText() != "M", "Material record hasn't been deleted");
        Assert.isTrue(updatedDescription.getText() != "Known Material", "Material record hasn't been deleted");
        Assert.isTrue(updatedPrice.getText() != "$10.00", "Material record hasn't been deleted");

    }
}
