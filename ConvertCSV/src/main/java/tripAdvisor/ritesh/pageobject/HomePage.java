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
	
	@FindBy(id="f1")
	WebElement selectCSV;
	
	@FindBy(xpath="//*[@id=\"fn\"]")
	WebElement saveYourResultTextBox;
	
	@FindBy(xpath="//*[@id=\"dataTable\"]/div[1]/div[1]/div[1]/table/tbody/tr[1]/td[1]")
	WebElement column;
	
	
	@FindBy(xpath="//*[@id=\"frm1\"]/div[4]/input")
	WebElement download;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElementClickable(selectCSV, ObjectReader.reader.getExplicitWait());
	}
	
	public void uploadCsvFile(String text) {
		log.info("Uploading CSV File");
		selectCSV.sendKeys(text);
		waitHelper.setImplicitWait(40, TimeUnit.SECONDS);
	}
	
	public void saveYourResultTextBox(String str) {
		waitHelper.waitForElementClickable(saveYourResultTextBox, ObjectReader.reader.getExplicitWait());
		System.out.println("ABCD: "+saveYourResultTextBox.getText());
		saveYourResultTextBox.sendKeys(str);
		waitHelper.setImplicitWait(ObjectReader.reader.getImplicitWait(), TimeUnit.SECONDS);
		log.info("FileRenamed");
	}
	
	public void updateCloumn(String utext) {
		column.clear();
		waitHelper.setImplicitWait(ObjectReader.reader.getImplicitWait(), TimeUnit.SECONDS);
		column.sendKeys(utext);
		waitHelper.setImplicitWait(ObjectReader.reader.getImplicitWait(), TimeUnit.SECONDS);
		log.info("Column Updated");
	}
	
	public void clickDownlod() {
		download.click();
		log.info("File Downloaded");
	}
	
	
	
}
