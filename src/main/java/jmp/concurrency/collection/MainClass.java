package jmp.concurrency.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * @author Mikalai_Lohach
 *
 */
public class MainClass {

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(1);
        List<Integer> list = new ArrayList<>();

        Thread t1 = new Thread(new GenerateNumbers(semaphore, list));
        Thread t2 = new Thread(new CalculateAverage(semaphore, list));
        Thread t3 = new Thread(new SquareRoot(semaphore, list));

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
        System.out.println("Complete!");
    }
}
