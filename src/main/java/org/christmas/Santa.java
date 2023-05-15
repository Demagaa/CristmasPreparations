package org.christmas;

/**
 * @author Aleksei Chursin
 */
public class Santa implements Runnable{
    @Override
    public void run() {
        sleep();
    }
    public void help(){
        System.out.println("Santa: helping elves");
    }

    public void sleep(){
        System.out.println("Santa: going to sleep");
    }
}
