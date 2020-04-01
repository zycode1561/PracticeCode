package main.mutiThread;

import java.util.concurrent.locks.LockSupport;

/**
 * park和unpark相当于给了线程一个标志性的许可证，和wait和notify不同
 * 如果notify先于wait执行，线程就不会被唤醒，而unpark就相当于给了线程一个许可
 * unpark先于park执行时，线程也会识别这个标志，不会进入等待，继续执行
 * 但是需要注意的是，unpark就算执行多次，也只有一次有效，对于多次park是没用的
 * park不会释放锁，如果在同步代码快中，会造成死锁
 * wait会自动释放锁,在同步代码快2中不会造成死锁
 * 注意：我们应该使用while循环来检查等待条件，
 * 原因是处于等待状态的线程可能会收到错误警报或者是伪唤醒
 * 如果不再循环中检查等待条件，程序就会在没有满足结束条件的情况下退出
 */
public class ParkMethod {
    private static Object market = null;
    private static void parkUnParkTest() throws InterruptedException {
        Thread consumerThread = new Thread(()->{
            while(market == null){
                try {
                    Thread.sleep(5000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("进入等待");
                LockSupport.park();
            }
            System.out.println("买到物品，回家");
        });
        consumerThread.start();
        Thread.sleep(3000L);
        market = new Object();
        LockSupport.unpark(consumerThread);
        System.out.println("商店开门，通知消费者");
    }

    public static void main(String[] args) throws InterruptedException {
        parkUnParkTest();
    }
}
