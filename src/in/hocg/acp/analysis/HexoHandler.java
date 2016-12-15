package in.hocg.acp.analysis;

import in.hocg.acp.bean.articles.DefaultArticle;
import in.hocg.acp.utils.Files;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hocgin on 16-12-15.
 */
public class HexoHandler {
	
	private File file;
	
	private String title;
	private String describe;
	private String date;
	private String body;
	private List<String> tags;
	
	public HexoHandler() {
	}
	
	public HexoHandler(File file) {
		load(file);
	}
	
	public HexoHandler load(File file) {
		setFile(file);
		return this;
	}
	
	/**
	 * 解析
	 * @throws IOException
	 */
	public void analysis() throws IOException {
		String text = Files.read(getFile());
		String[] ts = text.split("<!--more-->", 2);
		String[] scope = ts[0].split("-{4,}\n", 3);
		String[] result = scope[1].split("\n");
		String more = ts.length == 2 ? scope[2] : "";
		more = more.length() == 0 ? description(result) : more;
		String body = ts.length == 2? ts[1]: text.replaceFirst("^-{3,}(.|\\n)+?-{3,}", "");
		
		tags = tags(result);
		tags.addAll(categories(result));
		this.body = body;
		this.title = title(result);
		this.date = date(result);
		this.describe = more;
	}
	
	public DefaultArticle analysis(DefaultArticle defaultArticle) throws IOException {
		this.analysis();
		defaultArticle.setTags(getTags());
		defaultArticle.setBody(getBody());
		defaultArticle.setTitle(getTitle());
		defaultArticle.setCreateAt(getDate());
		defaultArticle.setDescribe(getDescribe());
		return defaultArticle;
	}
	
	/**
	 * 解析标题
	 * @param result
	 * @return
	 */
	private String title(String[] result) {
		for (String s : result) {
			if (s.contains("title:")) {
				return s.trim().replace("title:", "").trim();
			}
		}
		return null;
	}
	
	/**
	 * 解析时间
	 * @param result
	 * @return
	 */
	private String date(String[] result) {
		for (String s : result) {
			if (s.contains("date:")) {
				return s.trim().replace("date:", "").trim();
			}
		}
		return null;
	}
	
	/**
	 * 解析标签
	 * @param result
	 * @return
	 */
	private List<String> tags(String[] result) {
		List<String> tags = new ArrayList<>();
		for (int i = 0; i < result.length; i++) {
			if (result[i].contains("tags:")) {
				for (i++; i < result.length; i++) {
					if (result[i].contains(":")) {
						break;
					}
					tags.add(result[i].trim().replace("-", "#"));
				}
				break;
			}
		}
		return tags;
	}
	
	/**
	 * 解析分类
	 * @param result
	 * @return
	 */
	private List<String> categories(String[] result) {
		List<String> categories = new ArrayList<>();
		for (int i = 0; i < result.length; i++) {
			if (result[i].contains("categories:")) {
				for (i++; i < result.length; i++) {
					if (result[i].contains(":")) {
						break;
					}
					categories.add(result[i].trim().replace("-", "#"));
				}
				break;
			}
		}
		return categories;
	}
	
	/**
	 * more
	 * @param result
	 * @return
	 */
	private String description(String[] result) {
		for (String s : result) {
			if (s.contains("description:")) {
				return s.trim().replace("description:", "").trim();
			}
		}
		return null;
	}
	
	public File getFile() {
		return file;
	}
	
	public void setFile(File file) {
		this.file = file;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescribe() {
		return describe;
	}
	
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getBody() {
		return body;
	}
	
	public void setBody(String body) {
		this.body = body;
	}
	
	public List<String> getTags() {
		return tags;
	}
	
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
}
