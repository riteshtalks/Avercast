package tripAdvisor.ritesh.helper.frameAndWindows;

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import tripAdvisor.ritesh.helper.logger.LoggerHelper;

public class FrameAndWindowHelper {
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(FrameAndWindowHelper.class);
	
	public FrameAndWindowHelper(WebDriver driver) {
		this.driver = driver;
	}
	
	public void switchToFrame(int frameIndex) {
		driver.switchTo().frame(frameIndex);
		log.info("Switched to frame: "+frameIndex);
	}
	public void switchToFrame(String frameName) {
		driver.switchTo().frame(frameName);
		log.info("Switched to frame: "+frameName);
	}
	public void switchToFrame(WebElement element) {
		driver.switchTo().frame(element);
		log.info("Switched to frame: "+element.toString());
	}
	
	public void swithToParentWindow() {
		driver.switchTo().defaultContent();
		log.info("Swithed to parent windows");
	}
	
	public void swithToWindow(int index) {
		Set<String> windows = driver.getWindowHandles();
		int i = 1;
		for(String window : windows) {
			if(i == index) {
				driver.switchTo().window(window);
			}else {
				i++;
			}
		}
		
		log.info("Swithed windows");
	}
	public void CloseAllTabsAndSwithcToParentWindow() {
		Set<String> windows = driver.getWindowHandles();
		String mainWindow = driver.getWindowHandle();

		for(String window : windows) {
			if(!window.equalsIgnoreCase(mainWindow)) {
				driver.close();
			}
		}
		driver.switchTo().window(mainWindow);
		
		log.info("Swithed to Parent windows and closed rest tabs");
	}
	 

}
