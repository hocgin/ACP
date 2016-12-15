package in.hocg.acp.tasks;

import in.hocg.acp.bean.articles.Article;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hocgin on 16-12-15.
 */
public abstract class BaseTask implements Task {
	private List<Article> articles = new ArrayList<>();
	
	public List<Article> articles() {
		return articles;
	}
}
