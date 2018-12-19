package com.pactera.spring.thread.synchronizers;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 测试信号量
 *
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
