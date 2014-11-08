package jmp.concurrency.collection;

import java.util.List;
import java.util.concurrent.Semaphore;

import org.apache.log4j.Logger;

/**
 * @author Mikalai_Lohach
 *
 */
public class SquareRoot implements Runnable {

    private static final Logger LOG = Logger.getLogger("SquareRoot");

    private Semaphore semaphore;
    private List<Integer> values;

    public SquareRoot(Semaphore semaphore, List<Integer> values) {
        this.semaphore = semaphore;
        this.values = values;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            LOG.info("SquareRoot : " + Math.sqrt(
                    values.stream().reduce((acc, item) -> acc + (item * item)).get()));
            semaphore.release();
        } catch (InterruptedException e) {
            LOG.error(e.getMessage());
        }
    }
}
