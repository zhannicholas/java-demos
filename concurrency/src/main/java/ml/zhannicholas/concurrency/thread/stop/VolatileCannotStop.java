package ml.zhannicholas.concurrency.thread.stop;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 使用 volatile 修饰状态标记，但是不能让线程正常停止的例子
 */
public class VolatileCannotStop {
    static class Producer implements Runnable {
        public volatile  boolean canceled = false;
        private BlockingQueue<Integer> storage;
        public Producer(BlockingQueue<Integer> storage) {
            this.storage = storage;
        }

        @Override
        public void run() {
            int num = 0;
            try {
                while (num <= 100000 && !canceled) {
                    if (num % 50 == 0) {
                        storage.put(num);
                        System.out.println(num + "是50的倍数，放入仓库");
                    }
                    num++;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("生产者结束运行");
            }
        }
    }

    static class Consumer {
        BlockingQueue storage;
        public Consumer(BlockingQueue storage) {
            this.storage = storage;
        }

        public boolean needMoreNums() {
            return Math.random() > 0.97;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue storage = new ArrayBlockingQueue(8);

        Producer producer = new Producer(storage);
        new Thread(producer).start();
        Thread.sleep(500);

        Consumer consumer = new Consumer(storage);
        while (consumer.needMoreNums()) {
            System.out.println(consumer.storage.take() + "被消费了");
            Thread.sleep(100);
        }
        System.out.println("消费者不需要更多数据了");

        // 一旦消费者不需要更多数据了，我们就应该让生产者停下来，然而实际情况却是生产者停不下类
        producer.canceled = true;
        System.out.println(producer.canceled);
    }
}
