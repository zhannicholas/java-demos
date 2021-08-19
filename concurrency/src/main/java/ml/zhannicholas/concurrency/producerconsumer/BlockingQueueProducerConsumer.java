package ml.zhannicholas.concurrency.producerconsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 基于阻塞队列实现的生产者/消费者模式
 */
public class BlockingQueueProducerConsumer {
    public static void main(String[] args) {
        BlockingQueue<Object> buffer = new ArrayBlockingQueue<>(10);

        Runnable producer = () -> {
            while (true) {
                try {
                    buffer.put(new Object());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable consumer = () -> {
            while (true) {
                try {
                    buffer.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(producer).start();
        new Thread(producer).start();
        new Thread(consumer).start();
        new Thread(consumer).start();
    }
}
