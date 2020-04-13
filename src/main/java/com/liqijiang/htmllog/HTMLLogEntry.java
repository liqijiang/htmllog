package com.liqijiang.htmllog;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import com.liqijiang.store.LogInfoStore;

public class HTMLLogEntry {
	private static Logger log;
	private static FileHandler fh = null;
	private HTMLLogEntry() {
		
	}
	
	static{
		log = Logger.getLogger("HTMLLogEntry.class");
		
		try {
			fh = new FileHandler(LogInfoStore.logName);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fh.setFormatter(new HTMLFormatter());
		log.addHandler(fh);
	}
	
	public static void write(String describe,Object expected,Object actual) {
		LogInfoStore.actual = actual;
		LogInfoStore.expected = expected;
		log.info(describe);
		LogInfoStore.actual = "";
		LogInfoStore.expected = "";
	}
	
	public static void colse() {
		if(fh != null) {
			fh.close();
		}
	}

}
