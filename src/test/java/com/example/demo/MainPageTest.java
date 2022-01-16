package com.example.demo;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import java.net.MalformedURLException;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;


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
            launchBrowser();
            System.out.println(WebDriverRunner.url());
            seleniumPlaygroundPage.simpleFormDemo.click();
            softAssert.assertTrue(WebDriverRunner.url().contains("simple-form-demo"), "URL does not contain the text");
            System.out.println(WebDriverRunner.url());
            String text ="Welcome to LambdaTest";
            seleniumPlaygroundPage.enterMessageTextBox.sendKeys(text);
            softAssert.assertEquals(seleniumPlaygroundPage.getCheckedCTA.getText(), "Get Checked value", "CTA button text does not match");
            seleniumPlaygroundPage.getCheckedCTA.click();
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
            launchBrowser();
            //softAssert.assertTrue(seleniumPlaygroundPage.dragAndDrop.isDisplayed(), "Drag and drop is not displayed");
            seleniumPlaygroundPage.dragAndDrop.click();
            //seleniumPlaygroundPage.dragMe.dragAndDropTo(String.valueOf(55));
            //Selenide.sleep(100);
            //Thread.sleep(100);
            //actions().()
            actions().moveToElement(seleniumPlaygroundPage.rangeSuccess).click(seleniumPlaygroundPage.dragMe).perform();
            System.out.println(seleniumPlaygroundPage.rangeSuccess.getText());

        }
        catch (Exception e)
        {
            //softAssert.fail();
        }
        //softAssert.assertAll();
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
            seleniumPlaygroundPage.inputFormSubmit.click();
            seleniumPlaygroundPage.submitButton.click();
            //FixMe: Assert “Please fill in the fields” error message.
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
            seleniumPlaygroundPage.inputFormSubmit.click();
            //Selenide.
            //Thanks for contacting us, we will get back to you
            //$(By.cssSelector(".success-msg.hidden")).shouldBe(Condition.visible, Duration.ofSeconds(30));
        }
        catch (Exception e)
        {
            //softAssert.fail();
        }
        //softAssert.assertAll();
    }

}
