package tripAdvisor.ritesh.helper.logger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import tripAdvisor.ritesh.helper.resource.ResourceHelper;

public class LoggerHelper {
	private static boolean root = false;
	
	public static Logger getLogger(Class cls) {
		if(root) {
			return Logger.getLogger(cls);
		}
		PropertyConfigurator.configure(ResourceHelper.getResourcepath("/src/main/resources/configfile/log4j.properties"));
		root = true;
		return LoggerHelper.getLogger(cls);		
	}
}
