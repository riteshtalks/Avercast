package tripAdvisor.ritesh.pageobject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tripAdvisor.ritesh.helper.browserConfiguration.config.ObjectReader;
import tripAdvisor.ritesh.helper.logger.LoggerHelper;
import tripAdvisor.ritesh.helper.wait.WaitHelper;

public class FirstResultPage {
	
	private WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(FirstResultPage.class);
	
	public WaitHelper waitHelper;
	
	@FindBy(xpath="//*[@id=\"COMMUNITYCONTENT\"]/div/div[2]/div/div[1]/a")
	WebElement writeAReview;
	
	public FirstResultPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElementClickable(writeAReview, ObjectReader.reader.getExplicitWait());
	}
	
	public void clickOnWriteReviewButton() {
		writeAReview.click();
		log.info("Navigate to other page..");
	}

}
