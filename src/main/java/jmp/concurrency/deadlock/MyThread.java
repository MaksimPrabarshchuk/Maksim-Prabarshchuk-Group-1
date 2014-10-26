package jmp.concurrency.deadlock;

import org.apache.log4j.Logger;

/**
 * @author Mikalai_Lohach
 *
 */
public class MyThread implements Runnable {

    private static final Logger LOG = Logger.getLogger("MyThread");

    private Object obj1;
    private Object obj2;

    public MyThread(Object obj1, Object obj2){
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        LOG.info(name + " lock on " + obj1);
        synchronized (obj1) {
            LOG.info(name + " lock on " + obj1);
            work();
            LOG.info(name + " lock on " + obj2);
            synchronized (obj2) {
                LOG.info(name + " lock on " + obj2);
                work();
            }
            LOG.info(name + " unlock " + obj2);
        }
        LOG.info(name + " unlock on " + obj1);
        LOG.info(name + " finished.");
    }

    private void work() {
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
