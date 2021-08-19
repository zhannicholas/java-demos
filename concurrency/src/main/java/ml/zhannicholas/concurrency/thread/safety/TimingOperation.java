package ml.zhannicholas.concurrency.thread.safety;

public class TimingOperation {
    private static volatile int x = 1;

    public static void main(String[] args) throws InterruptedException {
        Runnable r = () -> {
            if (x == 1) {
                x  = x * 3;
            }
        };

        for (int i = 0; i < 1000; i++) {
            new Thread(r).start();
        }
        System.out.println(x);
    }
}
