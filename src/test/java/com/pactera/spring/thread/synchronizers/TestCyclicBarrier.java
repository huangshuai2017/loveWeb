package com.pactera.spring.thread.synchronizers;

import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 测试CyclicBarrier
 * 1.CyclicBarrier在创建的时候指定一个count值，当该CyclicBarrier的await()方法被调用的次数等于count值
 * 并且调用该方法的线程也执行到该方法处后，如果全部的调用await()方法都执行到了该处，则进行后续的执行；
 * 2.也可以在创建CyclicBarrier的时候指定一个barrierAction，当所有的await()方法都执行到的时候，该barrierAction
 * 就会被执行；
 * 3.如果await()方法的调用次数小于CyclicBarrier的count值，则会一直等待；
 * 4.当所有的waiting线程都已经释放之后，我们可以继续使用CyclicBarrier
 */
public class TestCyclicBarrier {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier c = new CyclicBarrier(2,()->{
            System.out.println("kkkkkkkkkk");
            System.out.println(new Date());
        });
        new Thread(() -> {
            System.out.println("1a");
            try {
                c.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("1b");

        }).start();
        System.out.println("getParties:" + c.getNumberWaiting());
        System.out.println("getParties:" + c.getParties());
        c.await();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("2a");
                    /*try {
                        c.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }*/
                System.out.println("2b");
            }
        }).start();
        System.out.println("getParties:" + c.getNumberWaiting());
        System.out.println(3);
    }

}

