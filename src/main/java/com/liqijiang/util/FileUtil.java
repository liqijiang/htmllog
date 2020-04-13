package com.liqijiang.util;

import java.io.File;

public class FileUtil {
	public static int getFileCount(String fileName) {
		int count = 0;
		for(String s : new File(new File(fileName).getAbsolutePath()).getParentFile().list()) {
			if(s.equals(new File(fileName).getName())) {
				count++;
			}
		}
		return count;
	}
	

}
