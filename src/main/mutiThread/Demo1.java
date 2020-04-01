package main.mutiThread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 方法：
 *  lock：获取锁的方法，若锁被其他线程获取，则等待
 *  tryInterruptibly，在锁的获取过程中可以中断当前线程
 *  tryLock：尝试非阻塞的获取锁，立即返回
 *  unlock释放锁
 */
public class Demo1 {

    private static final Lock LOCK = new ReentrantLock();


}
