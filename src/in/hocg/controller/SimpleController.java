package in.hocg.controller;

import in.hocg.ACPConfig;
import in.hocg.acp.TaskHandler;
import in.hocg.acp.bean.Result;
import in.hocg.acp.processor.HexoBlogPageProcessor;
import in.hocg.acp.tasks.LocalJsonHexoTask;
import in.hocg.utils.Lang;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by hocgin on 16-12-16.
 */
@RestController
public class SimpleController extends BaseController {
	private static Logger LOG = LoggerFactory.getLogger(SimpleController.class);
	
	/**
	 * 任务管理者
	 */
	private static TaskHandler HANDLER = new TaskHandler()
			.addTask(new LocalJsonHexoTask())
			.setListener(new TaskHandler.Listener() {
				@Override
				public void after(Result result) {
					if (result.getCode() == null) {
						if (result.getArticles() != null) {
							result.setCode(200);
							result.setMessage("success");
						} else {
							result.setCode(500);
							result.setMessage("Articles is NULL, Maybe spider occur exception");
						}
					}
				}
				
				@Override
				public void error(Result result, String message) {
					result.setCode(505);
					result.setMessage(message);
					LOG.error(message);
				}
			});
	
	@RequestMapping("/slider")
	@ResponseBody
	public Object slider() {
		Spider.create(new HexoBlogPageProcessor())
				.addUrl(HexoBlogPageProcessor.DOMAIN)
				.addPipeline(new JsonFilePipeline(ACPConfig.NEW().getLocalSpiderKeepDir()))
				.thread(5).run();
		return json_success();
	}
	
	@RequestMapping("/articles")
	@ResponseBody
	public Object articles(HttpServletRequest request) {
		String classify = Lang.def(request.getParameter("classify"), "Hexo");
		return HANDLER.run(classify);
	}

}
