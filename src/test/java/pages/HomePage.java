package pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;


public class HomePage {
	
	private WebDriver driver;

	public HomePage() {
		this.driver=Driver.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".greeter-close")
	public WebElement popUp;
	
	@FindBy(id = "LogIn")
	public WebElement login;
	
	@FindBy(xpath = "//*[@id='login-email']")
	public WebElement username;
	
	@FindBy(name="/atg/userprofiling/ProfileFormHandler.value.password")
	public WebElement password;
	
	@FindBy(css="#login-submit")
	public WebElement loginButton;
	
	@FindBy(css = "#body > ul > li:nth-child(2) > a > span.option-title")
	public WebElement couponsIcon;
	
	@FindBy(linkText = "Select Digital Coupons")
	public WebElement digitalCoupon;
	
	@FindBy(xpath="//div[@id='ajaxCategoryDisplay']//a[contains(@class,'btn btn-xs btn-blue coupon-item-action-button js-coupon-button')]")
	public List<WebElement> availableCoupons;
	
	@FindBy(css = ".cat-load-more")
	public WebElement loadMoreButton;
	
	@FindBy(css = ".ovallon")
	public List<WebElement> allSelectButtons;
	
	@FindBy(css = ".close-window")
	public WebElement closePopUp;
	
	public void scrollDown() {
		((JavascriptExecutor)
				driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
}
