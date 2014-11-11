package jmp.concurrency.collection;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;

import org.apache.log4j.Logger;

/**
 * @author Mikalai_Lohach
 *
 */
public class GenerateNumbers implements Runnable {

    private static final Logger LOG = Logger.getLogger("GenerateNumbers");

    private Semaphore semaphore;
    private List<Integer> values;

    public GenerateNumbers(Semaphore semaphore, List<Integer> values) {
        this.semaphore = semaphore;
        this.values = values;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            Random random = new Random();
            for (int i = 0; i < 3; i++) {
                values.add(random.nextInt(5));
            }
            values.forEach(x -> LOG.info(x));
            semaphore.release();
        } catch (InterruptedException e) {
            LOG.error(e.getMessage());
        }
    }
}
