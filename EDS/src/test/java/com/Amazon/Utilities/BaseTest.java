package com.Amazon.Utilities;

import com.Amazon.Test.AmazonTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseTest {

	public static WebDriver driver;
	Properties properties;
	protected ExtentReports report;
	public static ExtentTest logger;
	ExtentSparkReporter spark;

	public final static Logger log4j = Logger.getLogger(AmazonTest.class);

	@BeforeTest
	public void before() {
		log4j.info("Test started.");
		properties = ConfigurationManager.initializeProperties();
		driver = DriverManager.initializeDriver();
		report = new ExtentReports();
		String projectPath = System.getProperty("user.dir");
		String path = projectPath + "/test-output/ExtentReport.html";
		spark = new ExtentSparkReporter(path);
		report.attachReporter(spark);
		report.setSystemInfo("Environment", "Test");
		report.setSystemInfo("User Name", "Mohammad Umer Baig");
		report.setSystemInfo("BrowserType", ConfigurationManager.getProperties().getProperty("browser"));
		report.setSystemInfo("OS", System.getProperty("os.name"));
		spark.config().setDocumentTitle(ConfigurationManager.getProperties().getProperty("documentTitle"));
		spark.config().setReportName(ConfigurationManager.getProperties().getProperty("reportName"));
	}

	@AfterTest
	public void after() {
		DriverManager.terminateDriver();
		report.flush();
		log4j.info("Test DONE.");
	}

}
