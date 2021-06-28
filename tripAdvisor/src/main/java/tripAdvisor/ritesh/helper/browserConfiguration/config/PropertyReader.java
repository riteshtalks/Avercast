package tripAdvisor.ritesh.helper.browserConfiguration.config;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


import tripAdvisor.ritesh.helper.browserConfiguration.BrowserType;
import tripAdvisor.ritesh.helper.resource.ResourceHelper;

public class PropertyReader implements ConfigReader {
	private static FileInputStream file;
	public static Properties OR;

	public PropertyReader() {
		String filePath = ResourceHelper.getResourcepath("/src/main/resources/configfile/config.properties");
		try {
			file = new FileInputStream(new File(filePath));
			OR = new Properties();
			OR.load(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getImplicitWait() {
		return Integer.parseInt(OR.getProperty("implicitwait"));
	}

	public int getExplicitWait() {
		return Integer.parseInt(OR.getProperty("explicitwait"));
	}

	public int getPageLoadTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	public BrowserType getBrowserType() {
		return BrowserType.valueOf(OR.getProperty("browserType"));
	}
	
	public String getUrl() {
		return OR.getProperty("trpApplicatioUrl");
	}

}
