package jmp.concurrency.deadlock.fix;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyObject {

    private final String id;
    private Lock lock = new ReentrantLock();

    public MyObject(String id) {
        this.id = id;
    }

    public Lock getLock() {
        return lock;
    }

    @Override
    public String toString() {
        return id;
    }
}
