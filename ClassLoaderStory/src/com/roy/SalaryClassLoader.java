package com.roy;

import java.io.FileInputStream;
import java.security.SecureClassLoader;

import com.sun.xml.internal.ws.util.ByteArrayBuffer;

public class SalaryClassLoader extends SecureClassLoader{

	private final String classPath;
	public SalaryClassLoader(String classPath) {
		this.classPath = classPath;
	}
	
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		String filePath = this.classPath + name.replace(".","\\").concat(".myclass");
		FileInputStream fis;
		ByteArrayBuffer ba = new ByteArrayBuffer();
		byte[] b;
		int code;
		try {
			fis = new FileInputStream(filePath);
			int header = fis.read();
			while((code = fis.read()) != -1) {
				ba.write(code);
			}
			b = ba.toByteArray();
			return this.defineClass(name, b, 0, b.length);
		}catch(Exception e) {
			throw new ClassNotFoundException("文件不存在");
		}
	}
	
}
