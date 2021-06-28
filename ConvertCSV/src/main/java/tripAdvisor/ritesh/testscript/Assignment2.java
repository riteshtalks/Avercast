package tripAdvisor.ritesh.testscript;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import tripAdvisor.ritesh.helper.browserConfiguration.config.ObjectReader;
import tripAdvisor.ritesh.helper.logger.LoggerHelper;
import tripAdvisor.ritesh.helper.resource.ResourceHelper;
import tripAdvisor.ritesh.pageobject.HomePage;
import tripAdvisor.ritesh.testbase.TestBase;

public class Assignment2 extends TestBase{
	private final Logger log = LoggerHelper.getLogger(Assignment2.class);
	
	@Test(description="Search and write review")
	public void testSearch() {
		log.info("Starting Test");
		getApplicationUrl(ObjectReader.reader.getUrl());
		HomePage homePage = new HomePage(driver);		
		String filePath = ResourceHelper.getResourcepath("/src/main/resources/configfile/file.csv");
		
		homePage.uploadCsvFile(filePath);
		homePage.saveYourResultTextBox("Renamed");
		homePage.clickDownlod();
		
	}
}
