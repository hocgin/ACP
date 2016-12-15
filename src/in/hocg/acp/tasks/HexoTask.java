package in.hocg.acp.tasks;

import in.hocg.acp.analysis.HexoHandler;
import in.hocg.acp.bean.Result;
import in.hocg.acp.bean.articles.Article;
import in.hocg.acp.bean.articles.DefaultArticle;

import java.io.File;
import java.io.IOException;
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
		String _postPath = "/home/hocgin/Documents/NutzStore/Nutstore/toolBox/Green-for-nodejs/hocgin.github.io/source/_posts";
		File _postDir = new File(_postPath);
		if (_postDir.isDirectory()) {
			String[] list = _postDir.list();
			HexoHandler handler = new HexoHandler();
			if (list != null) {
				for (String aList : list) {
					String mdFilePath = String.format("%s/%s", _postPath, aList);
					handler.load(new File(mdFilePath));
					try {
						DefaultArticle article = handler.analysis(new DefaultArticle());
						article.setSyntax(DefaultArticle.Syntax.Markdown.name());
						article.setFrom("http://hocg.in/");
						article.setAuthor("hocgin");
						article.generate();
						articles().add(article);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return articles();
	}
}
