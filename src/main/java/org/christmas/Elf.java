package org.christmas;

/**
 * @author Aleksei Chursin
 */
public class Elf implements Runnable{
    int id;
    int time;

    public Elf(int id) {
        this.id = id;
        this.time = (int) Math.random()*100;
    }

    @Override
    public void run() {
        System.out.println("Elf " + id + ": started");
        synchronized (this) {
            try {
                wait(time);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Elf " + id + ": need help");

        }
    }

    public void getHelp(){
        System.out.println("Elf " + id + ": get help ");
    }

    public void holidays(){
        System.out.println("Elf " + id + ": taking holidays");
    }
}

