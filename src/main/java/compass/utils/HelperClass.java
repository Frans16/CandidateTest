package compass.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HelperClass {
	private static HelperClass helperClass;
	
	private static WebDriver driver;
	
	private HelperClass() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		//options.addArguments("--headless");
		options.addArguments("--start-maximized");
		options.addArguments("--window-size=1920,1080");
		
		driver = new ChromeDriver(options);
 		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public static void openPage(String url) {
        driver.get(url);
    }
           
    public static WebDriver getDriver() {
        return driver;              
    }
       
    public static void setUpDriver() {
           
        if (helperClass==null) {
               
            helperClass = new HelperClass();
        }
    }
       
    public static void tearDown() {
    	
        if(driver!=null) {
             driver.close();
             driver.quit();
        }
            
       helperClass = null;
   }
}
