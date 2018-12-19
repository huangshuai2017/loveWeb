package com.pactera.spring.thread.synchronizers;

import java.util.concurrent.Exchanger;
/**
 * 测试交换器
 * 用于匹配的两个线程间进行数据交换，在遗传算法和管道设计应用上可能有用
 * 1.创建 调用空的构造函数Exchanger 指定下交换的数据格式泛型
 * 2.exchange(T t)调用方法交换数据，如果没有线程的数据在等待交换，则该线程处于等待状态
 *   如果已有线程等待数据交换，则交换数据，也就说一般我们需要创建使用交换器的线程是偶数个，
 *   否则会出现一只阻塞的状态
 * @author Administrator
 * 基于CAS原理实现的
 */
public class TestExchanger {

	public static void main(String[] args) {
		Exchanger<String> exchanger = new Exchanger<>();
		new Thread(()->{
			System.out.println("exchager thread 1 ...");
			try {
				String exchangeStr = exchanger.exchange("love");
				System.out.println("1 result:" + exchangeStr);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
		new Thread(()->{
			System.out.println("exchager thread 2 ...");
			try {
				String exchangeStr = exchanger.exchange("beloved");
				System.out.println("2 result:" + exchangeStr);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();
		new Thread(()->{
			System.out.println("exchager thread 3 ...");
			try {
				String exchangeStr = exchanger.exchange("头love ");
				System.out.println("3 result:" + exchangeStr);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();
//		new Thread(()->{
//			System.out.println("exchager thread 4 ...");
//			try {
//				String exchangeStr = exchanger.exchange("头love 2");
//				System.out.println("4 result:" + exchangeStr);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}).start();
	}

}
