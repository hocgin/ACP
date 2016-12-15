package in.hocg.acp.bean.articles;

import java.util.List;

/**
 * Created by hocgin on 16-12-15.
 */
public abstract class Article {
	
	
	/**
	 * 响应结果类型
	 */
	public enum Type {
		Article,
		Link,
	}
	
	/**
	 * 虚拟主键
	 *
	 * todo - MD5(Object) or Url
	 */
	private String id;
	/**
	 * 链接
	 * eg.http://hocg.in/article?page=1
	 */
	private String url;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 描述概要
	 */
	private String describe;
	/**
	 * 主图片
	 */
	private String picture;
	
	/**
	 * 响应结果类型
	 * @see Article.Type
	 */
	private String type;
	
	/**
	 * 标记 / 分类
	 */
	private List<String> tags;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
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
	
	public String getPicture() {
		return picture;
	}
	
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public List<String> getTags() {
		return tags;
	}
	
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
}
