package main.mutiThread;

/**
 * @author ZhangYun
 * @version 1.0
 * @date 2020/4/16
 */
public class MyThreadDemo {
    public static void main(String[] args) {

        MyThreadDemo myThreadDemo = new MyThreadDemo();
        Thread t = new Thread(myThreadDemo.runnable);
        t.start();
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            System.out.println("In main");
            e.printStackTrace();
        }
        System.out.println("我醒了");
        //阻塞线程调用interrupt方法会抛出异常
        t.interrupt();


    }

    private Runnable runnable = ()->{
        int i = 0;
        try{
            while(i < 1000){
                Thread.sleep(500);
                System.out.println(i++);
            }
        }catch (InterruptedException e){
            System.out.println(Thread.currentThread().isAlive());
            System.out.println(Thread.currentThread().isInterrupted());
            System.out.println("In Runnable");
            e.printStackTrace();
        }
    };
}


