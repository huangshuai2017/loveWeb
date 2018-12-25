package com.pactera.spring.thread.methods;

import java.util.Date;
import java.util.Vector;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 学习线程相关的知识
 * stop suspend resume 三个方法被废弃
 * stop被废弃，原因是不安全
 * suspend被废弃，原因是易于产生死锁
 * resume被废弃，原因同上，两者是相对而生的；suspend是挂起目前线程
 * resume是将目前线程恢复
 * interrupt 打断线程     1. 只有线程自己能打断自己，别人打断自己的时候会抛出安全异常;
 * 2.当目标线程处于阻塞状态：object的wait() ,thread的join()和sleep()方法
 * 3.时该线程的打断状态将会被清除并抛出一个InterruptedException
 * <p>
 * join             将当前线程加入到父线程中，等该线程运行结束后父线程方可继续运行。
 * 如果中间被打断可以抛出InterruptedException
 * sleep    当前执行的线程睡眠指定时间，时间到了后线程恢复到可运行状态
 * 如果时间未到被打断，则抛出InterruptedException
 * 睡眠期间不释放监控器的拥有权，也就是不释放对象锁
 * 属于Thread类的静态方法，wait()属于Object的非静态方法并且是final的
 *
 * synchronized与
 * @author Administrator
 */
public class TestThread {
    public static volatile int race = 0;
    public static volatile AtomicInteger atomicInteger = new AtomicInteger(0);



    public static  void increase() {
//        race++;
        atomicInteger.getAndIncrement();
    }

    private static final int THREADS_COUNT = 20;

    public static  boolean  stopFlag = false;
//	static volatile Integer atomicInteger = new Integer(0);

    public static void main(String[] args) throws InterruptedException {
//        new Thread(()->{
//            while (!stopFlag){
//                try {
//                    Thread.sleep(1000);
//                    System.out.println("working...");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//        new Thread(()->{
//            try {
//                Thread.sleep(5000);
//                System.out.println("control ...");
//                stopFlag = true;
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
        CountDownLatch countDownLatch = new CountDownLatch(THREADS_COUNT);
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    increase();
                }
                countDownLatch.countDown();
            });
            threads[i].start();
        }
        countDownLatch.await();
        System.out.println("最后的结果：" + atomicInteger.get());
//		Vector<String> pool = new Vector<>();

//		AtomicInteger atomicInteger = new AtomicInteger(0);
//		Thread t1 = new Thread(new Producer(pool,atomicInteger));
//		Thread t2 = new Thread(new consumer(pool));
//		Thread t3 = new Thread(new consumer(pool));
//		Thread t4 = new Thread(new consumer(pool));
//		Thread t5 = new Thread(new Counter(atomicInteger,t1,t2,t3,t4));
//		t1.start();
//		t2.start();
//		t3.start();
//		t4.start();
//		t5.start();


//		Date start = new Date();
//		//运行4分钟后停止运行
//		ExecutorService consumers = Executors.newFixedThreadPool(7);
//		for(int i=0;i<6;i++){
//			consumers.submit(new consumer(pool));
//		}
//		consumers.submit(new Producer(pool));

//		Thread thread = new Thread(()->{System.out.println("kkk");
//		try {
//			System.out.println("lllll");
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println(e.getMessage());
//		}
//		}
//
//				);
//		thread.start();
//		thread.interrupt();
//		FutureTask<Integer> futureTask = new FutureTask<>(()-> System.out.println("ddd"),2);
//		FutureTask<Integer> futureTask = new FutureTask<>(new MyCallabel());
//		new Thread(futureTask).start();
//		boolean isDone = false;
//		while (!isDone){
//			System.out.println("working...");
//			isDone = futureTask.isDone();
//		}
//		System.out.println("working done" + futureTask.get());
    }

}


class Counter implements Runnable {
    Integer atomicInteger;
    Thread t1;
    Thread t2;
    Thread t3;
    Thread t4;

    public Counter(Integer atomicInteger, Thread t1, Thread t2, Thread t3, Thread t4) {
        this.atomicInteger = atomicInteger;
        this.t1 = t1;
        this.t2 = t2;
        this.t3 = t3;
        this.t4 = t4;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        while (true) {
            System.out.println("stop the thread" + atomicInteger);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (atomicInteger.intValue() > 3) {
                System.out.println("stop the thread ooooo");
                t1.interrupt();
                t2.interrupt();
                t3.interrupt();
                t4.interrupt();
                break;
            }
        }
    }
}

class MyCallabel implements Callable<Integer> {

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public Integer call() throws Exception {
        return 123;
    }
}

class consumer implements Runnable {
    private Vector<String> pool;

    public consumer(Vector<String> pool) {
        this.pool = pool;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
            synchronized (pool) {
                if (pool != null && pool.size() > 0) {
                    System.out.println(Thread.currentThread().getName() + "消费了 " + pool.get(pool.size() - 1));
                    pool.remove(pool.size() - 1);

                    try {
                        pool.wait(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return;
                    }

                } else {
                    try {
                        pool.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return;
                    }
                }
            }
        }
    }
}

class Producer implements Runnable {
    private Vector<String> pool;
    Integer atomicInteger;

    public Producer(Vector<String> pool, Integer atomicInteger) {
        this.pool = pool;
        this.atomicInteger = atomicInteger;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
            synchronized (pool) {
                if (pool != null && pool.size() == 0) {
                    System.out.println("池子中没有元素了");
                    pool.add("111");
                    pool.add("222");
                    pool.add("333");
                    pool.add("444");
                    pool.add("555");
                    pool.add("666");
                    pool.add("777");
                    pool.add("888");
                    pool.add("999");
                    pool.add("aa");
                    pool.add("ss");
                    pool.add("ff");
                    pool.add("gg");
                    pool.add("hhh");
                    atomicInteger++;
                    System.out.println(Thread.currentThread().getName() + "池子中生产元素了" + atomicInteger.intValue());
                    pool.notify();
                }
            }
        }
    }
}