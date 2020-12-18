package bak.me;

/**
 * 死锁
 */
public class DeadLock {

    private Object lock1 = new Object();

    private Object lock2 = new Object();


    public void m1 () {
        synchronized (lock1) {
            System.out.println("m1 lock1");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock2) {
                System.out.println("m1 lock2");
            }
        }
    }


    public void m2 () {
        synchronized (lock2) {
            System.out.println("m2 lock2");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock1) {
                System.out.println("m2 lock1");
            }
        }
    }

    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();
        Thread a = new Thread(deadLock::m1);
        Thread b = new Thread(deadLock::m2);
        a.start();
        b.start();


    }
}
