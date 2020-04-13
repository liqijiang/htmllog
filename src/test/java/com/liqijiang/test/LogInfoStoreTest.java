package com.liqijiang.test;

import org.junit.Test;

import com.liqijiang.store.LogInfoStore;

public class LogInfoStoreTest {

	
	@Test
	public void test1() {
		System.out.println(LogInfoStore.getResult(1,2));
	}
	
	@Test
	public void test2() {
		
		System.out.println(LogInfoStore.getResult(1,1));
	}
	
	@Test
	public void test3() {
		System.out.println(LogInfoStore.getResult(null,""));
	}
	
	@Test
	public void test4() {
		System.out.println(LogInfoStore.getResult(null,null));
	}
	
	@Test
	public void test5() {
		System.out.println(LogInfoStore.getResult("",""));
	}

}
