package jmp.concurrency.deadlock.fix;

/**
 * @author Mikalai_Lohach
 *
 */
public class MainClass {

    public static void main(String[] args) throws InterruptedException {
        MyObject obj1 = new MyObject("obj1");
        MyObject obj2 = new MyObject("obj2");
        MyObject obj3 = new MyObject("obj3");

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
