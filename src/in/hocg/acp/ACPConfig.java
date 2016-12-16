package in.hocg.acp;

/**
 * Created by hocgin on 16-12-16.
 */
public class ACPConfig {
	
	private final static ACPConfig ME = new ACPConfig();
	
	public static ACPConfig NEW() {
		return ME;
	}
	
	/**
	 * 获取本地hexo _post 目录地址
	 * @return
	 */
	public String getLocalHexoDir() {
		return "/home/hocgin/Documents/NutzStore/Nutstore/toolBox/Green-for-nodejs/hocgin.github.io/source/_posts";
	}
	
	/**
	 * 获取本地爬虫存放地址
	 * @return
	 */
	public String getLocalSpiderKeepDir() {
		return "/home/hocgin/Documents/Project/Sync/ContentProvide/resources/spider/";
	}
}
