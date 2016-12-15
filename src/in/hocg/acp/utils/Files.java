package in.hocg.acp.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by hocgin on 16-12-15.
 */
public class Files {
	
	/**
	 * 读取 UTF-8 文件全部内容
	 *
	 * @param f
	 *            文件
	 * @return 文件内容
	 */
	public static String read(File f) {
		try {
			return Lang.readAll(new FileReader(f));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return "";
	}
}
