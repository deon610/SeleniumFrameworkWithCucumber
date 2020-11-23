package stepdefinition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.openqa.selenium.WebDriver;

import com.qa.base.BaseTest;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.utility.PropertyUtility;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SauceDemoLoginStep extends BaseTest
{

	public WebDriver driver;

	public SauceDemoLoginStep()
	{
		driver = Hooks.driver;
	}

	LoginPage lp = new LoginPage();
	HomePage hp = new HomePage();

	@Given("^User has navigated to application$")
	public void user_has_navigated_to_application()
	{
		driver.get(PropertyUtility.getProperty("url"));
	}

	@When("^Login to the application$")
	public void enter_the_correct_username_and_password()
	{
		lp.login(PropertyUtility.getProperty("username"), PropertyUtility.getProperty("password"));
	}

	@Then("^Verify the title is '(.*)'$")
	public void verify_the_title(String title)
	{
		String actualText = hp.verifyTitle(title);
		assertEquals(actualText, title);
	}

	@Then("^Add product to the cart$")
	public void add_product_to_the_cart()
	{
		hp.addProductToCart();
	}

	@Then("^Logout of the application$")
	public void logout_of_the_application() throws Throwable
	{
		hp.logout();
	}

	@When("^Login to the application with wrong credentials$")
	public void loginToTheApplicationWithWrongCredentials()
	{
		Random random = new Random();
		String username = "user" + random.nextInt();
		String password = "password" + random.nextInt();
		lp.login(username, password);
	}

	@Then("^Verify user cannot login$")
	public void verifyUserCantLogin() throws Throwable
	{
		String expected = "Username and password do not match any user in this service";
		String actual = lp.loginErrorMessage();
		assertTrue(actual.contains(expected));
	}

}
