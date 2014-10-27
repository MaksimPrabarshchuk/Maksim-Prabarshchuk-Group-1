package jmp.concurrency.deadlock.fix;

import org.apache.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class MyThread implements Runnable {

    public static final int WAIT_SECONDS = 10;
    private static final Logger LOG = Logger.getLogger("MyThread");
    private final MyObject obj1;
    private final MyObject obj2;

    public MyThread(MyObject obj1, MyObject obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    @Override
    public void run() {
        try {
            if (obj1.getLock().tryLock(WAIT_SECONDS, TimeUnit.SECONDS)) {
                work(obj1);
                if (obj2.getLock().tryLock(WAIT_SECONDS, TimeUnit.SECONDS)) {
                    work(obj2);
                } else {
                    LOG.warn("Can't lock object " + obj2);
                }
            } else {
                LOG.warn("Can't lock object " + obj1);
            }
        } catch (InterruptedException e) {
            LOG.error(e.getMessage(), e);
        }
        String name = Thread.currentThread().getName();
        LOG.info(name + " finished.");
    }

    private void work(MyObject object) {
        String name = Thread.currentThread().getName();
        try {
            LOG.info(name + " lock on " + object);
            object.getLock().lock();
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            LOG.error(e.getMessage(), e);
        } finally {
            LOG.info(name + " unlock on " + object);
            object.getLock().unlock();
        }
    }
}
