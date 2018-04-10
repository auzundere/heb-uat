package step_definitions;

import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pages.HomePage;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;

public class HebTest {

	HomePage homePage = new HomePage();

	@Given("^The user is on HEB home page$")
	public void the_user_is_on_HEB_home_page() throws Throwable {
	
	}

	@When("^I should click on Login link$")
	public void i_should_click_on_Login_link() throws Throwable {
		homePage.login.click();
	}

	@When("^I should enter my username, password and click Log in button$")
	public void i_should_enter_my_username_password_and_click_Log_in_button() throws Throwable {
//		Assert.assertTrue(Driver.getInstance().findElement(By.id("reg-login")).isDisplayed());
		BrowserUtils.waitFor(2);
		homePage.username.sendKeys(ConfigurationReader.getProperty("username"));
		homePage.password.sendKeys(ConfigurationReader.getProperty("password"));
		homePage.loginButton.click();
	}

	@When("^I should click on Digital Coupons$")
	public void i_should_click_on_Digital_Coupons() throws Throwable {
		homePage.couponsIcon.click();
		homePage.digitalCoupon.click();
		homePage.scrollDown();
		BrowserUtils.waitFor(15);
	}

	@When("^I should click on all Select buttons$")
	public void i_should_click_on_all_Select_buttons() throws Throwable {
		int numberOfCoupons=0;
		int totalCoupons = homePage.availableCoupons.size();
		
		for (int i=0; i<totalCoupons;i++) {
			homePage.availableCoupons.get(i).click();
				//Thread.sleep(200);
				numberOfCoupons++;
			}
		
//		System.out.println("Number of available coupons: "+homePage.availableCoupons.getText());
		System.out.println(numberOfCoupons+" coupons selected");
	}
}
