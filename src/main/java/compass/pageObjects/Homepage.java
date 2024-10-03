package compass.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import compass.utils.CustomKeywords;
import compass.utils.HelperClass;

public class Homepage extends CustomKeywords{
	
	@FindBy(xpath = "//div[@class='modal-content ']")
	private WebElement div_modal;
	
	@FindBy(xpath = "//div[@class='close']")
	private WebElement div_close;
	
	@FindBy(xpath = "//a[@href='/login' and contains(@class,'account-button')]")
	private WebElement a_profile;
	
	@FindBy(xpath = "//div[@class='cover-body']")
	private WebElement div_cover;
	
	public Homepage() {
		PageFactory.initElements(HelperClass.getDriver(), this);
	}
	
	public void checkModal() {
		if(isPresent(div_modal) == true) {
			div_close.click();
		}else {
			System.out.println("No modal");
		}
	}
	
	public void enterProfile() {
		scrollToBottom();
		customclick(a_profile);
	}
	
	public void verifyHomepage() {
		isPresent(div_cover);
	}
}	
