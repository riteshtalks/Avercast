package tripAdvisor.ritesh.testscript;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import tripAdvisor.ritesh.helper.browserConfiguration.config.ObjectReader;
import tripAdvisor.ritesh.helper.frameAndWindows.FrameAndWindowHelper;
import tripAdvisor.ritesh.helper.logger.LoggerHelper;
import tripAdvisor.ritesh.pageobject.FirstResultPage;
import tripAdvisor.ritesh.pageobject.HomePage;
import tripAdvisor.ritesh.pageobject.WriteReviewPage;
import tripAdvisor.ritesh.testbase.TestBase;

public class Assignment1 extends TestBase{
	private final Logger log = LoggerHelper.getLogger(Assignment1.class);
	
	@Test(description="Search and write review")
	public void testSearch() {
		getApplicationUrl(ObjectReader.reader.getUrl());
		HomePage homePage = new HomePage(driver);
		homePage.enterTextInSearchBox("Goa Resorts");
		homePage.clickOnFirstResult();
		
		FirstResultPage firstResultPage = new FirstResultPage(driver);
		firstResultPage.clickOnWriteReviewButton();
		
		FrameAndWindowHelper swith = new FrameAndWindowHelper(driver);
		swith.swithToWindow(1);
		log.info("Switched windows..");
		
		WriteReviewPage writeReviewPage = new WriteReviewPage(driver);
		writeReviewPage.hover();
		writeReviewPage.enterTitle();
		writeReviewPage.enterText();
		writeReviewPage.clickOnSortOfTrip();
		writeReviewPage.selectDateOfTravel();
		writeReviewPage.clickCheckBox();
		writeReviewPage.clickSubmitButton();
	}
}
