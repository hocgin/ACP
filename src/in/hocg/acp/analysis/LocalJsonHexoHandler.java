package in.hocg.acp.analysis;

import in.hocg.acp.bean.articles.UrlArticle;
import in.hocg.acp.utils.Files;

import java.io.File;

/**
 * Created by hocgin on 16-12-15.
 *
 * 用于解析爬虫抓取的json文件
 */
public class LocalJsonHexoHandler {
	
	private File file;
	
	public LocalJsonHexoHandler(File file) {
		this.file = file;
	}
	
	public static LocalJsonHexoHandler load(File file) {
		return new LocalJsonHexoHandler(file);
	}
	
	public UrlArticle analysis(UrlArticle urlArticle) {
		String json = Files.read(file);
		System.out.println(json);
		// todo 进行json 转对象处理
		return urlArticle;
	}
	
	private void setFile(File file) {
		this.file = file;
	}
}
