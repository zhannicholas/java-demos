package ml.zhannicholas.concurrency.thread.stop;

/**
 * 停止线程示例
 */
public class StopDuringSleep {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int count = 0;
                    while (!Thread.currentThread().isInterrupted() && count < 1000) {
                        System.out.println("count = " + (count++));
                        Thread.sleep(1000000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
        Thread.sleep(5);
        t.interrupt();
    }
}
