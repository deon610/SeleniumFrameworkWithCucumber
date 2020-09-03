package stepdefinition;

import java.net.MalformedURLException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import com.qa.base.BaseTest;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends BaseTest
{
	public static WebDriver driver;
	
	@Before
	public void openBrowser() throws MalformedURLException
	{
		System.out.println("Opening Browser");
		driver = initialization();
	}
	
	@After
	public void embedScreenshot(Scenario scenario)
	{
		if (scenario.isFailed())
		{
			try
			{
				byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
			} 
			catch (WebDriverException somePlatformsDontSupportScreenshots)
			{
				System.err.println(somePlatformsDontSupportScreenshots.getMessage());
			}
		}
		driver.quit();
	}

}
