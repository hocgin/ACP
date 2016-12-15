package in.hocg.acp.bean.articles;

import java.util.List;

/**
 * Created by hocgin on 16-12-15.
 * 文本文章
 */
public class DefaultArticle extends Article {
	
	/**
	 * 语法 [markdown/html]
	 */
	public enum Syntax {
		Markdown,
		Html
	}
	/**
	 * 语法
	 * @see DefaultArticle.Syntax
	 */
	private String syntax;
	/**
	 * 来源
	 */
	private String from;
	/**
	 * 作者
	 */
	private String author;
	/**
	 * 正文
	 */
	private String body;
	/**
	 * 创建时间
	 */
	private String createAt;
	/**
	 * 热度
	 */
	private String hot;
	/**
	 * 其他描述
	 */
	private String other;
	/**
	 * 标记 / 分类
	 */
	private List<String> tags;
	
	public String getSyntax() {
		return syntax;
	}
	
	public void setSyntax(String syntax) {
		this.syntax = syntax;
	}
	
	public String getFrom() {
		return from;
	}
	
	public void setFrom(String from) {
		this.from = from;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getBody() {
		return body;
	}
	
	public void setBody(String body) {
		this.body = body;
	}
	
	public String getCreateAt() {
		return createAt;
	}
	
	public void setCreateAt(String createAt) {
		this.createAt = createAt;
	}
	
	public String getHot() {
		return hot;
	}
	
	public void setHot(String hot) {
		this.hot = hot;
	}
	
	public String getOther() {
		return other;
	}
	
	public void setOther(String other) {
		this.other = other;
	}
	
	public List<String> getTags() {
		return tags;
	}
	
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
}
