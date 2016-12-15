package in.hocg.acp.utils;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by hocgin on 16-12-15.
 */
public class Streams {
	/**
	 * 关闭一个可关闭对象，可以接受 null。如果成功关闭，返回 true，发生异常 返回 false
	 *
	 * @param cb
	 *            可关闭对象
	 * @return 是否成功关闭
	 */
	public static boolean safeClose(Closeable cb) {
		if (null != cb)
			try {
				cb.close();
			}
			catch (IOException e) {
				return false;
			}
		return true;
	}
}
