package tripAdvisor.ritesh.helper.resource;

public class ResourceHelper {

	public static String getResourcepath(String path) {
		String basePath = System.getProperty("user.dir");
		return basePath + path;
	}
}
