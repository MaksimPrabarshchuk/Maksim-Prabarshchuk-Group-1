package jmp.concurrency.collection;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;

import org.apache.log4j.Logger;

/**
 * @author Mikalai_Lohach
 *
 */
public class CalculateAverage implements Runnable {

    private static final Logger LOG = Logger.getLogger("CalculateAverage");

    private Semaphore semaphore;
    private List<Integer> values;

    public CalculateAverage(Semaphore semaphore, List<Integer> values) {
        this.semaphore = semaphore;
        this.values = values;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            LOG.info("Sum : " + values.stream().reduce((acc, item) -> acc + item).get());
            semaphore.release();
        } catch (InterruptedException e) {
            LOG.error(e.getMessage());
        }
    }
}
