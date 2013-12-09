package com.james.utils;

import java.util.Date;


public class TestThread {

	public static void main(String[] args) {
		long begin = System.currentTimeMillis();
		testThreadGroup();
//		testRuntime();
		long end = System.currentTimeMillis();
		System.out.println(end - begin);
		
	}

	private static void testRuntime() {
		System.out.println("Runtime.getRuntime().availableProcessors(): " + Runtime.getRuntime().availableProcessors());
		System.out.println("Runtime.getRuntime().freeMemory(): " + (Runtime.getRuntime().freeMemory())/1024/1024/8.0+"GB");
		System.out.println("Runtime.getRuntime().maxMemory(): " + (Runtime.getRuntime().maxMemory())/1024/1024/8.0+"GB");
		System.out.println("Runtime.getRuntime().totalMemory(): " + (Runtime.getRuntime().totalMemory())/1024/1024/8.0+"GB");
	}

	private static void testThreadGroup() {
		ThreadGroup threadGroup1 = new ThreadGroup("threadGroup1");
		threadGroup1.setMaxPriority(Thread.MAX_PRIORITY);
		ThreadGroup threadGroup2 = new ThreadGroup(threadGroup1, "threadGroup2");
		threadGroup2.setMaxPriority(Thread.MIN_PRIORITY);
		ThreadGroup threadGroup3 = new ThreadGroup(threadGroup2, "threadGroup3");
		threadGroup3.setMaxPriority(Thread.NORM_PRIORITY);
		new Thread(threadGroup1, (Runnable) new TestThread1(2000, "a1")).start();
		new Thread(threadGroup1, new TestThread1(2000, "a2")).start();
		new Thread(threadGroup2, new TestThread1(2000, "b1")).start();
		new Thread(threadGroup2, new TestThread1(2000, "b2")).start();
		new Thread(threadGroup3, new TestThread1(2000, "c1")).start();
		new Thread(threadGroup3, new TestThread1(2000, "c2")).start();
		new Thread(threadGroup3, new TestThread1(2000, "c3")).start();
		System.out.println("threadGroup1.activeCount(): "+threadGroup1.activeCount());
		System.out.println("threadGroup2.activeCount(): "+threadGroup2.activeCount());
		System.out.println("threadGroup3.activeCount(): "+threadGroup3.activeCount());
		System.out.println("threadGroup1.activeGroupCount(): "+threadGroup1.activeGroupCount());
		System.out.println("threadGroup2.activeGroupCount(): "+threadGroup2.activeGroupCount());
		System.out.println("threadGroup3.activeGroupCount(): "+threadGroup3.activeGroupCount());
		System.out.println("threadGroup1.getMaxPriority(): "+threadGroup1.getMaxPriority());
		System.out.println("threadGroup2.getMaxPriority(): "+threadGroup2.getMaxPriority());
		System.out.println("threadGroup3.getMaxPriority(): "+threadGroup3.getMaxPriority());
		System.out.println("threadGroup1.getName(): "+threadGroup1.getName());
		System.out.println("threadGroup2.getName(): "+threadGroup2.getName());
		System.out.println("threadGroup3.getName(): "+threadGroup3.getName());
	}
}


class TestThread1 implements Runnable{

	private int time;
	private String name;
	
	public TestThread1(int time, String name) {
		this.time = time;
		this.name = name;
	}

	@Override
	public void run() {
		while (true) {
			try {
				System.out.println(name +" 休息 " + time + "ms " + new Date());
				Thread.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}