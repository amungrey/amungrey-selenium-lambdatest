package com.example.demo;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;
import java.net.URL;
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
        String username = System.getProperty("username");
        String authKey = System.getProperty("authKey");
        String browser=System.getProperty("browser");
        String driverType=System.getProperty("driverType"); //local or remote
        String platform=System.getProperty("platform");
        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", platform);
        caps.setCapability("browserName", browser);
        caps.setCapability("version", "latest");
        caps.setCapability("build", "Lambdatest Exam");
        caps.setCapability("name", "SubmissionTest-FF");
        caps.setCapability("plugin", "git-testng");
        caps.setCapability("network",true);
        caps.setCapability("visual",true);
        caps.setCapability("systemLog", true);
        caps.setCapability("commandLog", true);
        caps.setCapability("video",true);
        caps.setCapability("console", true); // To capture console logs

        String[] Tags = new String[] { "Feature", "Falcon", "Severe" };
        caps.setCapability("tags", Tags);
        System.out.println(caps);

        if (driverType.equalsIgnoreCase("remote")) {
            RemoteWebDriver driver = new RemoteWebDriver(new URL("https://" + username + ":" + authKey + hub), caps);
            System.out.println("https://" + username + ":" + authKey + hub);
            WebDriverRunner.setWebDriver(driver);

        }

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
