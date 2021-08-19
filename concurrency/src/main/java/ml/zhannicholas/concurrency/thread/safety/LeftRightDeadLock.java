package ml.zhannicholas.concurrency.thread.safety;

/**
 * 可能出现顺序死锁
 */
public class LeftRightDeadLock {
    private final Object left = new Object();
    private final Object right = new Object();

    public void leftRight() {
        synchronized (left) {
            synchronized (right) {
                // doSomething();
            }
        }
    }

    public void rightLeft() {
        synchronized (right) {
            synchronized (left) {
                // doSomethingElse();
            }
        }
    }

    public static void main(String[] args) {
        LeftRightDeadLock lrdl = new LeftRightDeadLock();
        new Thread(lrdl::leftRight).start();
        new Thread(lrdl::rightLeft).start();
    }
}
