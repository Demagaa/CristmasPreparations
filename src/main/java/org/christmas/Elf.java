package org.christmas;

import java.util.concurrent.Semaphore;

/**
 * @author Aleksei Chursin
 */
public class Elf implements Runnable{
    int id;
    int time;
    Semaphore sem;
    private final Semaphore santaSemaphore;
    private final Semaphore elfSemaphore;

    Santa santa;

    public Elf(int id, Semaphore santaSemaphore, Semaphore elfSemaphore) {
        this.id = id;
        this.time = (int) Math.random()*100;
        this.santaSemaphore = santaSemaphore;
        this.elfSemaphore = elfSemaphore;

    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Av perms: " + elfSemaphore.availablePermits());

                System.out.println("Elf " + id + ": started");

                elfSemaphore.acquireUninterruptibly();

                Thread.sleep(time);

                if (elfSemaphore.availablePermits() == 0) {
                    getHelp();
                }

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public void getHelp(){
        System.out.println("Elf " + id + ": need help ");
        santaSemaphore.release();
    }

    public void holidays(){
        System.out.println("Elf " + id + ": taking holidays");
    }
}

