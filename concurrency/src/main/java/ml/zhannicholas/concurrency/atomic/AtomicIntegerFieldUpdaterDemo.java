package ml.zhannicholas.concurrency.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomicIntegerFieldUpdaterDemo implements Runnable {
    IntegerWrapper wrapper1 = new IntegerWrapper();
    IntegerWrapper wrapper2 = new IntegerWrapper();

    static AtomicIntegerFieldUpdater<IntegerWrapper> atomicIntegerFieldUpdater = AtomicIntegerFieldUpdater.newUpdater(IntegerWrapper.class, "value");

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            wrapper1.value++;
            atomicIntegerFieldUpdater.getAndIncrement(wrapper2);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicIntegerFieldUpdaterDemo demo = new AtomicIntegerFieldUpdaterDemo();
        Thread t1 = new Thread(demo), t2 = new Thread(demo);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("wrapper1.value = " + demo.wrapper1.value);
        System.out.println("wrapper2.value = " + demo.wrapper2.value);
    }

    static class IntegerWrapper {
        volatile int value;
    }
}
