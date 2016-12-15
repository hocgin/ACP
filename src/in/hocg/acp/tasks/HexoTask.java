package in.hocg.acp.tasks;

import in.hocg.acp.bean.Result;
import in.hocg.acp.bean.articles.Article;

import java.util.List;

import static in.hocg.acp.bean.Result.Classify.Hexo;

/**
 * Created by hocgin on 16-12-15.
 */
public class HexoTask extends BaseTask {
	@Override
	public Result.Classify getClassify() {
		return Hexo;
	}
	
	@Override
	public List<Article> exec() {
		return null;
	}
}
