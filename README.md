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

To run the tests on Lambdatest infrastructure, use the userName and accessKey that Lambdatest and pass driverType as remote.

```bash
mvn verify -Dusername=<username_of_lambatest> -DauthKey=<authKey> -Dbrowser=chrome -DdriverType=remote
	
```

## To run the tests locally

To run the tests locally, use the browser: You can select CHROME or FIREFOX as option and pass driverType as local.

```bash
mvn verify -Dbrowser=FIREFOX -DdriverType=local

```