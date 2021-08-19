package ml.zhannicholas.concurrency.thread.stop;

/**
 * 停止线程示例
 */
public class StopThread {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                int count = 0;
                while (!Thread.currentThread().isInterrupted() && count < 1000) {
                    System.out.println("count = " + (count++));
                }
            }
        });
        t.start();
        Thread.sleep(5);
        t.interrupt();
    }
}
