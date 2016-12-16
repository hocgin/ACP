import in.hocg.acp.TaskHandler;
import in.hocg.acp.bean.Result;
import in.hocg.acp.tasks.LocalJsonHexoTask;

import static in.hocg.acp.bean.Result.Classify.Hexo;

/**
 * Created by hocgin on 16-12-15.
 */
public class MainTest {
	public static TaskHandler HANDLER = new TaskHandler();
	
	@org.junit.Test
	public void hexo() throws Exception {
		HANDLER.addTask(new LocalJsonHexoTask());
		Result run = HANDLER.run(Hexo.name());
	}
}