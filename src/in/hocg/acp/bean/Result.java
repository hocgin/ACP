package in.hocg.acp.bean;

import in.hocg.acp.bean.articles.Article;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hocgin on 16-12-15.
 */
public class Result {
	
	/**
	 * 请求类型 => 处理器类型
	 */
	public enum Classify {
		All,
		Self,
		Recommend,
		Hexo
	}
	
	/**
	 * 响应码
	 */
	private Integer code;
	/**
	 * 请求类型 => 处理器类型
	 * @see in.hocg.acp.bean.Result.Classify
	 */
	private String classify;
	/**
	 * 文章列表
	 * - List 正常数据
	 * - empty List 有数据,但数据为空
	 * - Null 无数据
	 */
	private List<? super Article> articles;
	
	public Integer getCode() {
		return code;
	}
	
	public void setCode(int code) {
		this.code = code;
	}
	
	public String getClassify() {
		return classify;
	}
	
	public void setClassify(String classify) {
		this.classify = classify;
	}
	
	public List<? super Article> getArticles() {
		return articles;
	}
	
	public void setArticles(List<? super Article> articles) {
		this.articles = articles;
	}
	
	public Result addArticle(List<Article> articleCollection) {
		if (getArticles() == null) {
			setArticles(new ArrayList<>());
		}
		getArticles().addAll(articleCollection);
		return this;
	}
}
