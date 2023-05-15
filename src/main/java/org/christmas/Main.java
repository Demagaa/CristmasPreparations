package org.christmas;

/**
 * @author Aleksei Chursin
 */
public class Main {
    public static void main(String[] args) {
        int elfs = 5;
        int deers =4;

        for (int i = 0; i < deers; i++){
            Deer deer = new Deer(i, deers);
            Thread thread = new Thread(deer);
            thread.start();
        }
        for (int i = 0; i < elfs; i++){
            Elf elf = new Elf(i);
            Thread thread = new Thread(elf);
            thread.start();
        }
    }

}