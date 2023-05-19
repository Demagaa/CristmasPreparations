package org.christmas;

import java.util.concurrent.Semaphore;

/**
 * @author Aleksei Chursin
 */
public class Deer implements Runnable {
    int id;
    int time;
    int last;
    int deers;
    private final Semaphore santaSemaphore;
    private final Semaphore reindeerSemaphore;

    public Deer(int id, Semaphore santaSemaphore, Semaphore reindeerSemaphore) {
        this.id = id;
        this.time = 500 + (int) Math.random() * 100 / 2;
        this.santaSemaphore = santaSemaphore;
        this.reindeerSemaphore = reindeerSemaphore;

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(time);
                System.out.println("Reindeer " + id + " returned from vacation.");
                reindeerSemaphore.acquireUninterruptibly();
                if (reindeerSemaphore.availablePermits() == 0) {
                    santaSemaphore.release();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public void getHitched() {
        System.out.println("RD " + id + ":got hitched");
    }
}
