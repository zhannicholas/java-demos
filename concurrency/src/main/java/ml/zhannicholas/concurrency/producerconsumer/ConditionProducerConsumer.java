package ml.zhannicholas.concurrency.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionProducerConsumer {
    static class MyBlockingQueue {
        private Queue buffer;
        private int max = 16;
        private ReentrantLock lock = new ReentrantLock();
        private Condition notEmpty = lock.newCondition();   // 队列没空
        private Condition notFull = lock.newCondition();    // 队列没满

        public MyBlockingQueue(int size) {
            this.buffer = new LinkedList();
            this.max = size;
        }

        public void put(Object o) throws InterruptedException {
            lock.lock();
            try {
                while (buffer.size() == max) {
                    notFull.await();    // 自动释放lock并等待空间
                }
                buffer.add(o);
                notEmpty.signalAll();   // 唤醒消费者
            } finally {
                lock.unlock();
            }
        }

        public Object take() throws InterruptedException {
            lock.lock();
            try {
                while (buffer.size() == 0) {
                    notEmpty.await();   // 自动释放lock并等待数据
                }
                Object item = buffer.remove();
                notFull.signalAll();    // 唤醒生产者
                return item;
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        MyBlockingQueue buffer = new MyBlockingQueue(10);

        Runnable producer = () -> {
            for (int i = 0; i < 100; i++) {
                try {
                    buffer.put(new Object());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable consumer = () -> {
            for (int i = 0; i < 100; i++) {
                try {
                    buffer.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
