package ml.zhannicholas.concurrency.thread.stop;

/**
 * 使用 volatile 修饰状态变量，可以成功让线程停止的示例
 */
public class VolatileCanStop implements Runnable {
    private volatile boolean cancel = false;

    @Override
    public void run() {
        int num = 0;
        try {
            while (!cancel && num <= 1000000) {
                if (num % 10 == 0) {
                    System.out.println(num + "是10的倍数");
                }
                num++;
                Thread.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileCanStop vcs  = new VolatileCanStop();
        new Thread(vcs).start();
        Thread.sleep(3000);
        vcs.cancel = true;
    }
}
