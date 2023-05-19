package org.christmas;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author Aleksei Chursin
 */


/*TODO
*   1. How to make Elfs being aware of state of workshop
*   2. How to make Exact Elfs getting help by id
*   3. How to make Santa being aware of state of Deers
*   4. How to make Santa being aware if all Elfs have finished*/

public class Main {
    public static void main(String[] args) {
        int elfs = 5;
        int deers =3;
        Semaphore santaSemaphore = new Semaphore(0);
        Semaphore elfSemaphore = new Semaphore(3);
        Semaphore reindeerSemaphore = new Semaphore(deers);

        Santa santa = new Santa(santaSemaphore,elfSemaphore,reindeerSemaphore);
        Thread santaThread = new Thread(santa);
        santaThread.start();

        for (int i = 0; i < deers; i++){
            Deer deer = new Deer(i, santaSemaphore, reindeerSemaphore);
            Thread thread = new Thread(deer);
            thread.start();
        }
        for (int i = 0; i < elfs; i++){
            Elf elf = new Elf(i, santaSemaphore, elfSemaphore);
            Thread thread = new Thread(elf);
            thread.start();
        }
    }

}