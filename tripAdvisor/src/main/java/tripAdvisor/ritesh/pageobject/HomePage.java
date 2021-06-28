package tripAdvisor.ritesh.pageobject;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tripAdvisor.ritesh.helper.browserConfiguration.config.ObjectReader;
import tripAdvisor.ritesh.helper.logger.LoggerHelper;
import tripAdvisor.ritesh.helper.wait.WaitHelper;

public class HomePage {
	
	private WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(HomePage.class);
	
	public WaitHelper waitHelper;
	
	@FindBy(xpath="//*[@id=\"lithium-root\"]/main/div[3]/div/div/div[2]/form/input[1]")
	WebElement searchBox;
	
	@FindBy(xpath="//div[contains(@class, 'DrjyGw-P') and contains(@class, '_1SRa-qNz _2AAjjcx8') and  text() = 'Ticlo Resorts Goa']")
	WebElement firstSearchResult;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElementClickable(searchBox, ObjectReader.reader.getExplicitWait());
	}
	
	public void enterTextInSearchBox(String text) {
		log.info("Entering the text in searchBox..");
		searchBox.sendKeys(text);
		waitHelper.setImplicitWait(ObjectReader.reader.getImplicitWait(), TimeUnit.SECONDS);
	}
	public FirstResultPage clickOnFirstResult() {
		firstSearchResult.click();
		log.info("Clicked first result from searchbox");
		return new FirstResultPage(driver);
	}

}
