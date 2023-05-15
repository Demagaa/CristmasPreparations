package org.christmas;

import java.util.concurrent.Semaphore;

/**
 * @author Aleksei Chursin
 */
public class Deer implements Runnable {
    int id;
    int time;
    int last;

    Semaphore sem;

    public Deer(int id, int last) {
        this.id = id;
        this.last = last;
        this.time = 500 + (int) Math.random() * 100 / 2;
    }

    @Override
    public void run() {
        if (this.id != last) {

            System.out.println("RD " + id + ": rstarted");


            try {
                sem.acquire();
                Thread.sleep(time);

                System.out.println("RD " + id + ":return home");

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            sem.release();

        } else {
            //TODO: wake up santa
        }


    }

    public void getHitched() {
        System.out.println("RD " + id + ":got hitched");
    }
}
