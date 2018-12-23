package com.pactera.spring.thread.methods;
/**
 * 学习线程相关的知识
 * stop suspend resume 三个方法被废弃
 *                     stop被废弃，原因是不安全
 *                     suspend被废弃，原因是易于产生死锁
 *                     resume被废弃，原因同上，两者是相对而生的；suspend是挂起目前线程
 *                                 resume是将目前线程恢复
 * interrupt 打断线程     1. 只有线程自己能打断自己，别人打断自己的时候会抛出安全异常;
 *                   2.当目标线程处于阻塞状态：object的wait() ,thread的join()和sleep()方法
 *                   3.时该线程的打断状态将会被清除并抛出一个InterruptedException
 *                   
 *  join             将当前线程加入到父线程中，等该线程运行结束后父线程方可继续运行。
 *                   如果中间被打断可以抛出InterruptedException
 *  sleep    当前执行的线程睡眠指定时间，时间到了后线程恢复到可运行状态
 *           如果时间未到被打断，则抛出InterruptedException
 *           睡眠期间不释放监控器的拥有权，也就是不释放对象锁
 * @author Administrator
 *
 */
public class TestThread {

	public static void main(String[] args) {
		Thread thread = new Thread(()->{System.out.println("kkk");
		try {
			System.out.println("lllll");
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		}
		
				);
		thread.start();
		thread.interrupt();
	}

}
