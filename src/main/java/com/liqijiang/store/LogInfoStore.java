package com.liqijiang.store;

import com.liqijiang.util.DateUtil;

public class LogInfoStore {
	public static int pass = 0; // Pass用例的个数
	public static int fail =0; // Fail用例的个数
	public static String result = ""; // case结果
	public static Object expected = ""; // 期待值
	public static Object actual = ""; // 实际值
	public static long startTime = 0; //开始时间
	public static long endTime = 0; //结束时间
	public static String logName = "测试报告" + DateUtil.getDate() + ".html";//默认日志名称
	
	public static String getResult(Object expected,Object actual) {
		if(expected == null && actual == null) {
			LogInfoStore.actual = "";
			LogInfoStore.expected = "";
			return "Pass";
		}
		if(expected == null && actual != null) {
			LogInfoStore.expected = "";
			return "Fail";
		}
		if(expected != null && actual == null) {
			LogInfoStore.actual = "";
			return "Fail";
		}
		if(expected == "" && actual == "") {
			return "Pass";
		}
		
		if(expected.toString().equals(actual.toString())) {
			return "Pass";
		}else {
			return "Fail";
		}
	}
	
	

}
