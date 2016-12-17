package in.hocg.acp.tasks;

import in.hocg.ACPConfig;
import in.hocg.acp.analysis.LocalJsonHexoHandler;
import in.hocg.acp.bean.Result;
import in.hocg.acp.bean.articles.Article;
import in.hocg.acp.processor.HexoBlogPageProcessor;

import java.io.File;
import java.util.List;

/**
 * Created by hocgin on 16-12-16.
 * GitHub 解析Hexo任务
 */
public class LocalJsonHexoTask extends BaseTask {
	
	@Override
	public Result.Classify getClassify() {
		return Result.Classify.Hexo;
	}
	
	@Override
	public List<? extends Article> exec() {
		String jsonPath = String.format("%s%s", ACPConfig.NEW().getLocalSpiderKeepDir(), HexoBlogPageProcessor.DOMAIN_DIR);
		File jsonDir = new File(jsonPath);
		if (jsonDir.isDirectory()) {
			File[] list = jsonDir.listFiles();
			if (list != null && list.length != 0) {
				for (File aList : list) {
					articles().addAll(LocalJsonHexoHandler.load(aList).analysis());
				}
			}
		}
		return articles();
	}
}
