package com.automationPractice.BasePackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import com.automationPractice.Logger.WebdriverEvents;
import com.automationPractice.util.Utils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;

	public static Properties prop;
	// using which we can load configuration file, read data from the file

	public FileInputStream configFile;
	// file in which all configuration related data is stored in key-value

	public static Logger logger;
	// declaring Logger reference variable

	public EventFiringWebDriver e_driver;
	public WebdriverEvents eventListener;

	public static JavascriptExecutor jse;

	public TestBase() {
		prop = new Properties(); // instantiating Properties class
		try {

			configFile = new FileInputStream(
					"C:\\Users\\VINOD\\eclipse-workspace\\FrameworkAutomationPractice\\src\\main\\java\\com\\automationPractice\\config\\configuration.properties");
			prop.load(configFile);

		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}

	@BeforeMethod
	public void setupLogger() {

		// instantiating Logger
		logger = Logger.getLogger(TestBase.class);

		// Configuring
		PropertyConfigurator.configure("log4j.properties");
		BasicConfigurator.configure();

		logger.setLevel(Level.INFO);
	}

	public void intialiseDriver() {

		String browserName = prop.getProperty("browser");

		switch (browserName) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "Edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Not a valid Browser");
			break;
		}

		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebdriverEvents();
		e_driver.register(eventListener);
		driver = e_driver;

		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Utils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		// Load the Page
		driver.get(prop.getProperty("URL"));
	}

	public void tearDown() {
		driver.quit();
	}

	public void waitForDocumentReadyState(int timeOutInSeconds) {
		new WebDriverWait(driver, timeOutInSeconds).until((ExpectedCondition<Boolean>) v -> {
			logger.info("Verifying page has loaded.......");
			jse = (JavascriptExecutor) driver;
			String documentIsReady = jse.executeScript("return document.readyState").toString();
			// returns 3 values -- complete, loading, or null

			while (true) {
				if (documentIsReady.equalsIgnoreCase("complete")) {
					logger.info("Page has loaded completely......");
					return true;
				} else {
					return false;
				} 
			}
		});
	}
}
