# NBA Test Automation framework for Veeva
Welcome to the Test Automation Framework repository! This repository houses a robust Test Automation framework designed to automate test cases for three NBA products: Core Product (CP), Derived Product 1 (DP1), and Derived Product 2 (DP2).

## Products:
Core Product (CP): https://www.nba.com/warriors (Referred to as CP)                                                                        
Derived Product 1 (DP1): https://www.nba.com/sixers/ (Referred to as DP1)                                                                        
Derived Product 2 (DP2): https://www.nba.com/bulls/ (Referred to as DP2)

## Tech Used:
Selenium WebDriver: For web automation.
Core Java and Gherkin: For programming.
Cucumber with TestNG: For behavior-driven development (BDD) and test execution.
Maven: For project management and dependency handling.
Log4j Logger Library: For logging test execution information.
Allure Reporting Library: For generating comprehensive test reports.

## Pre-requisite:
1. Install JDK 12 and set path
2. Install Maven and set path
3. IDE and Plugins: Maven and Cucumber
4. To start using the project you need to create your own Fork on Github and then clone the project.

## Execution steps:
1. Clone the repository.
2. Go to the cloned directory and run the following command to install dependencies and build the project:
   ```
   mvn clean install
   ```
3. Run tests with tags by updating 'cucumber.filter.tags' parameter. For example:
   ```
   mvn test -Dcucumber.filter.tags="@smoke"
   ```

## Framework structure:

![](https://github.com/BharathiKannanB/NBAAutomation/blob/main/Folder%20structure.png)

## Architecture flow diagram:

![](https://github.com/BharathiKannanB/NBAAutomation/blob/main/Execution%20flow.png)

## Contributions:
1. Fork it!
2. Create your feature branch: git checkout -b my-new-feature
3. Commit your changes: git commit -am 'Add some feature'
4. Push to the branch: git push origin my-new-feature
5. Submit a pull request :D
6. Make sure to update tests as appropriate.

