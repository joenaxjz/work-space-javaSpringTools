package com.demo.helpers;

import java.util.UUID;
// file dùng để phát xin tên file upload ngẫu nhiên
public class FileHelper {

	public static String generateFileName(String fileName) {
		int lastIndex = fileName.lastIndexOf(".");
		String ext = fileName.substring(lastIndex);
		return UUID.randomUUID().toString().replace("-", "") + ext;
	}
}
