package bak.me;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 生产者/消费者
 */
public class ProCon {
    public static void main(String[] args) {
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>(100);

        Thread product = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(100);
                    queue.put(i);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });



        Thread consumer = new Thread(()->{
            while (true) {
                try {
                    Thread.sleep(1);
                    System.out.println(queue.take());
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        product.start();
        consumer.start();

    }
}
