package in.hocg;

import in.hocg.acp.processor.HexoBlogPageProcessor;
import in.hocg.utils.Lang;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by hocgin on 16-12-16.
 */
@SpringBootApplication
public class App {
	public static void main(String[] args) throws Exception {
		if (args.length > 0) {
			HexoBlogPageProcessor.DOMAIN = Lang.def(args[0], "http://hocg.in");
		}
		SpringApplication.run(App.class, args);
	}
}
