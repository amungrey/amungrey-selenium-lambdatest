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
- Platform can be **Windows 8** or **MacOS Catalina**
- browser can be **CHROME** or **FIREFOX**
- Use threadCount(optional) if you want to run the test methods in parallel

```bash
mvn test -Dusername=<username_of_lambatest> -DauthKey=<authKey> -Dbrowser=CHROME -DdriverType=remote  "-Dplatform=Windows 8"
-Dsurefire.suiteXmlFiles=src/test/java/testSuite/LambdaTest.xml -DthreadCount=2
	
```

## To run the tests locally

To run the tests locally, use the browser: You can select CHROME or FIREFOX as option and pass driverType as local.

```bash
mvn test -Dbrowser=FIREFOX -DdriverType=local -Dsurefire.suiteXmlFiles=src/test/java/testSuite/LambdaTest.xml

```



