package tripAdvisor.ritesh.pageobject;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import tripAdvisor.ritesh.helper.browserConfiguration.config.ObjectReader;
import tripAdvisor.ritesh.helper.logger.LoggerHelper;
import tripAdvisor.ritesh.helper.wait.WaitHelper;

public class WriteReviewPage {
	private WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(WriteReviewPage.class);
	
	public WaitHelper waitHelper;
	
	@FindBy(xpath="//*[@id=\"bubble_rating\"]")
	WebElement clickToRate;
	
	@FindBy(xpath="//*[@id=\"overallRatingFlagText\"]")
	WebElement overallRatingFlagText;
	
	@FindBy(name="ReviewTitle")
	WebElement reviewTitle;
	
	@FindBy(name="ReviewText")
	WebElement reviewText;
	
	@FindBy(xpath="//div[contains(text(),'Solo')]")
	WebElement sortOfTrip;
	
	@FindBy(name="trip_date_month_year")
	WebElement selectDate;
	
	@FindBy(name="noFraud")
	WebElement checkBox;
	
	@FindBy(id="SUBMIT")
	WebElement submitButton;
	
	public WriteReviewPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElementClickable(clickToRate, ObjectReader.reader.getExplicitWait());
	}
	
	//Will implement dedicated method for this
	
	String javaScript = "var evObj = document.createEvent('MouseEvents');" +
            "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);" +
            "arguments[0].dispatchEvent(evObj);";
	
	public void hover() {
		((JavascriptExecutor)driver).executeScript(javaScript, clickToRate);
		
		//clickToRate.setAttribute("value", "your value");
		
		((JavascriptExecutor)driver).executeScript(javaScript, overallRatingFlagText);
	}
	
	public void enterTitle() {
		reviewTitle.sendKeys("This is for testing");
		log.info("Review Title entered");
	}
	
	public void enterText() {
		reviewText.sendKeys("This is review text. This is review text. This is review text. This is review text. This is review text. This is review text. This is review text. This is review text. This is review text. This is review text.");
		log.info("Review text entered");
	}
	
	public void clickOnSortOfTrip() {
		sortOfTrip.click();
		log.info("Solo is selected as sort of trip..");
	}
	
	public void selectDateOfTravel() {
		//Will implemet seperate select method for it, later..
		Select drpDate = new Select(selectDate);
		drpDate.selectByVisibleText("June 2021");
		log.info("Date selected as June 2021..");
	}
	
	public void clickCheckBox() {
		checkBox.click();
		log.info("Clicked on check box..");
	}
	
	public void clickSubmitButton() {
		submitButton.click();
		log.info("Clicked on Submit button..");
	}
	
	

}
