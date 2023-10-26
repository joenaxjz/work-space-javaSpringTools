package com.demo.helpers;

import java.util.UUID;
// file dùng để phát xin tên file upload ngẫu nhiên
public class RandomHelper {

	public static String random() {
		return UUID.randomUUID().toString().replace("-","");
	}
}
