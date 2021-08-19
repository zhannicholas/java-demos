package ml.zhannicholas.concurrency.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class WaitNotifyProducerConsumer {
    static class MyBlockingQueue {
        private Queue buffer;
        private int max = 16;

        public MyBlockingQueue(int size) {
            this.buffer = new LinkedList();
            this.max = size;
        }

        public synchronized void put(Object o) throws InterruptedException {
            while (buffer.size() == max) {
                wait();    // 自动释放lock并等待空间
            }
            buffer.add(o);
            notifyAll();    // 唤醒消费者
        }

        public synchronized Object take() throws InterruptedException {
            while (buffer.size() == 0) {
                wait();   // 自动释放lock并等待数据
            }
            Object item = buffer.remove();
            notifyAll();    // 唤醒生产者
            return item;
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
