package in.hocg.acp.tasks;

import in.hocg.acp.ACPConfig;
import in.hocg.acp.analysis.LocalJsonHexoHandler;
import in.hocg.acp.bean.Result;
import in.hocg.acp.bean.articles.Article;
import in.hocg.acp.bean.articles.UrlArticle;

import java.io.File;
import java.util.List;

import static in.hocg.acp.processor.HexoBlogPageProcessor.DOMAIN_DIR;

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
	public List<Article> exec() {
		String jsonPath = String.format("%s%s", ACPConfig.NEW().getLocalSpiderKeepDir(), DOMAIN_DIR);
		File jsonDir = new File(jsonPath);
		if (jsonDir.isDirectory()) {
			String[] list = jsonDir.list();
			LocalJsonHexoHandler handler;
			UrlArticle urlArticle;
			if (list != null) {
				for (String aList : list) {
					String jsonFilePath = String.format("%s/%s", jsonPath, aList);
					// todo json 转化对象处理
					handler = LocalJsonHexoHandler.load(new File(jsonFilePath));
					urlArticle = new UrlArticle();
					handler.analysis(urlArticle);
				}
			}
		}
		return null;
	}
}
