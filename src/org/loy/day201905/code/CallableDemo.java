package org.loy.day201905.code;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class CallableDemo {
	/***
	 * ʹ���߳̽���callable����
	 */
	public static void callableByThread() throws Exception {
		Callable<String> cInfoA = new Callable<String>() {
			@Override
			public String call() throws Exception {
				return "loy callable";
			}
		};
		
		FutureTask<String> futureTask = new FutureTask<>(cInfoA);
		
		new Thread(futureTask).start();
		System.out.println(futureTask.get());
	}
	
	/***
	 * ʹ���̳߳ؽ���callable����
	 */
	public static void callableByThreadPool() throws Exception {
		Callable<String> cInfoA = new Callable<String>() {
			@Override
			public String call() throws Exception {
				return "loy callable";
			}
		};
		
		FutureTask<String> futureTask = new FutureTask<>(cInfoA);
		
		ExecutorService executeTask = Executors.newFixedThreadPool(10);
		executeTask.submit(cInfoA);
		System.out.println(futureTask.get());
	}
	
	
	public static void main(String[] args) throws Exception {
		callableByThread();
	}
}
