package com.pactera.spring.thread.synchronizers;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 测试线程池的线程创建流程
 * 结论：当提交一个任务到线程池的时候
 *       1.检查线程数目是不是小于核心线程数，小于核心线程数，不管核心线程是不是空闲都将创建新的线程执行任务
 *       2.如果不小于核心线程数，但是小于最大的线程数，则判断任务队列是否已满，如果任务队列未满，则将任务存进任务队列中
 *       3.如果任务队列已满，则继续创建新的线程
 *       4.如果队列已满，线程数已经达到最大值，则执行拒绝策略
 *       拒绝策略又分为四种：AbortPolicy 抛出一个RejectedExecutionException
 *                           CallerRunsPolicy  使父线程执行任务
 *                           DiscardPolicy 仅仅只是扔掉当前没有线程执行该任务的任务
 *                           DiscardOldestPolicy 扔掉等待最久的线程
 */
public class TestThreadPool {
    static ThreadPoolExecutor executorService;

    static {
        executorService = new ThreadPoolExecutor(3,
                6, 10000, TimeUnit.SECONDS, new ArrayBlockingQueue<>(2));
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            testkeepAliveTime();
            Thread.sleep(60000);
        }
    }

    /**
     * 测试线程池的keepAliveTime为0的效果
     * 为0是不是不会对空闲的线程销毁
     *
     */
    public static void testkeepAliveTime() {
        executorService.execute(() -> {
            System.out.println(Thread.currentThread().getName() + " running... getCorePoolSize" + executorService.getCorePoolSize());
            System.out.println(Thread.currentThread().getName() + " running... getPoolSize" + executorService.getPoolSize());
            System.out.println(Thread.currentThread().getName() + " running... Queue size " + executorService.getQueue().size());
        });

    }
}
