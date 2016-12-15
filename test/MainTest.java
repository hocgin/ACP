import in.hocg.acp.TaskHandler;
import in.hocg.acp.tasks.HexoTask;

import static in.hocg.acp.bean.Result.Classify.Hexo;

/**
 * Created by hocgin on 16-12-15.
 */
public class MainTest {
	public static TaskHandler HANDLER = new TaskHandler();
	
	@org.junit.Test
	public void hexo() throws Exception {
		HANDLER.addTask(new HexoTask());
		HANDLER.run(Hexo.name());
	}
	
}