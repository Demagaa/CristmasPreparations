package org.christmas;

import java.util.concurrent.Semaphore;

/**
 * @author Aleksei Chursin
 */
public class Santa implements Runnable {
    private final Semaphore santaSemaphore;
    private final Semaphore elfSemaphore;
    private final Semaphore reindeerSemaphore;
    boolean isSleeping;

    public Santa(Semaphore santaSemaphore, Semaphore elfSemaphore, Semaphore reindeerSemaphore) {
        this.santaSemaphore = santaSemaphore;
        this.elfSemaphore = elfSemaphore;
        this.reindeerSemaphore = reindeerSemaphore;
    }

    @Override
    public void run() {
        while (true) {
            sleep();
            try {
                santaSemaphore.acquire();
                if (reindeerSemaphore.availablePermits() == 0) {
                    closeWorkshop();
                    break;
                } else {
                    help();
                }

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void help() {
        System.out.println("Santa: helping elves");
        elfSemaphore.release(3);
    }

    public void sleep() {
        System.out.println("Santa: going to sleep");
    }

    public void closeWorkshop() {
        System.out.println("Santa: closing workshop");
    }
}
