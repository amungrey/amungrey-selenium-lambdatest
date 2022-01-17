package com.example.demo;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Browsers.FIREFOX;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import org.testng.annotations.Parameters;
public class BaseTest {
     SeleniumPlaygroundPage seleniumPlaygroundPage = new SeleniumPlaygroundPage();
    SoftAssert softAssert = new SoftAssert();

    /**
     * Sets up the configuration and makes the Remote call
     * @throws MalformedURLException
     */

    @Parameters({ "browserName", "Chrome" })
    public static void setUpAll() throws MalformedURLException {
        //String username = "mungreyakshay";
        String username = System.getProperty("username");
        String authKey = System.getProperty("authKey");
        String browser=System.getProperty("browser");
        String driverType=System.getProperty("driverType"); //local or remote
        String platform="MacOS Catalina";
        //String platform=System.getProperty("platform");
        //String authkey = "n1249r85iLkL6fgV9CfDweN4ANch5zE6Eu5m1A8Q2Bjn46aV7z";
        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", platform);
        caps.setCapability("browserName", browser);
        caps.setCapability("version", "latest");
        caps.setCapability("build", "TestNG With Java and Lambdatest");
        caps.setCapability("name", "First test");
        caps.setCapability("plugin", "git-testng");
        caps.setCapability("network",true);

        String[] Tags = new String[] { "Feature", "Falcon", "Severe" };
        caps.setCapability("tags", Tags);

        if (driverType.equalsIgnoreCase("remote")) {
            RemoteWebDriver driver = new RemoteWebDriver(new URL("https://" + username + ":" + authKey + hub), caps);

            //uncomment me when running on LambdaTest
            WebDriverRunner.setWebDriver(driver);
        }
        else
        {
            if (browser.equalsIgnoreCase(FIREFOX)) {
                WebDriverManager.firefoxdriver().setup();
                WebDriver driver = new FirefoxDriver();
                WebDriverRunner.setWebDriver(driver);
            }
            else if (browser.equalsIgnoreCase(CHROME)) {
                WebDriverManager.chromedriver().setup();
                WebDriver driver = new ChromeDriver();
                WebDriverRunner.setWebDriver(driver);
            }

        }

        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());

    }

    /**
     * Launches the browser and navigates to the URL
     */
    public void launchBrowser() {
        open("https://www.lambdatest.com/selenium-playground/");
        System.out.println("Title Shows" + Selenide.title());
    }


}
