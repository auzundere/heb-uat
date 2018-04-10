package step_definitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import utilities.ConfigurationReader;
import utilities.Driver;

public class Hooks {
	@Before
	public void beforeScenario(Scenario scenario) {
		WebDriver driver = Driver.getDriver();
		driver.get(ConfigurationReader.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//driver.manage().window().maximize();
		//driver.manage().window().fullscreen();
		driver.switchTo().window(driver.getWindowHandle());
		System.out.println("Before the Scenario started");
	}

	@After
	public void afterScenario(Scenario scenario) throws InterruptedException {
		//System.out.println("After the Scenario ended");
		//taking a screenshot
		if(scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) 
			Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
			//adding the screenshot to the report
			scenario.embed(screenshot, "image/png");
		}
		Thread.sleep(2000);
		Driver.closeDriver();
	}
}