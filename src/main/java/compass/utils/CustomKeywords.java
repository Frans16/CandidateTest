package compass.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomKeywords {
    private static JavascriptExecutor js;

    public static void initializeObjects() {
        WebDriver driver = HelperClass.getDriver();
        js = (JavascriptExecutor) driver;
    }
    
    public static boolean isPresent(WebElement element) {
		try {
	        return true;
	    } catch (NoSuchElementException e) {
	        return false;
	    }
    }
    
    public static void scrollToBottom() {
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }
    
    public void customclick(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click()", element);
		}
	}
}
