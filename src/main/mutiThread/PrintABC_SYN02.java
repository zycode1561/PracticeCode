package main.mutiThread;

public class PrintABC_SYN02 {
    private static int index = 1;

    public static void main(String[] args) {
        final Object lock = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    while (index % 3 != 1) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("a");
                    index++;
                    lock.notifyAll();
                }
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    while (index % 3 != 2) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("b");
                    index++;
                    lock.notifyAll();
                }
            }
        });
        Thread t3 = new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    while (index % 3 != 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("c");
                    index = 1;
                    lock.notifyAll();
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }
}
