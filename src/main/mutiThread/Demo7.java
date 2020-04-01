package main.mutiThread;

/**
 * ThreadLocal会为每个线程维护一个变量副本，使得每个线程都拥有了自己独立的一个变量
 * 在并发模式下是绝对安全的变量
 * 每一个线程都维护了一个ThreadLocalMap<Thread,T>，是一个内部类，每个线程要使用这个变量的时候都会从这个map中取
 */
public class Demo7 {
    private static ThreadLocal<String> value = new ThreadLocal<>();

    private static void threadLocalTest() throws Exception{
        value.set("我是你爹");
        String v = value.get();
        System.out.println("主线程说："+v);

        new Thread(()->{
           String sv = value.get();
            System.out.println("线程1说：我听到你说的是："+sv);
            value.set("叫爸爸");
            sv = value.get();
            System.out.println("线程1又说："+sv);
            System.out.println("线程1执行结束");
        }).start();
        Thread.sleep(3000L);
        v = value.get();
        System.out.println("主线程说：我说的是："+v);
    }

    public static void main(String[] args) throws Exception {
        threadLocalTest();
    }
}
