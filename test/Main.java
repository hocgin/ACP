import in.hocg.acp.TaskHandler;
import in.hocg.acp.bean.Result;
import in.hocg.acp.bean.articles.Article;
import in.hocg.acp.bean.articles.DefaultArticle;
import in.hocg.acp.tasks.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hocgin on 16-12-15.
 */
public class Main {
	
	public static TaskHandler HANDLER = new TaskHandler();
	
	public static void main(String[] args) {
		HANDLER.addTask(new Task() {
			@Override
			public Result.Classify getClassify() {
				return Result.Classify.Self;
			}
			
			@Override
			public List<Article> exec() {
				ArrayList<Article> articles = new ArrayList<>();
				DefaultArticle defaultArticle = new DefaultArticle();
				defaultArticle.setUrl("http://www.baidu.com");
				System.out.println("Good");
				articles.add(defaultArticle);
				return articles;
			}
		});
		HANDLER.addTask(new Task() {
			@Override
			public Result.Classify getClassify() {
				return Result.Classify.Self;
			}
			
			@Override
			public List<Article> exec() {
				ArrayList<Article> articles = new ArrayList<>();
				DefaultArticle defaultArticle = new DefaultArticle();
				defaultArticle.setUrl("http://www.baidu.com");
				System.out.println("Good");
				articles.add(defaultArticle);
				return articles;
			}
		});
		
		HANDLER.setListener(new TaskHandler.Listener() {
			@Override
			public void after(Result result) {
				if (result.getCode() == null) {
					if (result.getArticles() != null) {
						result.setCode(200);
					} else {
						result.setCode(500);
					}
				}
			}
			
			@Override
			public void error(Result result, String message) {
				result.setCode(501);
				System.out.println(message);
			}
		});
		
		Result result = HANDLER.run(Result.Classify.All.name());
		System.out.println(result.getCode());
		result = HANDLER.run(Result.Classify.Self.name());
		System.out.println(result.getArticles().size());
	}
	
}
