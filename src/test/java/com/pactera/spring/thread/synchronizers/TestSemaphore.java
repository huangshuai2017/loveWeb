package com.pactera.spring.thread.synchronizers;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 测试信号量
 * 主要用在资源的访问控制上，也就是流量控制。
 * 比如限制数据库的链接数或者指定资源的链接数，同一时刻只有指定的数量链接
 * 1.构造函数可以指定许可证的数量以及获取许可证的策略，策略分为公平和不公平：
 *     公平策略：就是先申请许可证的先获得，这可以保证所有的链接都能获取到许可证，但是吞吐量会降低
 *     不公平策略：吞吐量优先的情况下，不公平策略要好于公平策略。
 *     默认是非公平策略Semaphore(N);
 *     也可以指定策略Semaphore(int permits, boolean fair)
 * 2.主要方法：
 *     acquire() 从信号量获取许可证，获取后信号量中可以用的许可证数量减一。获取许可证后可以执行程序，如果没有可以使用的许可证则阻塞直到有可用的
 *               许可证，如果被打断则抛异常，
 *     release() 释放许可证，归还许可证到信号量，增加一个可用的信号量许可证；
 *     还有许多重载的以上方法和其他功能辅助性的方法
 * 3.使用：
 *      3.1 获取资源前先获取许可证
 *      3.2使用完资源后释放许可证
 *      见例子
 * 4.原理 使用AQS并基于CAS原理
 */
public class TestSemaphore {
    public static void main(String[] args) {
        final int Max_Thread = 100;
        Semaphore semaphore = new Semaphore(10);
        ExecutorService executorService = Executors.newFixedThreadPool(Max_Thread);
        for (int i = 0; i < Max_Thread; i++) {
            executorService.execute(()->{
                System.out.println("start...");
                try {
                    semaphore.acquire();
                    System.out.println( Thread.currentThread().getName() + " play..." + new Date());
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
    }
}
