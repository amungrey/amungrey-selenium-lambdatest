# amungrey-selenium-lambdatest
- maven
- testNG
- Selenide
- Allure reports
- Lambdatest



## Installation

To install all the dependencies .

```bash
mvn install
```


## To run the tests

To run the tests on Lambdatest infrastructure, use the userName and authKey that Lambdatest provides once you register to their platform, and pass driverType as remote.
- Platform can be **Windows 8** or **MacOS Monterey**, refer: https://www.lambdatest.com/capabilities-generator/ to generate the capability
- browser can be **CHROME** or **FIREFOX**
- selenide options are mandatory since we use the selenide library

```bash
mvn verify -Dusername=<userName> -DauthKey=<authKey> -Dbrowser=FIREFOX -DdriverType=remote  "-Dplatform=MacOS Monterey" -Dselenide.remote=https://<username>:<authkey>@hub.lambdatest.com/wd/hub -Dselenide.browserSize=1024x900 -Dselenide.browser=FIREFOX
	
```

## To run the tests locally

To run the tests locally, use the browser: You can select CHROME or FIREFOX as option and pass driverType as local.

```bash
mvn test -Dbrowser=FIREFOX -DdriverType=local -Dsurefire.suiteXmlFiles=src/test/java/testSuite/LambdaTest.xml

```



