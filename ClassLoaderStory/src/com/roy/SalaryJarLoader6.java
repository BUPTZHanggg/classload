package com.roy;

import java.io.InputStream;
import java.net.URL;
import java.security.SecureClassLoader;

import com.sun.xml.internal.ws.util.ByteArrayBuffer;

public class SalaryJarLoader6  extends SecureClassLoader{
	// 用一个jar包来模拟整个工程
		private String jarFile;

		public SalaryJarLoader6(String jarFile) {
			this.jarFile = jarFile;
		}

		@Override
		protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
			if(name.startsWith("com.roy")) {
				return this.findClass(name);
			}
			return super.loadClass(name,resolve);
		}

		@Override
		protected Class<?> findClass(String name) throws ClassNotFoundException {
			System.out.println("重新加载类：" + name);
//			String filePath = this.classPath + name.replace(".","\\").concat(".myclass");
			String classPath = name.replace(".", "/").concat(".class");
			InputStream inputStram;
			URL fileUrl;
			ByteArrayBuffer ba = new ByteArrayBuffer();
			byte[] b;
			int code;
			try {
				fileUrl = new URL("jar:file:\\" + this.jarFile + "!/" + classPath);
				inputStram = fileUrl.openStream();

				while ((code = inputStram.read()) != -1) {
					ba.write(code);
				}
				b = ba.toByteArray();
				return this.defineClass(name, b, 0, b.length);
			} catch (Exception e) {
//				throw new ClassNotFoundException("自定义类文件不存在");
				System.out.println("文件正在复制过程中，下次读取时生效。");
				return null;
			}
		}
}
