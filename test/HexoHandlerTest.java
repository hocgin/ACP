import in.hocg.acp.analysis.HexoHandler;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by hocgin on 16-12-15.
 */
public class HexoHandlerTest {
	
	public HexoHandler hexoHandler = new HexoHandler(new File(String.format("/home/hocgin/Documents/NutzStore/Nutstore/toolBox/Green-for-nodejs/hocgin.github.io/source/_posts/%s.md",
			"hexo-功能扩展")));
	
	@Test
	public void analysisTest() {
		try {
			hexoHandler.analysis();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
