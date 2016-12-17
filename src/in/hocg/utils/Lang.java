package in.hocg.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by hocgin on 16-12-15.
 */
public class Lang {
	/**
	 * 从一个文本输入流读取所有内容，并将该流关闭
	 *
	 * @param reader
	 *            文本输入流
	 * @return 输入流所有内容
	 */
	public static String readAll(Reader reader) {
		if (!(reader instanceof BufferedReader))
			reader = new BufferedReader(reader);
		try {
			StringBuilder sb = new StringBuilder();
			
			char[] data = new char[64];
			int len;
			while (true) {
				if ((len = reader.read(data)) == -1)
					break;
				sb.append(data, 0, len);
			}
			return sb.toString();
		}
		catch (IOException e) {
			throw Lang.wrapThrow(e);
		}
		finally {
			Streams.safeClose(reader);
		}
	}
	
	/**
	 * 用运行时异常包裹抛出对象，如果抛出对象本身就是运行时异常，则直接返回。
	 * <p>
	 * 如果是 InvocationTargetException，那么将其剥离，只包裹其 TargetException
	 *
	 * @param e
	 *            抛出对象
	 * @return 运行时异常
	 */
	public static RuntimeException wrapThrow(Throwable e) {
		if (e instanceof RuntimeException)
			return (RuntimeException) e;
		if (e instanceof InvocationTargetException)
			return wrapThrow(((InvocationTargetException) e).getTargetException());
		return new RuntimeException(e);
	}
	
	public static  <T> T def(T val, T def) {
		return val == null ? def : val;
	}
}
