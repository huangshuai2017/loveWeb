package com.pactera.spring.thread.synchronizers;

import java.util.concurrent.CountDownLatch;
/**
 * 计数下降拴
 * 实现原理是AQS，AQS基于CAS
 * @author Administrator
 *
 */
public class TestCountDownLatch {

	
	public static void main(String[] args) {
        int count = 5;
		//准备线程完成之后工作线程开始工作
		//工作线程完成之后结尾线程开始工作
		CountDownLatch initLatch  = new CountDownLatch(1);
		CountDownLatch workLatch  = new CountDownLatch(count);
		new Thread(new PrepareWorker(initLatch)).start();
		for(int i=0;i<count;i++) {
			new Thread(new Worker(initLatch,workLatch)).start();
		}
		new Thread(new AfterWorker(workLatch)).start();
	}

}
class Worker implements Runnable{

	private  CountDownLatch initLatch;
	private  CountDownLatch workLatch;

	public Worker(CountDownLatch initLatch, CountDownLatch workLatch) {
		super();
		this.initLatch = initLatch;
		this.workLatch = workLatch;
	}


	@Override
	public void run() {
		try {
			initLatch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("working...");
		workLatch.countDown();
	}
	
}
class PrepareWorker implements Runnable{
	private  CountDownLatch initLatch;
	
	public PrepareWorker(CountDownLatch initLatch) {
		super();
		this.initLatch = initLatch;
	}

	@Override
	public void run() {
		System.out.println("PrepareWorker working...");
		initLatch.countDown();
	}
	
}

class AfterWorker implements Runnable{
	private  CountDownLatch workLatch;
	
	public AfterWorker(CountDownLatch workLatch) {
		super();
		this.workLatch = workLatch;
	}

	@Override
	public void run() {
		try {
			workLatch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("AfterWorker working...");
	}
	
}