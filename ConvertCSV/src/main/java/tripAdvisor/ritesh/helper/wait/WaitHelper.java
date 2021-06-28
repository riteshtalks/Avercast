package tripAdvisor.ritesh.helper.wait;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import tripAdvisor.ritesh.helper.logger.LoggerHelper;

public class WaitHelper {
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(LoggerHelper.class);
	
	public WaitHelper(WebDriver driver) {
		this.driver = driver;
		log.info("WaitHelper object is created..");
	}
	
	public void setImplicitWait(long timepout, TimeUnit unit) {
		log.info("Implicit wait has been set to: "+timepout+" "+unit);
		driver.manage().timeouts().implicitlyWait(timepout, unit);		
	}
	
	@SuppressWarnings("deprecation")
	private WebDriverWait getWait(int timeOutInSeconds, TimeUnit pollingInterval ) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.pollingEvery(timeOutInSeconds, pollingInterval);
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(ElementNotSelectableException.class);
		wait.ignoring(ElementNotInteractableException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchFrameException.class);
		return wait;		
	}
	
	public void waitForElementVisibleWithPollingTime(WebElement element, int timeoutInSeconds, TimeUnit pollingInterval) {
		log.info("Waiting for elements: "+element.toString()+" for : "+timeoutInSeconds+" seconds");
		WebDriverWait wait = getWait(timeoutInSeconds, pollingInterval);
		wait.until(ExpectedConditions.invisibilityOf(element));
		log.info("Element is visible now");
	}
	public void waitForElementClickable(WebElement element, int timeoutInSeconds) {
		log.info("Waiting for elements: "+element.toString()+" for : "+timeoutInSeconds+" seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable((element)));
		log.info("Element is visible now");
	}	
}
