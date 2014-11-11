package jmp.concurrency.nonblocking;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;

/**
 * @author Mikalai_Lohach
 *
 */
public class MyThread implements Runnable {

    private AtomicInteger count = new AtomicInteger();

    @Override
    public void run() {
        for (int i = 1; i < 3; i++) {
            process(i);
            count.incrementAndGet();
        }
    }

    public int getCount() {
        return this.count.get();
    }

    private void process(int i) {
        try {
            Thread.sleep(i * 500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
