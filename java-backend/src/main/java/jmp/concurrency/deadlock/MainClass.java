package jmp.concurrency.deadlock;

/**
 * @author Mikalai_Lohach
 *
 */
public class MainClass {

    public static void main(String[] args) throws InterruptedException {
        Object obj1 = new Object();
        Object obj2 = new Object();
        Object obj3 = new Object();

        Thread t1 = new Thread(new MyThread(obj1, obj2), "t1");
        Thread t2 = new Thread(new MyThread(obj2, obj3), "t2");
        Thread t3 = new Thread(new MyThread(obj3, obj1), "t3");

        t1.start();
        Thread.sleep(5000);
        t2.start();
        Thread.sleep(5000);
        t3.start();
    }
}
