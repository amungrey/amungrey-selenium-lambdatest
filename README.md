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

Tests run parallel(2 instances and additional tests will be queued) as shown in screenshot below 

<img width="1638" alt="Screen Shot 2022-01-17 at 8 15 53 AM" src="https://user-images.githubusercontent.com/12905847/149805296-fc06eb3e-a67a-45ea-9738-edb23699ee3e.png">

<img width="1622" alt="Screen Shot 2022-01-17 at 8 05 32 AM" src="https://user-images.githubusercontent.com/12905847/149805315-41f979cb-4e35-4177-a257-df3fdb3de64a.png">


## To run the tests locally

To run the tests locally, use the browser: You can select CHROME or FIREFOX as option and pass driverType as local.

```bash
mvn test -Dbrowser=FIREFOX -DdriverType=local -Dsurefire.suiteXmlFiles=src/test/java/testSuite/LambdaTest.xml

```



