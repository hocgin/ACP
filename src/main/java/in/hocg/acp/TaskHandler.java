package in.hocg.acp;

import in.hocg.acp.bean.articles.Article;
import in.hocg.acp.bean.Result;
import in.hocg.acp.tasks.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by hocgin on 16-12-15.
 */
public class TaskHandler {
	
	private static List<Task> TASKS = new ArrayList<>();
	private Listener listener;
	
	/**
	 * 添加运行任务
	 * @param task
	 * @return
	 */
	public TaskHandler addTask(Task task) {
		TASKS.add(task);
		return this;
	}
	
	/**
	 * 移除指定动作的运行任务
	 * @param classify
	 * @return
	 */
	public TaskHandler removeTask(String classify) {
		for (Task task : TASKS) {
			if (Objects.equals(task.getClassify().name(), classify)) {
				TASKS.remove(task);
			}
		}
		return this;
	}
	
	/**
	 * 执行指定运行任务
	 * @param classify
	 * @return
	 */
	public Result run(String classify) {
		Result result = new Result();
		result.setClassify(classify);
		
		boolean invalidClassify = true;
		for (Task task : TASKS) {
			if (Objects.equals(task.getClassify().name(), classify)) {
				invalidClassify = false;
				List<? extends Article> articleCollection = task.exec();
				if (articleCollection != null) {
					result.addArticle(articleCollection);
				}
			}
		}
		// 回调处理
		if (listener != null){
			if (invalidClassify) {
				listener.error(result, String.format("Sorry, Not found task for classify[%s]", classify));
			}
			listener.after(result);
		}
		return result;
	}
	
	public TaskHandler setListener(Listener listener) {
		this.listener = listener;
		return this;
	}
	
	/**
	 * 回调处理任务结果
	 */
	public interface Listener {
		void after(Result result);
		
		void error(Result result, String message);
	}
}
