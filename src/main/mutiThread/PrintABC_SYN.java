package main.mutiThread;

public class PrintABC_SYN {
    public static class ThreadPrinter implements Runnable{

        private String name;
        private Object pre;
        private Object self;

        ThreadPrinter(String name, Object pre, Object self){
            this.name = name;
            this.pre = pre;
            this.self = self;
        }

        @Override
        public void run() {
            int count = 10;
            while(count > 0){
                synchronized(pre){
                    synchronized(self){
                        System.out.print(name);
                        count--;
                        self.notifyAll();
                    }
                    try{
                        if(count == 0){
                            pre.notifyAll();
                        }else{
                            pre.wait();
                        }
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        ThreadPrinter pa = new ThreadPrinter("A", c, a);
        ThreadPrinter pb = new ThreadPrinter("B", a, b);
        ThreadPrinter pc = new ThreadPrinter("C", b, c);

        new Thread(pa).start();
        Thread.sleep(10);// 保证初始ABC的启动顺序
        new Thread(pb).start();
        Thread.sleep(10);
        new Thread(pc).start();
        Thread.sleep(10);

    }

}
