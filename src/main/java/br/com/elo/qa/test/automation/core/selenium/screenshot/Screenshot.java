package br.com.elo.qa.test.automation.core.selenium.screenshot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.elo.qa.test.automation.core.selenium.screenshot.impl.RunScreenshot;
import br.com.elo.qa.test.automation.core.selenium.screenshot.impl.UntilScreenShot;

public class Screenshot {
	public static byte[] take(WebDriver webDriver) {
		return new RunScreenshot().take(UntilScreenShot.screenShotWeb(webDriver));
	}
	
	public static byte[] take(WebDriver webDriver, WebElement... elements) {
		return new RunScreenshot().take(UntilScreenShot.screenShotWeb(webDriver, elements));
	}
}
