package in.hocg.acp.tasks;

import in.hocg.acp.bean.articles.Article;
import in.hocg.acp.bean.Result.Classify;

import java.util.List;

/**
 * Created by hocgin on 16-12-15.
 */
public interface Task {
	
	/**
	 * 指定处理类型
	 * @return
	 */
	Classify getClassify();
	
	/**
	 * 处理
	 * @return
	 */
	List<Article> exec();
}
