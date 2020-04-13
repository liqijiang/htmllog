package com.liqijiang.test;


import org.junit.Test;
import com.liqijiang.htmllog.HTMLLogEntry;

public class HTMLLogEntryTest {
	
	@Test
	public void test1() {
		HTMLLogEntry.write("test1", "", "");
	}
	@Test
	public void test2() {
		HTMLLogEntry.write("test2", "", null);
	}
	@Test
	public void test3() {
		HTMLLogEntry.write("test3", null, "");
	}
	@Test
	public void test4() {
		HTMLLogEntry.write("test4", null, null);
	}
	@Test
	public void test5() {
		HTMLLogEntry.write("test5", "123", "123");
	}
	
	@Test
	public void test6() {
		HTMLLogEntry.write("test6", 123, "123");
	}
	
	@Test
	public void test7() {
		HTMLLogEntry.write("test7", "1234", "123");
	}
	@Test
	public void test8() {
		HTMLLogEntry.write("test8", "", "123");
	}
	@Test
	public void test9() {
		HTMLLogEntry.write("test9", "123", "");
	}
	@Test
	public void test10() {
		HTMLLogEntry.write("test10", null, "123");
	}
	@Test
	public void test11() {
		HTMLLogEntry.write("test11", "123", null);
	}
	
//	@After
//	public void test12() {
//		HTMLLogEntry.colse();
//	}

}
