Automated Testing Script for Amazon
Purpose
This script is designed to automate end-to-end testing of the Amazon website for searching products, adding them to the cart, and confirming their presence in the cart. It utilizes Selenium WebDriver for web automation and TestNG for test execution and reporting.

Prerequisites
Java Development Kit (JDK) installed
Maven build tool installed
Chrome or Firefox web browser installed
IDE (Integrated Development Environment) such as IntelliJ IDEA or Eclipse
Installation
Clone or download this repository to your local machine.
Open the project in your preferred IDE.
Configuration
Update the configuration.properties file located in src/test/resources with the desired browser (chrome or firefox), URL of the Amazon website (url), and other configurations such as implicit wait and page load timeout.
Ensure that the WebDriver binaries for Chrome and Firefox are compatible with your browser version. WebDriverManager is used to manage driver binaries dynamically, but it's recommended to have the latest browser versions for compatibility.
Test Data
Test data is stored in the testData.json file located in src/test/resources.
Update the JSON file with the desired search queries for testing.
Execution
Run the AmazonTest.java file located in src/test/java/com/Amazon/Test as a TestNG test.
Test results will be generated in the test-output directory as an Extent report.
Structure of Reusable Functions
BaseTest.java
Initializes WebDriver, ExtentReports, and other configurations before test execution.
Terminates WebDriver and flushes reports after test execution.
ConfigurationManager.java
Loads configurations from the configuration.properties file.
DriverManager.java
Initializes WebDriver based on browser type specified in the configuration.
Terminates WebDriver after test execution.
ElementHelper.java
Provides reusable functions for interacting with web elements such as finding elements, clicking, sending keys, getting text, etc.
Handles scrolling to elements and capturing screenshots on test failure.
JsonDataReader.java
Reads test data from the testData.json file.
Screenshot.java
Captures screenshots of the web page.
Other Test Classes (AmazonHomePage.java, ProductSearchPage.java, CartPage.java, CartConfirmationPage.java)
Implements test logic for specific functionalities of the Amazon website.
