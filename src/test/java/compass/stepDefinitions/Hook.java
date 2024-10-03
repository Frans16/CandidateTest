package compass.stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import compass.utils.CustomKeywords;
import compass.utils.HelperClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hook {
	@Before
	public static void setup(Scenario scenario) {
		HelperClass.setUpDriver();
		System.out.println("");
		System.out.println("Scenario Name: "+scenario.getName());
		System.out.println("========================================");
		CustomKeywords.initializeObjects();
	}
	
	@AfterStep
	public static void takeScreenshoot(Scenario scenario) {
		if (scenario.isFailed()) {
	        HelperClass.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        final byte[] screenshots = ((TakesScreenshot) HelperClass.getDriver()).getScreenshotAs(OutputType.BYTES);
	        scenario.attach(screenshots, "image/png", "Failure Screenshot");
	    }
	}
	
	@After
	public static void tearDown() {
		HelperClass.tearDown();
	}
}
