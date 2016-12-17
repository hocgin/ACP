package in.hocg.acp.analysis;

import com.google.gson.GsonBuilder;
import in.hocg.acp.bean.articles.Article;
import in.hocg.acp.processor.tmpbean.HocginSpider;
import in.hocg.utils.Files;

import java.io.File;
import java.util.List;

/**
 * Created by hocgin on 16-12-15.
 *
 * 用于解析爬虫抓取的json文件
 */
public class LocalJsonHexoHandler {
	GsonBuilder builder = new GsonBuilder();
	
	private File file;
	
	public LocalJsonHexoHandler(File file) {
		this.file = file;
	}
	
	public static LocalJsonHexoHandler load(File file) {
		return new LocalJsonHexoHandler(file);
	}
	
	public List<? extends Article> analysis() {
		String json = Files.read(file);
		HocginSpider spider = builder.create().fromJson(json, HocginSpider.class);
		// todo 进行json 转对象处理
		return spider.getArticles();
	}
}
