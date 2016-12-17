package in.hocg;

/**
 * Created by hocgin on 16-12-16.
 */
public class ACPConfig {
	
	private final static ACPConfig ME = new ACPConfig();
	
	public static ACPConfig NEW() {
		return ME;
	}
	
	/**
	 * 获取本地爬虫存放地址
	 * @return
	 */
	public String getLocalSpiderKeepDir() {
		String classPath = ClassLoader.getSystemResource("").getPath();
		return String.format("%s%s", classPath, "ContentProvide/resources/spider/");
	}
}
