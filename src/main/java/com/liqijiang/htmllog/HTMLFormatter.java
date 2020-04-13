package com.liqijiang.htmllog;

import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import com.liqijiang.store.LogInfoStore;
import com.liqijiang.util.DateUtil;

public class HTMLFormatter extends Formatter {

	public String getHead(Handler h) {
		LogInfoStore.startTime = System.currentTimeMillis();
		StringBuilder sb = new StringBuilder(1000);
		sb.append("<!DOCTYPE html>\n<head><meta charset=utf-8>\n<title>测试报告</title></head>");
		sb.append("<body><div width=100%><center><h1>测试报告</h1></center></div>");
		sb.append("<div width=100%><table align=\"center\" border=\"0\" width=100%><tr>");
		sb.append("<th><b>序号</b></th>");
		sb.append("<th><b>用例描述</b></th>");
		sb.append("<th><b>期待结果</b></th>");
		sb.append("<th><b>实际结果</b></th>");
		sb.append("<th><b>执行时间</b></th>");
		sb.append("<th><b>状态</b></th></tr>");
		return sb.toString();
	}

	@Override
	public String format(LogRecord record) {
		StringBuilder sb = new StringBuilder(1000);
		LogInfoStore.result = LogInfoStore.getResult(LogInfoStore.expected, LogInfoStore.actual);
		if (LogInfoStore.result == "Pass") {
			LogInfoStore.pass += 1;
			sb.append("<tr bgcolor=green>\n<td>");
		} else {
			sb.append("<tr bgcolor=red>\n<td>");
			LogInfoStore.fail += 1;
		}
		
		sb.append(record.getSequenceNumber() + 1);
		sb.append("</td>\n<td>");
		sb.append(formatMessage(record));
		sb.append("</td>\n<td>");
		sb.append(LogInfoStore.expected.toString());
		sb.append("</td>\n<td>");
		sb.append(LogInfoStore.actual.toString());
		sb.append("</td>\n<td>");
		sb.append(DateUtil.getCalcDate(record.getMillis()));
		sb.append("</td>\n<td>");
		sb.append(LogInfoStore.result);
		sb.append("</td>\n</tr>");
		return sb.toString();
	}

	public String getTail(Handler h) {
		LogInfoStore.endTime = System.currentTimeMillis();
		int total = LogInfoStore.fail + LogInfoStore.pass;
		double percentage = (double) Math.round(LogInfoStore.pass / (double) total * 10000) / 100;
		StringBuilder sb = new StringBuilder(1000);
		sb.append("</table>");
		sb.append("<br>&nbsp;开始时间      ：");
		sb.append(DateUtil.getCalcDate(LogInfoStore.startTime));
		sb.append("<br>&nbsp;结束时间      ：");
		sb.append(DateUtil.getCalcDate(LogInfoStore.endTime));
		sb.append("<br>&nbsp;运行时间      ：");
		sb.append(DateUtil.getDeltaTime(LogInfoStore.startTime, LogInfoStore.endTime));
		sb.append("<br>&nbsp;执行用例      ：");
		sb.append(total);
		sb.append("<br>&nbsp;<font color=green>用例成功      ：");
		sb.append(LogInfoStore.pass + "</font>");
		sb.append("<br>&nbsp;<font color=Red>用例失败      ：");
		sb.append(LogInfoStore.fail + "</font>");
		sb.append("<br>&nbsp;成功率(%)  ：");
		sb.append(percentage + "%");
		sb.append("<br>&nbsp;失败率(%)  ：");
		sb.append((100 - percentage) + "%");
		sb.append("<br><br></body></html>");

		return sb.toString();

	}

}
