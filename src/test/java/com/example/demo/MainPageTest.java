package com.example.demo;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.annotations.*;
import java.net.MalformedURLException;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;


public class MainPageTest extends BaseTest{
    @BeforeClass
    public static void setUp() throws MalformedURLException {
        setUpAll();
    }

    @Test(description = "Test Scenario 1:")
    /**
     * Open LambdaTest’s Selenium Playground from
     * https://www.lambdatest.com/selenium-playground
     * 2. Click “Simple Form Demo” under Input Forms.
     * 3. Validate that the URL contains “simple-form-demo”.
     * 4. Create a variable for a string value E.g: “Welcome to LambdaTest”.
     * 5. Use this variable to enter values in the “Enter Message” text box.
     * 6. Click “Get Checked Value”.
     * 7. Validate whether the same text message is displayed in the right-hand
     * panel under the “Your Message:” section.
     */
    public void testScenario1() {
        try {
            //Open LambdaTest’s Selenium Playground from: https://www.lambdatest.com/selenium-playground
            launchBrowser();
            seleniumPlaygroundPage.simpleFormDemo.shouldBe(Condition.visible);
            //Click “Simple Form Demo” under Input Forms
            seleniumPlaygroundPage.simpleFormDemo.click();
            //Validate that the URL contains “simple-form-demo”.
            softAssert.assertTrue(WebDriverRunner.url().contains("simple-form-demo"), "URL does not contain the text");
            //Create a variable for a string value E.g: “Welcome to LambdaTest”
            String text ="Welcome to LambdaTest";
            //Use this variable to enter values in the “Enter Message” text box
            seleniumPlaygroundPage.enterMessageTextBox.shouldBe(Condition.visible);
            seleniumPlaygroundPage.enterMessageTextBox.sendKeys(text);
            //Assert and Click “Get Checked Value”.
            softAssert.assertEquals(seleniumPlaygroundPage.getCheckedCTA.getText(), "Get Checked value", "CTA button text does not match");
            seleniumPlaygroundPage.getCheckedCTA.click();
            //Validate whether the same text message is displayed in the right-hand* panel under the “Your Message:” section
            softAssert.assertEquals(seleniumPlaygroundPage.message.getText(), "Welcome to LambdaTest", "Message does not match");
        }
        catch (Exception e)
        {
            softAssert.fail();
        }
        softAssert.assertAll();
    }


    @Test(description = "Test Scenario 2:")
    /**
     * Open the https://www.lambdatest.com/selenium-playground page and
     * click “Drag & Drop Sliders” under “Progress Bars & Sliders”.
     * 2. Select the slider “Default value 15” and drag the bar to make it 95 by
     * validating whether the range value shows 95.
     */
    public void testScenario2() {
        try {
            //Open the https://www.lambdatest.com/selenium-playground page
            launchBrowser();
            // click “Drag & Drop Sliders” under “Progress Bars & Sliders
            seleniumPlaygroundPage.dragAndDrop.shouldBe(Condition.visible);
            seleniumPlaygroundPage.dragAndDrop.click();
            for (int i=15; i<95; i++) {
                seleniumPlaygroundPage.dragMe.sendKeys(Keys.RIGHT);
                Selenide.sleep(200);
            }
            //validating whether the range value shows 95.
            softAssert.assertEquals(seleniumPlaygroundPage.rangeSuccess.getText(), "95", "Slider value does not match");
        }
        catch (Exception e)
        {
            softAssert.fail();
        }
        softAssert.assertAll();
    }


    @Test(description = "Test Scenario 3:")
    /**
     * Open the https://www.lambdatest.com/selenium-playground page and
     * click “Input Form Submit” under “Input Forms”.
     * 2. Click “Submit” without filling in any information in the form.
     * 3. Assert “Please fill in the fields” error message.
     * 4. Fill in Name, Email, and other fields.
     * 5. From the Country drop-down, select “United States” using the text
     * property.
     * 6. Fill all fields and click “Submit”.
     * 7. Once submitted, validate the success message “Thanks for contacting
     * us, we will get back to you shortly.” on the screen.
     */
    public void testScenario3() {
        try {
            launchBrowser();
            seleniumPlaygroundPage.inputFormSubmit.shouldBe(Condition.visible);
            seleniumPlaygroundPage.inputFormSubmit.click();
            seleniumPlaygroundPage.submitButton.click();
            //Assert “Please fill in the fields” error message.
            softAssert.assertEquals(seleniumPlaygroundPage.name.getAttribute("validationMessage"), "Please fill out this field.", "Validation error message text does not match");
            //Fill in Name, Email, and other fields
            seleniumPlaygroundPage.name.sendKeys("Akshay");
            seleniumPlaygroundPage.email.sendKeys("Akshay@test.com");
            seleniumPlaygroundPage.password.sendKeys("test");
            seleniumPlaygroundPage.company.sendKeys("testINC");
            seleniumPlaygroundPage.website.sendKeys("www.test.com");
            seleniumPlaygroundPage.country.selectOption("United States");
            seleniumPlaygroundPage.city.sendKeys("New York");
            seleniumPlaygroundPage.address1.sendKeys("123 fremont st");
            seleniumPlaygroundPage.address1.sendKeys("123");
            seleniumPlaygroundPage.state.sendKeys("New York");
            seleniumPlaygroundPage.zip.sendKeys("94538");
            //Fill all fields and click “Submit”.
            seleniumPlaygroundPage.inputFormSubmit.click();
            //validate the success message
            softAssert.assertEquals(seleniumPlaygroundPage.hiddenMessage.getAttribute("textContent"), "Thanks for contacting us, we will get back to you shortly.", "Success message is not displayed");
        }
        catch (Exception e)
        {
            softAssert.fail();
        }
        softAssert.assertAll();
    }

    @AfterMethod
    public void closeBrowser()
    {
        Selenide.closeWindow();
    }

    @AfterClass
    public void teardown() {
        //closeWebDriver();
        Selenide.closeWebDriver();
    }

}
