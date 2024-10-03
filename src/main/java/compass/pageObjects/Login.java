package compass.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import compass.utils.CustomKeywords;
import compass.utils.HelperClass;

public class Login extends CustomKeywords{
	
	@FindBy(xpath = "(//div[@id='login']//input[@id='email'])[1]")
	private WebElement input_email;
	
	@FindBy(xpath = "(//div[@id='login']//input[@id='password'])[1]")
	private WebElement input_password;
	
	@FindBy(xpath = "(//div[@id='login']//button/span[text()='Login'])[1]")
	private WebElement button_login;
	
	public Login() {
		PageFactory.initElements(HelperClass.getDriver(), this);
	}
	
	public void inputEmail(String email) {
		input_email.sendKeys(email);
	}
	
	public void inputPassword(String password) {
		input_password.sendKeys(password);
	}
	
	public void clickButton(String buttonType) {
		switch (buttonType) {
		case "Login":
			customclick(button_login);
			break;
		default:
			break;
		}
	}
}
