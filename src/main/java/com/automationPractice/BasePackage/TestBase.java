package com.automationPractice.BasePackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;

	public static Properties prop;
	// using which we can load configuration file, read data from the file

	public FileInputStream configFile;
	// file in which all configuration related data is stored in key-value

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

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		// Load the Page
		driver.get(prop.getProperty("URL"));
	}
	
	public void tearDown() {
		driver.quit();
	}
}
