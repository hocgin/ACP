package in.hocg.acp.processor;

import in.hocg.acp.bean.articles.Article;
import in.hocg.acp.bean.articles.UrlArticle;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import javax.management.JMException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hocgin on 16-12-16.
 * http://hocg.in/ 爬虫器
 */
public class HexoBlogPageProcessor implements PageProcessor {
	
	/**
	 * 爬抓域名起点
	 */
	public final static String DOMAIN = "http://hocg.in";
	/**
	 * 存储目录名
	 */
	public final static String DOMAIN_DIR = "hocg.in";
	
	private Site site = Site.me().setRetryTimes(3).setSleepTime(100);
	
	public static void main(String[] args) throws JMException {
		Spider.create(new HexoBlogPageProcessor())
				.addUrl(DOMAIN)
				.addPipeline(new JsonFilePipeline("/home/hocgin/Documents/Project/Sync/ContentProvide/resources/spider/"))
				.thread(5).run();
	}
	
	@Override
	public void process(Page page) {
		List<UrlArticle> articles = new ArrayList<>();
		Html html = page.getHtml();
		page.addTargetRequests(html.$(".pagination .next").links().all());
		List<Selectable> posts = html.$(".post").nodes();
		UrlArticle article;
		for (Selectable post : posts) {
			String url = post.$(".post-title-link").links().get();
			String title = post.$(".post-title-link").xpath("//a/text()").get();
			String describe = post.xpath("//div[@class='post-body']/p/text()").get();
			describe = describe == null ? post.xpath("//div[@class='post-body']/text()").get() : describe;
			String category = post.xpath("//span[@class='post-category']/span[@itemprop='about']/a/span[@itemprop='name']/text()").get();
			/**
			 * @see in.hocg.acp.bean.articles.UrlArticle
			 */
			article = new UrlArticle();
			article.setTitle(title.trim());
			article.setUrl(url.trim());
			article.setDescribe(describe.trim());
			article.setType(Article.Type.Link.name());
			article.setPicture("None");
			article.setTags(category.trim());
			article.setId(article.generate());
			articles.add(article);
		}
		System.out.println(String.format("Article Len(%d)", articles.size()));
		page.putField("articles", articles);
	}
	
	@Override
	public Site getSite() {
		return site;
	}
}
