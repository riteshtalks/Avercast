package tripAdvisor.ritesh.helper.browserConfiguration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import tripAdvisor.ritesh.helper.resource.ResourceHelper;

public class ChromeBrowser {
	
	public ChromeOptions getChromeOptions() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--test-type");
		options.addArguments("--disable-popup-blocking");
		
		DesiredCapabilities chrome = DesiredCapabilities.chrome();
		chrome.setJavascriptEnabled(true);
		
		options.setCapability(ChromeOptions.CAPABILITY,chrome);
		//Linux
		if(System.getProperty("os.name").contains("Linux")) {
			options.addArguments("--headless","wind-size=1024,768","--no-sandbox");
		}
		return options;		
	}
	
	public WebDriver getChromeDriver(ChromeOptions cap) {
		if(System.getProperty("os.name").contains("Window")) {
			System.setProperty("webdriver.chrome.driver",ResourceHelper.getResourcepath("/chromedriver.exe"));
			return new ChromeDriver(cap);
		}else if(System.getProperty("os.name").contains("Mac")) {
			//to be implemented...........
			System.setProperty("webdriver.chrome.driver",ResourceHelper.getResourcepath("/chromedriver.bin"));
			return new ChromeDriver(cap);
		}else if(System.getProperty("os.name").contains("Linux")) {
			//to be implemented...........
			System.setProperty("webdriver.chrome.driver",ResourceHelper.getResourcepath("/chromedriver.bin"));
			return new ChromeDriver(cap);
		}else {
			return null;
		}		
		
	}

}
