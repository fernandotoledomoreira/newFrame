package br.com.elo.qa.test.automation.tests.beans;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import br.com.elo.qa.test.automation.core.selenium.webdriver.RemoteWebDriverCustom;

public class DriverFactory {
	private static WebDriver driver = null;

	private DriverFactory() {
	}

	public static void createWebDriver() {
		if (driver == null) {
			RemoteWebDriver driverChrome = new ChromeDriver(new ChromeOptions().addArguments("--start-maximized"));
			driver = new RemoteWebDriverCustom(driverChrome, 60);
		}
	}

	public static WebDriver getWebDriver() {
		if (driver == null) {
			RemoteWebDriver driverChrome = new ChromeDriver(new ChromeOptions().addArguments("--start-maximized"));
			driver = new RemoteWebDriverCustom(driverChrome, 60);
		}
		return driver;
	}

	public static WebDriver getWebDriver2(String device) {
		
		Map<String, String> mobileEmulation = new HashMap<>();

		mobileEmulation.put("deviceName", device);

		ChromeOptions chromeOptions = new ChromeOptions();

		if (driver == null) {
			RemoteWebDriver driverChrome = new ChromeDriver(chromeOptions.addArguments("--start-maximized").setExperimentalOption("mobileEmulation", mobileEmulation));
			driver = new RemoteWebDriverCustom(driverChrome, 60);
		}
		return driver;
	}
	
	public static Boolean isFilledWebDriver() {
		return driver != null;
	}

	public static void closeWebDriver() {
		driver.close();
		driver.quit();
		driver = null;
	}

}
