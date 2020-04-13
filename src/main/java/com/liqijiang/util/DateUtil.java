package com.liqijiang.util;

import java.text.SimpleDateFormat;
import java.util.Date;


public class DateUtil {
	public static String getCalcDate(long millisecs) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		Date resultdate = new Date(millisecs);
		return dateFormat.format(resultdate);
	}
	public static String getDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyyMMddHHmmss");
		Date resultdate = new Date();
		return dateFormat.format(resultdate);
	}
	
	public static String getDeltaTime(long p_startTime, long p_endTime) {
		long day = (p_endTime - p_startTime) / (24 * 60 * 60 * 1000);
		long hour = ((p_endTime - p_startTime) / (60 * 60 * 1000) - day * 24);
		long min = (((p_endTime - p_startTime) / (60 * 1000)) - day * 24 * 60 - hour * 60);
		long s = ((p_endTime - p_startTime) / 1000 - day * 24 * 60 * 60 - hour
				* 60 * 60 - min * 60);
		return day + "天" + hour + "小时" + min + "分" + s + "秒";
	}

}
