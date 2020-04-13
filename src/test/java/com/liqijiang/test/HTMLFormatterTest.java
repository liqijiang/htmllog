package com.liqijiang.test;


import java.util.logging.FileHandler;
import java.util.logging.Logger;
import org.junit.Test;
import com.liqijiang.htmllog.HTMLFormatter;
import com.liqijiang.store.LogInfoStore;

public class HTMLFormatterTest {
//	public static void main(String[] args) {
//		Logger log = Logger.
//	}
	Logger log = Logger.getLogger("test");
	
	@Test
	public void test1() throws Exception {
		FileHandler fh = new FileHandler("D:\\testlogml0.html");
		fh.setFormatter(new HTMLFormatter());
		log.addHandler(fh);
		LogInfoStore.expected = 123;
		LogInfoStore.actual = 123;
		log.info("info");
		LogInfoStore.expected = 123;
		LogInfoStore.actual = "123";
		log.severe("severe");
		LogInfoStore.expected = 123;
		LogInfoStore.actual = "123";
		log.severe("severe");
		LogInfoStore.expected = 123;
		LogInfoStore.actual = "1234";
		log.severe("severe");
		LogInfoStore.expected = 123;
		LogInfoStore.actual = "";
		log.severe("severe");
		LogInfoStore.expected = "";
		LogInfoStore.actual = "";
		log.severe("severe");
		LogInfoStore.expected = "";
		LogInfoStore.actual = "1234";
		log.severe("severe");
		LogInfoStore.expected = null;
		LogInfoStore.actual = "1234";
		log.severe("severe");
		LogInfoStore.expected = "123";
		LogInfoStore.actual = null;
		log.severe("severe");
		LogInfoStore.expected = null;
		LogInfoStore.actual = null;
		log.severe("severe");
		fh.close();
	}

}
