# Automation on saucedemo.com

### Description
-------------
This is an Automation project for the application saucedemo and utilizes Selenium, Maven and Cucumber (BDD).

#### Requirements of the project
-------------
Java, Selenium WebDriver, Cucumber, Maven

#### Additional Information
-------------
* This project is developed by using Maven build management tool to follow a uniform template.

* The project is based on the Behavior-Driven Development(BDD) and utilizes Cucumber.

* There are three components to this BDD framework 
  1. Feature files (written in basic English)
  2. Step-definition files which essentially glue the simple English steps in the feature files to the Java code 
  3. Test Runner to run the scenarios with certain conditions.

* All the common input is written in separate file and driven into test script to reduce redudant code.

* Every element of the web page is written in separate file by using page object model and driven into the test script to have a better readability of the code.
