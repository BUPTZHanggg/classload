package com.roy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileChangeTest {

	public static void main(String[] args) throws Exception {
		File file = new File("E:\\workspace-eclipse2\\SalaryCaler\\bin\\com\\roy\\SalaryCaler.class");
		FileInputStream fis = new FileInputStream(file);
		
		File targetFile = new File("D:\\lib\\SalaryCaler.myclass");
		FileOutputStream fos = new FileOutputStream(targetFile);
		
		int code = 1;
		fos.write(code);
		
		while((code = fis.read())!=-1) {
			fos.write(code);
		}
		
		fis.close();
		fos.close();
		System.out.println("文件加密完成");
	}
}
