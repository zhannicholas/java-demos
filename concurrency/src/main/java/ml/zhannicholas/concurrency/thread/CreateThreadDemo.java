package ml.zhannicholas.concurrency.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

/**
 * 创建新线程的方式
 */
public class CreateThreadDemo {
    static class ExtendsThread extends Thread {
        @Override
        public void run() {
            System.out.println("通过继承 Thread 类来实现线程");
        }
    }

    static class RunnableThread implements Runnable {
        @Override
        public void run() {
            System.out.println("通过实现 Runnable 接口来实现线程");
        }
    }

    static class CallableTask implements Callable<Long> {
        @Override
        public Long call() throws Exception {
            System.out.println("通过实现 Callable 接口来实现线程");
            return System.currentTimeMillis();
        }
    }




    public static void main(String[] args) {
        new ExtendsThread().start();
        new Thread(new RunnableThread()).start();
        Executors.newSingleThreadExecutor().submit(new CallableTask());
    }
}
