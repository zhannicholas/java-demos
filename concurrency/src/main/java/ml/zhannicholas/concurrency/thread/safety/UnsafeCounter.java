package ml.zhannicholas.concurrency.thread.safety;

/**
 * 线程不安全会导致运行结果错误
 */
public class UnsafeCounter {
    private static volatile int count = 0;

    public static void main(String[] args) throws InterruptedException {
        Runnable r = () -> {
            for (int i = 0; i < 1000; i++) {
                count++;
            }
        };

        Thread t1 = new Thread(r);
        t1.start();
        Thread t2 = new Thread(r);
        t2.start();
        // 等待两个线程运行结束
        t1.join();
        t2.join();
        System.out.println("count = " + count);
    }
}
