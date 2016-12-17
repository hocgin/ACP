package in.hocg.acp.tasks;

import in.hocg.acp.bean.Result;
import in.hocg.acp.bean.articles.Article;

import java.util.List;

/**
 * Created by hocgin on 16-12-15.
 * 推荐文章 任务
 */
public class RecommendTask extends BaseTask {
	@Override
	public Result.Classify getClassify() {
		return Result.Classify.Recommend;
	}
	
	@Override
	public List<Article> exec() {
		// 推荐文章模板
		return null;
	}
}
