package tripAdvisor.ritesh.testbase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;

import tripAdvisor.ritesh.helper.browserConfiguration.BrowserType;
import tripAdvisor.ritesh.helper.browserConfiguration.ChromeBrowser;
import tripAdvisor.ritesh.helper.browserConfiguration.config.ObjectReader;
import tripAdvisor.ritesh.helper.browserConfiguration.config.PropertyReader;
import tripAdvisor.ritesh.helper.logger.LoggerHelper;
import tripAdvisor.ritesh.helper.wait.WaitHelper;

public class TestBase {

	public WebDriver driver;
	private Logger log = LoggerHelper.getLogger(TestBase.class);

	public WebDriver getBrowserTypeObject(BrowserType btype) throws Exception {
		try {

			switch (btype) {
			case Chrome:
				ChromeBrowser chrome;
				chrome = ChromeBrowser.class.newInstance();
				ChromeOptions option = chrome.getChromeOptions();
				return chrome.getChromeDriver(option);
				
			case FireFox:
				// will implement later.
				// break;

			case IExplorer:
				// will implement later.
				// break;

			default:
				throw new Exception("Driver not found");
			}

		} catch (Exception e) {
			log.info(e.getMessage());
			throw e;
		}
	}
	
	@BeforeTest
	public void beforeTest() throws Exception {
		ObjectReader.reader = new PropertyReader();
		setupDriver(ObjectReader.reader.getBrowserType());
	}
	
	public void setupDriver(BrowserType btype) throws Exception {
		driver = getBrowserTypeObject(btype);
		log.info("Initialize WebDriver: "+driver.hashCode());
		WaitHelper wait = new WaitHelper(driver);
		wait.setImplicitWait(ObjectReader.reader.getImplicitWait(),TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	public void getApplicationUrl(String url) {
		driver.get(url);
	}
	
	

}
